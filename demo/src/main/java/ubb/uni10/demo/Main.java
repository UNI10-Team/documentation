package ubb.uni10.demo;

import ubb.uni10.demo.entity.Pizza;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> toppings = Arrays.asList("Corn", "Ananas", "Bacon");
        Pizza pizza = Pizza.builder()
                .price(100)
                .toppings(toppings)
                .topping("Mushroom")
                .topping("Tomato")
                //.sauce("Mayo")
                .build();
        System.out.println(pizza);
    }
}
