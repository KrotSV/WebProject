import entities.Client;
import logics.DAO;
import logics.ResourceManager;

public class test {
    public static void main(String[] args) {
        DAO dao = new ResourceManager().getDAO();
        Client client = dao.getClientData("Sergey", "Krotov");
        System.out.println(client.getFirstName() + ", " + client.getLastName());
        System.out.printf(ResourceManager.format(client.getBirthday()));
    }
}
