package client;

import administration.BankStatement;

public class Client extends BankAccount{
    public Client(String fullName){
        super(fullName);
    }

    public void deposit(double value, String depositorName){
        if(value <= 0) System.out.println("Cannot deposit a value that is less or equal to 0");
        else {
            this.balance += value;
            System.out.println("Value of " + value + " deposited by " + depositorName);
            BankStatement buffer = new BankStatement(1, depositorName, this.fullName, value);
            bankStatements.add(buffer);
        }
    }

    public void transfer(double value, Client reciver){
        if(value <= 0) System.out.println("Cannot transfer a value that is less or equal to 0");
        else {
            this.balance -= value;
            System.out.println("Value of " + value + " transfered to " + reciver.getFullName());
            BankStatement buffer = new BankStatement(2, this.fullName, reciver.fullName, value);
            bankStatements.add(buffer);
        }
    }
    public void getBankStatement(){
        System.out.println("Bank statement for " + this.fullName + ": ");
        for(BankStatement c : this.bankStatements){
                System.out.println(c.toString());
            };
    }
}
