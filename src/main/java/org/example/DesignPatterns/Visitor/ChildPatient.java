package org.example.DesignPatterns.Visitor;

public class ChildPatient implements Patient{
    @Override
    public void diagnose(Person person) {
        person.diagnoseChildPatient();
    }
}
