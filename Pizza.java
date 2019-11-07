package ubb.uni10.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private List<String> toppings;
    private String sauce;
    private long radius;
    private int price;
    private boolean isSpecialOffer;

    private static String $default$sauce() {
        return "Ketchup";
    }

    Pizza(final List<String> toppings, final String sauce, final long radius, final int price, final boolean isSpecialOffer) {
        this.toppings = toppings;
        this.sauce = sauce;
        this.radius = radius;
        this.price = price;
        this.isSpecialOffer = isSpecialOffer;
    }

    public static Pizza.PizzaBuilder builder() {
        return new Pizza.PizzaBuilder();
    }

    public static class PizzaBuilder {
        private ArrayList<String> toppings;
        private boolean sauce$set;
        private String sauce$value;
        private long radius;
        private int price;
        private boolean isSpecialOffer;

        PizzaBuilder() {
        }

        public Pizza.PizzaBuilder topping(final String topping) {
            if (this.toppings == null) {
                this.toppings = new ArrayList();
            }

            this.toppings.add(topping);
            return this;
        }

        public Pizza.PizzaBuilder toppings(final Collection<? extends String> toppings) {
            if (this.toppings == null) {
                this.toppings = new ArrayList();
            }

            this.toppings.addAll(toppings);
            return this;
        }

        public Pizza.PizzaBuilder clearToppings() {
            if (this.toppings != null) {
                this.toppings.clear();
            }

            return this;
        }

        public Pizza.PizzaBuilder sauce(final String sauce) {
            this.sauce$value = sauce;
            this.sauce$set = true;
            return this;
        }

        public Pizza.PizzaBuilder radius(final long radius) {
            this.radius = radius;
            return this;
        }

        public Pizza.PizzaBuilder price(final int price) {
            this.price = price;
            return this;
        }

        public Pizza.PizzaBuilder isSpecialOffer(final boolean isSpecialOffer) {
            this.isSpecialOffer = isSpecialOffer;
            return this;
        }

        public Pizza build() {
            List toppings;
            switch(this.toppings == null ? 0 : this.toppings.size()) {
            case 0:
                toppings = Collections.emptyList();
                break;
            case 1:
                toppings = Collections.singletonList(this.toppings.get(0));
                break;
            default:
                toppings = Collections.unmodifiableList(new ArrayList(this.toppings));
            }

            String sauce$value = this.sauce$value;
            if (!this.sauce$set) {
                sauce$value = Pizza.$default$sauce();
            }

            return new Pizza(toppings, sauce$value, this.radius, this.price, this.isSpecialOffer);
        }

        public String toString() {
            return "Pizza.PizzaBuilder(toppings=" + this.toppings + ", sauce$value=" + this.sauce$value + ", radius=" + this.radius + ", price=" + this.price + ", isSpecialOffer=" + this.isSpecialOffer + ")";
        }
    }
}
