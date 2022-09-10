package client;
import java.util.ArrayList;
import administration.BankManagement;
import administration.BankStatement;

public class BankAccount {
    protected int id;
    protected double balance;
    protected String fullName;
    protected String password;
    protected ArrayList<BankStatement> bankStatements = new ArrayList<BankStatement>();
    BankManagement bank = BankManagement.getInstance();

    BankAccount(String fullname, String password){
        this.balance = 0;
        this.fullName = fullname;
        this.password = password;
        this.id = IdCreator.createNewId();
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
