package Strategy;

interface Payment {
    void processPayment(double amount);
}

class CardPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Оплачено " + amount + " картой");
    }
}

class BitcoinPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Оплачено " + amount + " биткоинов");
    }
}

class Order {
    private Payment payment;
    private double amount;

    public Order(int amount) {
    	this.amount = amount; 
    }
    
    public void setPayment(Payment payment) {
    	this.payment = payment; 
    }

    public void pay() {
        if (payment == null) {
        	System.out.println("Выберите способ оплаты");
        }
        else payment.processPayment(amount);
    }
}

public class Strategy {
    public static void main(String[] args) {
        Order order = new Order(12500);
        order.setPayment(new CardPayment());
        order.pay();
        order.setPayment(new BitcoinPayment());
        order.pay();
    }
}