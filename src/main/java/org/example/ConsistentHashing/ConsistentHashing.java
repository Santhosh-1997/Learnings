package org.example.ConsistentHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConsistentHashing {
    private Set<String> servers;
    private int replicas;
    private TreeMap<Long, String> ring;

    public ConsistentHashing(List<String> servers, int replicas) {
        this.servers = new HashSet<>();
        this.replicas = replicas;
        this.ring = new TreeMap<>();

        for(String server : servers){
            addServer(server);
        }
    }

    private long hash(String key){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            return ((long) (digest[0] & 0xFF) << 24) |
                    ((long) (digest[1] & 0xFF) << 16) |
                    ((long) (digest[2] & 0xFF) << 8) |
                    ((long) (digest[3] & 0xFF));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public void addServer(String server){
        this.servers.add(server);
        for(int i=0; i<replicas; i++){
            long hash = hash(server + "-" + i);
            ring.put(hash, server);
        }
    }

    public void removeServer(String server){
        if(servers.remove(server)){
            for(int i=0; i<replicas; i++){
                long hash = hash(server + "-" + i);
                ring.remove(hash);
            }
        }
    }

    public String getServer(String key){
        if(ring.isEmpty())  //no server available
            return null;

        long hash = hash(key);

        Map.Entry<Long, String> entry = ring.ceilingEntry(hash);
        if(entry == null){
            ring.firstEntry();
        }
        return entry.getValue();
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("s1", "s2", "s3", "s4", "s5");
        ConsistentHashing consistentHashing = new ConsistentHashing(servers, 3);

        System.out.println(consistentHashing.getServer("userA"));

        consistentHashing.addServer("s6");
        System.out.println(consistentHashing.getServer("userA"));

        consistentHashing.removeServer("s2");
        System.out.println(consistentHashing.getServer("userA"));
    }
}
