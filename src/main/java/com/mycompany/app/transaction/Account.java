import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transitionList;

    public Account() {
        transitionList = new ArrayList<Transaction>();
    }

    private double deposit;
    private double withdraw;
    /**
     * 
     * @param amount
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }
    /**
     * 
     * @param amount
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * 
     * @param amount
     * @param operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));

        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Just Println
     */
    public void printTransaction() {
        int dem = 1;
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich " + dem + ": Nap tien $"
                        +
                        String.format("%.2f", transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", transitionList.get(i).getBalance()) + ".\n");
            } else {
                System.out.printf("Giao dich " + dem + ": Rut tien $"
                        + String.format("%.2f", transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", transitionList.get(i).getBalance()) + ".\n");
            }
            dem++;
        }
    }

}