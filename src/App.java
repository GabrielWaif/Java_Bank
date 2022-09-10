import administration.BankManagement;
import client.Client;
import client.IdCreator;
import java.util.Scanner;

public class App {

  private static Scanner scan = new Scanner(System.in);
  private static BankManagement bank = BankManagement.getInstance();
  private static String Password;

  public static void main(String[] args) throws Exception {
    int choice = 0;
    do {
      do {
        System.out.print(
          "-\n1 - Login as admin\n2 - Sign up\n3 - Sign in\n4 - Make a deposit\n5 - Quit\n-\nOption: "
        );
        choice = scan.nextInt();
        scan.nextLine();
        System.out.println("-");
      } while (choice < 1 || choice > 5);
      switch (choice) {
        case 1:
          admLogin();
          break;
        case 2:
          signUp();
          break;
        case 3:
          userLogin();
          break;
        case 4:
          deposit();
          break;
        case 5:
          System.out.println("Quiiting...");
          break;
      }
    } while (choice != 5);
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
    do {
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
    } while (choice != 4);
  }

  public static void userLogin() {
    int bufferId = 0;
    do {
      System.out.print("Login in as user.\nId(Type 4 to leave): ");
      bufferId = scan.nextInt();
      scan.nextLine();
      if (!IdCreator.contains(bufferId)) System.out.println(
        "Invalid Id, try again!"
      ); else if (bufferId == 4) {
        System.out.println("Leaving...");
        return;
      }
    } while (!IdCreator.contains(bufferId));

    String bufferPassword;
    Client loggedClient = null;

    do {
      System.out.print("Password: ");
      bufferPassword = scan.nextLine();
      loggedClient = bank.loginCheck(bufferId, bufferPassword);
      if (loggedClient == null) System.out.println(
        "Invalid password, try again!"
      );
    } while (loggedClient == null);
    System.out.println("Sigined in...");

    int choice = 0;
    do {
      do {
        System.out.println(
          "---------------\nId: " +
          loggedClient.getId() +
          "\nName: " +
          loggedClient.getFullName() +
          "\nBalance: " +
          loggedClient.getBalance() +
          "\n---------------"
        );
        System.out.print(
          "-\n1 - Transfer\n2 - View bank statement\n4 - Quit\n-\nChoice: "
        );
        choice = scan.nextInt();
      } while (choice < 1 || choice > 4);
      switch (choice) {
        case 1:
          double value;
          int id;
          do {
            System.out.print("\nTransfer\nReceptor Id: ");
            id = scan.nextInt();
            if (!IdCreator.contains(id)) System.out.println(
              "Non existing Id, try again!"
            );
          } while (!IdCreator.contains(id));

          do {
            System.out.print("Value: ");
            value = scan.nextDouble();
            if (loggedClient.getBalance() < value) System.out.println(
              "Not enough money to make that transition, choose a higher ammount!"
            );
          } while (loggedClient.getBalance() < value);

          loggedClient.transfer(value, id);

          break;
        case 2:
          loggedClient.getBankStatement();
          break;
        case 4:
          System.out.println("Signing out...");
          Password = "";
          break;
      }
    } while (choice != 4);
  }

  public static void signUp() {
    System.out.print("Sign up.\nFull name: ");
    String fullName = scan.nextLine();

    System.out.print("\nPassword: ");
    String bufferPassword = scan.nextLine();

    int bufferID = bank.addProfile(fullName, bufferPassword);
    System.out.println("Signed up Your login Id is " + bufferID + "...");
  }

  public static void deposit() {
    double value;
    int id;
    do {
      System.out.print("\nDeposit\nReceptor Id: ");
      id = scan.nextInt();
      if (!IdCreator.contains(id)) System.out.println(
        "Non existing Id, try again!"
      );
    } while (!IdCreator.contains(id));
    do {
      System.out.print("Value: ");
      value = scan.nextDouble();
      scan.nextLine();
      if (value <= 0) System.out.println(
        "Value too low for a Deposit, pick a higher value"
      );
    } while (value <= 0);
    System.out.print("Identify yourself: ");
    String depositorName = scan.nextLine();
    bank.makeDeposit(id, value, depositorName);
    System.out.println("Value of " + value + " deposited by " + depositorName);
  }
}
