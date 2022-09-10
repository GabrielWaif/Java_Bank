import java.util.Scanner;
import administration.BankManagement;
import client.Client;

public class App {
    private static Scanner scan = new Scanner(System.in);
    private static BankManagement bank = BankManagement.getInstance();
    private static String bufferSenha;
    public static void main(String[] args) throws Exception {
        //Client cliente = new Client("Gabriel");
        //cliente.deposit(100, "teste");
        //cliente.deposit(20, "teste2");
        //Client cliente2 = new Client("Lucas");
        //cliente.transfer(100, cliente2);
        //cliente.getBankStatement();

        bank.addProfile("Gabriel");
        Client profile  = bank.getAccount();
        profile.deposit(100, "transporte");

        bank.addProfile("Teste");

        int escolha = 0;

        do{
            System.out.println("fora");
            do{
                System.out.print("-\n1 - Entrar como adimin\n2 - Iniciar conta\n3 - Entrar em conta\n4 - Sair\n-\nEscolha: ");
                escolha = scan.nextInt();
                System.out.println("-");
            }while(escolha < 1 || escolha > 4);
            switch(escolha){
                case 1:
                admLogin();
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                    System.out.println("Saindo...");
                break;
            }
        }
        while(escolha!=4);
    }

    public static void admLogin(){
            do{
                System.out.print("Entre como administrador.\nSenha: ");
                bufferSenha = scan.next();
                if(!bank.validPass(bufferSenha)) System.out.println("Senha invalida tente novamente!");
            }while(!bank.validPass(bufferSenha));
            int escolha = 0;
            System.out.println("Logado como admin...");
         do{
            do{
                System.out.print("-\n1 - Ver balanca das contas\n2 - Ver extrato geral\n4 - Sair\n-\nEscolha: ");
                escolha = scan.nextInt();
            }while(escolha < 1 || escolha > 4);
            switch(escolha){
                case 1:
                bank.getProfiles(bufferSenha);
                break;
                case 2:
                bank.getBankStatement(bufferSenha);
                break;
                case 4:
                    System.out.println("Deslogado como admin...");
                    bufferSenha = "";
                break;
            }
        }
        while(escolha!=4);
    }
}
