package client;

import administration.BankStatement;

public class Client extends BankAccount{
    public Client(String fullName, String password){
        super(fullName, password);
    }

    public void deposit(double value, String depositorName){
        if(value <= 0) System.out.println("Cannot deposit a value that is less or equal to 0");
        else {
            this.balance += value;
            BankStatement buffer = new BankStatement(1, depositorName, this.fullName, value);
            bankStatements.add(buffer);
            bank.addBankStatement(buffer);
        }
    }

    public void transfer(double value,int reciverId){
        if(value <= 0) System.out.println("Cannot transfer a value that is less or equal to 0");
        else {
            Client reciver = bank.find(reciverId);
            this.balance -= value;
            System.out.println("Value of " + value + " transfered to " + reciver.getFullName());
            BankStatement buffer = new BankStatement(2, this.fullName, reciver.fullName, value);
            reciver.deposit(value, reciver.getFullName());
            bankStatements.add(buffer);
            bank.addBankStatement(buffer);
        }
    }
    public void getBankStatement(){
        System.out.println("Bank statement for " + this.fullName + ": ");
        for(BankStatement c : this.bankStatements){
                System.out.println(c.toString());
            };
    }
    public String toString(){
        return "-\nName: " + this.fullName + "\nBalance: " + this.balance;
    }
    
    public boolean validPass(String password){
        return password.equals(this.password);
    }
}
