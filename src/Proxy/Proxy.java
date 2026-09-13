package Proxy;

interface Database {
    void connect();
}

class MySQL implements Database {
    public MySQL() {
        System.out.println("Запуск базы данных");
    }
    
    public void connect() {
        System.out.println("Подключение к БД");
    }
}

class DatabaseProxy implements Database {
    private MySQL mySQL;

    public void connect() {
    	mySQL = new MySQL();
        System.out.print("Подключение");
        mySQL.connect();
    }
}

public class Proxy {
    public static void main(String[] args) {
        Database db = new DatabaseProxy();        
        db.connect();
    }
}