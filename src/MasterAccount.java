import java.util.ArrayList;

public class MasterAccount{
    private MasterAccount instance;
    private String adminPassword;
    private ArrayList<Client> profiles = new ArrayList<Client>();

    MasterAccount(){
        this.adminPassword = "admin";

    }

    public MasterAccount getInstance() {
        if(this.instance == null) this.instance = new MasterAccount();
        return this.instance;
    }

    public void addProfile(double balance, String fullName){
        Client client = new Client(balance, fullName);
        profiles.add(client);
    }

    public void getProfiles(String senha){
        if(senha == this.adminPassword) {
            for(Client c : this.profiles){
                System.out.println(c.getBalance());
            };
        } 
    }

}
