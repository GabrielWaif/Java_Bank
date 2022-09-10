public class Client extends BankAccount{

    Client(int id, double balance, String fullName){
        this.id = id;
        this.balance = balance;
        this.fullName = fullName;
        
    }

    public void deposit(double value){
        if(value <= 0) System.out.println("Cannot deposit a value that is less or equal to 0");
        else this.balance += value;
    }
}
