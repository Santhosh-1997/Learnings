package org.example.DesignPatterns.ChainOfResponsiblity;

public class Director extends Approver{
    @Override
    void approveLeave(int days) {
        if(days < 30){
            System.out.println("Director approved the leave");
        }else if(nextApprover != null){
            nextApprover.approveLeave(days);
        }else{
            System.out.println("Leave Denied");
        }

    }
}
