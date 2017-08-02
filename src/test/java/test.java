public class test {
//    public static void main(String[] args) {
//        DAO dao = new DAODispatcher().getDAO();
//        Client client = dao.getData("Ivan", "Ivanov");
//        System.out.println(client.getFirstName() + ", " + client.getLastName());
//        System.out.printf(DAODispatcher.format(client.getBirthday()));
//        ArrayList<CreditCard> cards = dao.getEntitiesList(client.getClientId());
//        System.out.println();
//        System.out.println(cards.size());
//        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
//        LinkedList<Transaction> history = null;
//        for (CreditCard c:cards) {
//            System.out.println(c.getCardNumber());
//            accounts.add(dao.getAccount(c.getCardNumber()));
//            System.out.println();
//            history = dao.getHistory(c.getCardNumber());
//        }
//        System.out.println("history: " + history.size());
//        for (Transaction tr:history) {
//            System.out.println(tr.getDate().getTime() + "; " + tr.getSum());
//        }
//    }

    public static void main(String[] args)  {
        System.out.println(java.time.LocalDate.now());

    }
}
