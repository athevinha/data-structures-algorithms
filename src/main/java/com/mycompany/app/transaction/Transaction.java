/**
 * Lớp Transaction đại diện cho một giao dịch trong tài khoản ngân hàng.
 */
public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Khởi tạo một đối tượng Transaction với thông tin giao dịch.
     *
     * @param operation Loại giao dịch (DEPOSIT hoặc WITHDRAW).
     * @param amount Số tiền giao dịch.
     * @param balance Số dư sau giao dịch.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Trả về loại giao dịch.
     *
     * @return Loại giao dịch (DEPOSIT hoặc WITHDRAW).
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Thiết lập loại giao dịch.
     *
     * @param operation Loại giao dịch (DEPOSIT hoặc WITHDRAW).
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Trả về số tiền giao dịch.
     *
     * @return Số tiền giao dịch.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Thiết lập số tiền giao dịch.
     *
     * @param amount Số tiền giao dịch.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Trả về số dư sau giao dịch.
     *
     * @return Số dư sau giao dịch.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Thiết lập số dư sau giao dịch.
     *
     * @param balance Số dư sau giao dịch.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
