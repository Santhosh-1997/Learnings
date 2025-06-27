package org.example.DesignPatterns.ChainOfResponsiblity;

public class Manager extends Approver{
    @Override
    void approveLeave(int days) {
        if(days < 10) {
            System.out.println("Manager approved leave");
        }else if(this.nextApprover != null) {
            nextApprover.approveLeave(days);
        }
    }
}
