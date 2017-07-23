import entities.Client;
import logics.DAO;
import logics.DAOmanager;

public class test {
    public static void main(String[] args) {
        DAO dao = new DAOmanager().getDAO();
        Client client = dao.getClientData("Sergey", "Krotov");
        System.out.println(client.getFirstName() + ", " + client.getLastName());
    }
}
