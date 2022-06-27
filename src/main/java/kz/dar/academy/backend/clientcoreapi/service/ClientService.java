package kz.dar.academy.backend.clientcoreapi.service;

import java.util.List;
import kz.dar.academy.backend.clientcoreapi.model.ClientRequest;
import kz.dar.academy.backend.clientcoreapi.model.ClientResponse;

public interface ClientService {

  ClientResponse createClient(ClientRequest client);

  List<ClientResponse> getAllClients();

  ClientResponse getClientById(String clientId);

  void updateClientById(String clientId, ClientRequest client);

  void deleteClientById(String clientId);
}
