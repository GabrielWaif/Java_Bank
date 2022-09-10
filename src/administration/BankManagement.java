package administration;
import java.util.ArrayList;
import client.Client;

public class BankManagement{
    private static BankManagement instance;
    private String adminPassword;
    private ArrayList<Client> profiles = new ArrayList<Client>();
    private ArrayList<Client> bankStatement = new ArrayList<Client>();

    public BankManagement(){
        this.adminPassword = "admin";
    }

    public static BankManagement getInstance() {
        if(instance == null) instance = new BankManagement();
        return instance;
    }

    public void addProfile(double balance, String fullName){
        Client client = new Client(fullName);
        profiles.add(client);
    }

    public void getProfiles(String password){
        if(password.equals(this.adminPassword)) {
            if(this.profiles.size() == 0) System.out.println("0 Accounts opened");
            else{
                for(Client c : this.profiles){
                  System.out.println(c.getBalance());
                };
            }
        } 
    }
    
    public void getBankStatement(String password){
        if(password == this.adminPassword) {
            for(Client c : this.profiles){
                System.out.println(c.getBalance());
            };
        } 
    }

    public boolean validPass(String password){
        return password.equals(this.adminPassword);
    }

}
