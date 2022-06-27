package kz.dar.academy.backend.clientcoreapi.repository;

import javax.transaction.Transactional;
import kz.dar.academy.backend.clientcoreapi.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

  ClientEntity findByClientId(String clientId);

  @Transactional
  void deleteByClientId(String clientId);
}
