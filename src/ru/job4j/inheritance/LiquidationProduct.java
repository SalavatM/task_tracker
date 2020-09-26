package ru.job4j.inheritance;

//композиция
public final class LiquidationProduct {
    private String name;
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
        //super(name, price);
        //this.name = name;
    }

    //@Override
    public int discount() {
        return 90;
    }

    //@Override
    public String label() {
        return product.label();
        //return name + " (with discount): " + price();
    }
}
