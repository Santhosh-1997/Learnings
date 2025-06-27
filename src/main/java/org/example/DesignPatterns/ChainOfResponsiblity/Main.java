package org.example.DesignPatterns.ChainOfResponsiblity;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Manager manager = new Manager();
        TeamLead teamLead = new TeamLead();
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);

        teamLead.approveLeave(5);
    }
}
