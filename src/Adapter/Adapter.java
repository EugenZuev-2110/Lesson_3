package Adapter;

class Square {
    private double side;
    
    public Square() {
    	
    }
    
    public Square(double side) {
    	this.side = side; 
    }
    
    public double getSide() {
    	return side; 
    }
}

class Round {
    private double radius;
    
    public Round(double radius) {
    	this.radius = radius; 
    }
    
    public double getRadius() {
    	return radius; 
    }
}