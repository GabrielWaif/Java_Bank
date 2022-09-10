import administration.BankManagement;
import client.Client;
import java.util.Scanner;

public class App {

  private static Scanner scan = new Scanner(System.in);
  private static BankManagement bank = BankManagement.getInstance();
  private static String Password;

  public static void main(String[] args) throws Exception {
    bank.addProfile("Gabriel", "123");
    Client profile = bank.getAccount();
    profile.deposit(100, "transporte");
    bank.addProfile("Teste", "123");
    int choice = 0;

    do {

      do {
        System.out.print(
          "-\n1 - Login as admin\n2 - Sign up\n3 - Sign in\n4 - Quit\n-\nOption: "
        );
        choice = scan.nextInt();
        System.out.println("-");
      } while (choice < 1 || choice > 4);
      switch (choice) {
        case 1:
          admLogin();
          break;
        case 2:
        signUp();
          break;
        case 3:
          break;
        case 4:
          System.out.println("Quiiting...");
          break;
      }
    } while (choice != 4);
  }

  public static void admLogin() {
    do {
      System.out.print("Login in as admin.\nPassword: ");
      Password = scan.next();
      if (!bank.validPass(Password)) System.out.println(
        "Invalid Password, try again!"
      );
    } while (!bank.validPass(Password));
    int choice = 0;
    System.out.println("Sigined in...");
    do{
      do {
        System.out.print(
          "-\n1 - View balance of every account\n2 - View all bank statements\n4 - Quit\n-\nChoice: "
        );
        choice = scan.nextInt();
      } while (choice < 1 || choice > 4);
      switch (choice) {
        case 1:
          bank.getProfiles(Password);
          break;
        case 2:
          bank.getBankStatement(Password);
          break;
        case 4:
          System.out.println("Signing out...");
          Password = "";
          break;
      }
    }
    while (choice != 4);
  }

  public static void signUp() {

      System.out.print("Sign up.\nFull name: ");
      String fullName = scan.next();
      System.out.print("\nSenha: ");
      String bufferPassword = scan.next();
      bank.addProfile(fullName, bufferPassword);
      System.out.println("Signed up...");
  }
}
