package Decorator;

interface Product {
    String getDescription();
    int getCost();
}

class Banana implements Product {
    public String getDescription() {
    	return "вкусный банан!"; 
    }
    
    public int getCost() {
    	return 150; 
    }
}

abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;
    
    public ProductDecorator(Product product) {
    	this.decoratedProduct = product; 
    }
}

class Milk extends ProductDecorator {
    public Milk(Product product) {
    	super(product); 
    }
    
    public String getDescription() {
    	return decoratedProduct.getDescription() + " + молоко"; 
    }
    
    public int getCost() {
    	return decoratedProduct.getCost() + 50; 
    }
}

class SugarDecorator extends ProductDecorator {
    public SugarDecorator(Product product) {
    	super(product); 
    }
    
    public String getDescription() {
    	return decoratedProduct.getDescription() + " + сахар"; 
    }
    
    public int getCost() { return decoratedProduct.getCost() + 20; }
}

public class Decorator {
    public static void main(String[] args) {
    	Product product = new Banana();
        System.out.println(product.getDescription() + " = " + product.getCost());

        product = new Milk(product);
        System.out.println(product.getDescription() + " = " + product.getCost());

        product = new SugarDecorator(product);
        System.out.println(product.getDescription() + " = " + product.getCost());
    }
}