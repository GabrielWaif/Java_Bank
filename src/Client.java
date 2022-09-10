public class Client extends BankAccount{
    Client(double balance, String fullName){
        super(balance, fullName);
    }

    public void deposit(double value){
        if(value <= 0) System.out.println("Cannot deposit a value that is less or equal to 0");
        else {
            this.balance += value;
            System.out.println("Value of " + value + " deposited to ");
        }
    }

}
