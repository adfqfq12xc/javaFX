package com.example.demo7.MC;

public class Syrian implements MainCourses{
    String name;
    int price;
    Syrian(){
        System.out.println("Syrian Meal created");
    }
    @Override
    public void Setname(String s) {
        name=s;
    }

    @Override
    public void SetPrice(int s) {
        price=s;

    }

    @Override
    public void SetMeal(String s) {
        System.out.println(s);
    }
}
