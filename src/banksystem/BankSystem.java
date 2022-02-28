package banksystem;

import java.util.ArrayList;
import java.util.List;


class BankSystem {
    private ArrayList<Client> clients = new ArrayList<>();

    public void addNewClient(Client newClient) {
        clients.add(newClient);
    }

    public void createNewAccForClient ( int indexOfCient, int accValue) {
        clients.get(indexOfCient).
                getAccountOfThisClient().
                addNewAccountForClient(accValue);
    }

    public List<Integer> getAccounts(Client client) {
        return client.
                getAccountOfThisClient().
                getListOfAccounts();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client findClient(int searchedAccount) throws RuntimeException {
        try {
        for (Client tempClient : clients) {
            List<Integer> searchedClient = getAccounts(tempClient);
            if (searchedClient.contains(searchedAccount)) {
                return tempClient;
            }
        }
        throw new RuntimeException("Клиента с данным счётом не существует");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
