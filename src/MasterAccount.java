public class MasterAccount extends BankAccount{
    private MasterAccount instance;
    private String adminPassword;

    MasterAccount(){
        this.adminPassword = "admin";
    }

    public MasterAccount getInstance() {
        if(this.instance == null) this.instance = new MasterAccount();
        return this.instance;
    }

    
}
