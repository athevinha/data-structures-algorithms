import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * NAP TIEN
     * @param amount
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(amount, Transaction.DEPOSIT);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * RUT TIEN
     * @param amount
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                addTransaction(amount, Transaction.WITHDRAW);
            } else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * ADD TX
     * @param amount
     * @param operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT) || operation.equals(Transaction.WITHDRAW)) {
            Transaction transaction = new Transaction(operation, amount, balance);
            transactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print
     */
    public void printTransaction() {
        System.out.println("Transaction History:");
        int transactionNumber = 0;

        for (Transaction transaction : transactions) {
            transactionNumber++;
            String txt = "Nap tien";
            if(transaction.getOperation().equals(Transaction.WITHDRAW)) txt = "Rut Tien";
            System.out.println("Giao dich " + transactionNumber + ": " +
                    txt + " $" +
                    String.format("%.2f", transaction.getAmount()) + ". " +
                    "So du luc nay: $" +
                    String.format("%.2f", transaction.getBalance()) + ".");
        }
    }


    // Getter for the balance
    private ArrayList<Transaction> transitionList(){
        return transactions;
    }
    /**
     * asd
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
}

