package com.example.demo7.MC;

public class lebanais implements MainCourses{
    String name;
    int price;
    lebanais(){
        System.out.println("Lebanais Meal created");
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
