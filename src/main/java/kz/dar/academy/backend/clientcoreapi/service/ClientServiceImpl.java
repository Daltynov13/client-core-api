package kz.dar.academy.backend.clientcoreapi.service;

import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

import java.util.List;
import kz.dar.academy.backend.clientcoreapi.model.ClientEntity;
import kz.dar.academy.backend.clientcoreapi.model.ClientRequest;
import kz.dar.academy.backend.clientcoreapi.model.ClientResponse;
import kz.dar.academy.backend.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {


  @Autowired
  private ClientRepository clientRepository;

  static ModelMapper modelMapper = new ModelMapper();

  static {
    modelMapper.getConfiguration().setMatchingStrategy(STRICT);
  }

  @Override
  public ClientResponse createClient(ClientRequest client) {
    client.setClientId(randomUUID().toString());
    ClientEntity entity = modelMapper.map(client, ClientEntity.class);
    clientRepository.save(entity);
    return modelMapper.map(entity, ClientResponse.class);
  }

  @Override
  public List<ClientResponse> getAllClients() {
    return stream(clientRepository.findAll().spliterator(), false).map(
        post -> modelMapper.map(post, ClientResponse.class)).collect(toList());
  }

  @Override
  public ClientResponse getClientById(String clientId) {
    return modelMapper.map(clientRepository.findByClientId(clientId), ClientResponse.class);
  }

  @Override
  public void updateClientById(String clientId, ClientRequest client) {
    ClientEntity dbEntity = clientRepository.findByClientId(clientId);

    ClientEntity entity = modelMapper.map(client, ClientEntity.class);
    entity.setId(dbEntity.getId());

    clientRepository.save(entity);
  }

  @Override
  public void deleteClientById(String clientId) {
    clientRepository.deleteByClientId(clientId);
  }
}
