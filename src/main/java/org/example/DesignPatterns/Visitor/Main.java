package org.example.DesignPatterns.Visitor;

public class Main {
    public static void main(String[] args) {
        Patient patient = new ChildPatient();
        patient.diagnose(new SrDoctor());
    }
}
