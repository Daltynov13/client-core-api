package kz.dar.academy.backend.clientcoreapi.service;

import static java.util.UUID.randomUUID;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import kz.dar.academy.backend.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private static final HashMap<String, ClientModel> clientMap = new HashMap<>();

  static {
    String id = "1";
    String id1 = "2";
    String id2 = "3";
    clientMap.put(id,
        ClientModel.builder()
            .clientId(id)
            .surname("Ivanov").name("Petr").email("test@mail.ru").build());
    clientMap.put(id1,
        ClientModel.builder()
            .clientId(id1)
            .surname("Petrov").name("Evgenii").email("test@mail.ru").build());
    clientMap.put(id2,
        ClientModel.builder()
            .clientId(id2)
            .surname("Kalashnikov").name("Aleksandr").email("test@mail.ru").build());
  }

  @Override
  public void createClient(ClientModel client) {
    client.setClientId(randomUUID().toString());
    clientMap.put(client.getClientId(), client);
  }

  @Override
  public List<ClientModel> getAllClients() {
    return new ArrayList<>(clientMap.values());
  }

  @Override
  public ClientModel getClientById(String clientId) {
    return clientMap.get(clientId);
  }

  @Override
  public void updateClientById(String clientId, ClientModel client) {
    client.setClientId(randomUUID().toString());
    clientMap.put(clientId, client);
  }

  @Override
  public void deleteClientById(String clientId) {
    clientMap.remove(clientId);
  }
}
