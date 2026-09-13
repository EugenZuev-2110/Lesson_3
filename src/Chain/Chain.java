package Chain;

abstract class Logger {
    private Logger next;

    public Logger setNext(Logger next) {
        this.next = next;
        return next;
    }

    public abstract void handle(String user, String password);

    protected void checkNext(String user, String password) {
        if (next != null) {
        	next.handle(user, password);
        }
    }
}

class UserCheck extends Logger {
    public void handle(String user, String password) {
        if (!"admin".equals(user)) {
            System.out.println("Пользователь не найден");
        } else {
            System.out.println("Пользователь зашел");
            checkNext(user, password);
        }
    }
}

class PasswordCheck extends Logger {
    public void handle(String user, String password) {
        if (!"1221".equals(password)) {
            System.out.println("Неверный пароль");
        } else {
            System.out.println("Пароль верный");
            checkNext(user, password);
        }
    }
}

class RoleCheck extends Logger {
    public void handle(String user, String password) {
        System.out.println("Доступ разрешен");
    }
}

public class Chain {
    public static void main(String[] args) {
        Logger chain = new UserCheck();
        chain.setNext(new PasswordCheck()).setNext(new RoleCheck());
        chain.handle("admin", "1221");
    }
}