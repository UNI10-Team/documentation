package ubb.uni10.demo.entity;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Pizza {

    @Singular private List<String> toppings;
    @Builder.Default private String sauce = "Ketchup";
    private long radius;
    private int price;
    private boolean isSpecialOffer;
}
