package com.semiboard.dependencyexample;

public interface Food{
    void eat();
}

class Chicken implements Food{
    @Override
    public void eat() {
        System.out.println("Chicken eat");
    }
}

class Pizza implements Food{
    @Override
    public void eat() {
        System.out.println("Pizza eat");
    }
}

class Burger implements Food{
    @Override
    public void eat() {
        System.out.println("Burger eat");
    }
}