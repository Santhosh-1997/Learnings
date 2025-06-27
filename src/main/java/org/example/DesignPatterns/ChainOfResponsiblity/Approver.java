package org.example.DesignPatterns.ChainOfResponsiblity;

public abstract class Approver {
    protected Approver nextApprover;
    void setNextApprover(Approver approver){
        this.nextApprover = approver;
    }

    abstract void approveLeave(int days);
}
