package org.example.DesignPatterns.Visitor;

public class JrDoctor implements Person{
    @Override
    public void diagnoseChildPatient() {
        System.out.println("Jr Doctor Diagnosing child Patient");
    }

    @Override
    public void diagnoseOrthoPatient() {

    }
}
