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

class RoundAdapter extends Square {
    private Round round;

    public RoundAdapter(Round round) {
        this.round = round;
    }
    
    public double getSide() {
        return round.getRadius() * 2;
    }
}

class SquareHole {
    private double side;
    
    public SquareHole(double side) {
    	this.side = side; 
    }

    public boolean fits(Square square) {
        return this.side >= square.getSide();
    }
}