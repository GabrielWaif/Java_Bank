public class TemporaryInfo extends BankAccount{
    private MasterAccount adm = new MasterAccount();

    TemporaryInfo(int id, double balance, String fullName){
        super(balance, fullName);
    }

    public void sendProfile(){
        this.adm.addProfile(this.balance, this.fullName);
    };
}
