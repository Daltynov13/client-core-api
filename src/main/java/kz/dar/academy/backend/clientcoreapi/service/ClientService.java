package kz.dar.academy.backend.clientcoreapi.service;

import java.util.List;
import kz.dar.academy.backend.clientcoreapi.model.ClientModel;

public interface ClientService {

  void createClient(ClientModel client);

  List<ClientModel> getAllClients();

  ClientModel getClientById(String clientId);

  void updateClientById(String clientId, ClientModel client);

  void deleteClientById(String clientId);
}
