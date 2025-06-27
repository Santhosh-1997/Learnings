package org.example.DesignPatterns.TemplateDesignPattern;

public class Coffee extends Beverage{
    @Override
    protected void brew() {
        System.out.println("Brewing Coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Added Coffee and Sugar");
    }
}
