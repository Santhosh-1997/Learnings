package org.example.LLD.RateLimiter;

import java.time.Instant;

public class TokenBucket {
    private final long capacity;
    private final double fillRate;
    private double tokens;
    private Instant lastRefillTimeStamp;

    public TokenBucket(long capacity, double fillRate) {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.tokens = capacity;
        lastRefillTimeStamp = Instant.now();
    }

    public synchronized boolean allowRequest(){
        refill();
        if(this.tokens == 0)
            return false;
        this.tokens--;
        return true;
    }

    public void refill(){
        Instant now = Instant.now();
        double tokensToAdd = (double) (now.toEpochMilli() - lastRefillTimeStamp.toEpochMilli()) / 1000 * fillRate;
        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTimeStamp = Instant.now();
    }
}
