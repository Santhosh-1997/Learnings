package org.example.DesignPatterns.TemplateDesignPattern;

public abstract class Beverage {

    public void prepare(){
        boilWater();
        addCondiments();
        brew();
        pourInCup();
    }
    private void boilWater(){
        System.out.println("Water boiled");
    }

    protected abstract void brew();
    protected abstract void addCondiments();
    private void pourInCup(){
        System.out.println("Pour it in cup");
    }

}
