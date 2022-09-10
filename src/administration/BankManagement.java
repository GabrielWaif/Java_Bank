package administration;
import java.util.ArrayList;
import client.Client;

public class BankManagement{
    private static BankManagement instance;
    private String adminPassword;
    private ArrayList<Client> profiles = new ArrayList<Client>();
    private ArrayList<BankStatement> bankStatement = new ArrayList<BankStatement>();

    public BankManagement(){
        this.adminPassword = "admin";
    }

    public static BankManagement getInstance() {
        if(instance == null) instance = new BankManagement();
        return instance;
    }

    public void addProfile(String fullName, String password){
        Client client = new Client(fullName, password);
        profiles.add(client);
    }

    public void getProfiles(String password){
        if(password.equals(this.adminPassword)) {
        double totalBalance = 0;
            if(this.profiles.size() == 0) System.out.println("0 Accounts opened");
            else{
                for(Client c : this.profiles){
                System.out.println("-");
                    System.out.println(c.toString());
                };
            }
            System.out.println("-\nTotal Balance: " + totalBalance);
        } 
    }
    
    public void getBankStatement(String password){
        if(password.equals(this.adminPassword)) {
            if(this.profiles.size() == 0) System.out.println("0 Accounts opened");
            else {
                for(BankStatement bs : this.bankStatement){
                System.out.println(bs.toString());
            }
        }
        } 
    }

    public Client getAccount(){
        return profiles.get(0);
    }

    public void addBankStatement(BankStatement statement){
        bankStatement.add(statement);
    }

    public boolean validPass(String password){
        return password.equals(this.adminPassword);
    }

}
