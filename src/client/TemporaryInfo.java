package client;
import administration.BankManagement;

public class TemporaryInfo extends BankAccount{
    private BankManagement adm = new BankManagement();

    TemporaryInfo(int id, double balance, String fullName){
        super(fullName);
    }

    public void sendProfile(){
        this.adm.addProfile(this.fullName);
    };
}
