public class BankAccount {
    protected int id;
    protected double balance;
    protected String fullName;
    protected String extract;

    BankAccount(double balance, String fullname){
        this.balance = balance;
        this.fullName = fullname;
    }

    BankAccount(){
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getFullName() {
        return fullName;
    }
}
