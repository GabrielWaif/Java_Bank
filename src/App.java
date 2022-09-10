public class App {
    public static void main(String[] args) throws Exception {
        //Client cliente = new Client(100, "Gabriel");
        //cliente.deposit(100);
        //System.out.println(cliente.getBalance());

        MasterAccount adm = new MasterAccount();

        adm.addProfile(1000, "gabriel");
        adm.addProfile(12300, "teste");
        adm.getProfiles("admin");
    }
}
