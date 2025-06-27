package org.example.DesignPatterns.Visitor;

public class SrDoctor implements Person{
    @Override
    public void diagnoseChildPatient() {
        System.out.println("Sr Doctor diagnosing the Patient");
    }

    @Override
    public void diagnoseOrthoPatient() {

    }
}
