import entities.BankAccount;
import entities.Client;
import entities.CreditCard;
import logics.DAO;
import logics.ResourceManager;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        DAO dao = new ResourceManager().getDAO();
        Client client = dao.getClientData("Sergey", "Krotov");
        System.out.println(client.getFirstName() + ", " + client.getLastName());
        System.out.printf(ResourceManager.format(client.getBirthday()));
        ArrayList<CreditCard> cards = client.getCards();
        System.out.println();
        System.out.println(cards.size());
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        for (CreditCard c:cards) {
            System.out.println(c.getCardNumber());
            accounts.add(dao.getAccount(c.getCardNumber()));
            System.out.println(dao.getAccount(c.getCardNumber()).getAccountId());
        }
        for (BankAccount ba:accounts) {
//            System.out.println(ba.getBalance() + "; " + ba.getAccountId());
        }
    }
}
