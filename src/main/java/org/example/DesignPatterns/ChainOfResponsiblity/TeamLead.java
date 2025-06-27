package org.example.DesignPatterns.ChainOfResponsiblity;

public class TeamLead extends Approver{
    @Override
    void approveLeave(int days) {
        if(days < 3){
            System.out.println("TL approved");
        }else if(this.nextApprover != null){
            nextApprover.approveLeave(days);
        }
    }
}
