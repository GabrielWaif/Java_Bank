package administration;
import java.util.Date;

public class BankStatement implements IBank{
    private String type;
    private String depositorName; 
    private String reciverName; 
    private Date date;
    private double ammount;

    public BankStatement(int type, String depositorName, String reciverName, double ammount){
        switch(type){
            case 1:
            this.type = "Deposit";
            break;
            case 2:
            this.type = "Transfer";
            break;
        }
        this.depositorName = depositorName;
        this.reciverName = reciverName;
        this.ammount = ammount;
        date = new Date();
    }

    public String toString(){
        return "-\nType: " + this.type + "\nDepositor: " + this.depositorName + "\nReciver: " + this.reciverName + "\nAt: " + this.date + "\nAmmount: " + this.ammount;
    }
}
