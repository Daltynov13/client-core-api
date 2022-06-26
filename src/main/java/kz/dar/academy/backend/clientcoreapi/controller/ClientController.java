package kz.dar.academy.backend.clientcoreapi.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import javax.validation.Valid;
import kz.dar.academy.backend.clientcoreapi.model.ClientModel;
import kz.dar.academy.backend.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private Environment env;
  @Autowired
  private ClientService clientService;

  @GetMapping("/check")
  public String checkClientCoreApi() {
    return "Client service is WORKING at " + env.getProperty("local.server.port");
  }

  @PostMapping
  public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel client) {
    clientService.createClient(client);
    return new ResponseEntity<>("Successful created", OK);
  }

  @GetMapping("/all")
  public List<ClientModel> getAllClients() {
    return clientService.getAllClients();
  }

  @GetMapping("/{clientId}")
  public ClientModel getClientById(@PathVariable String clientId) {
    return clientService.getClientById(clientId);
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<String> updateClientById(@PathVariable String clientId,
      @Valid @RequestBody ClientModel client) {
    clientService.updateClientById(clientId, client);
    return new ResponseEntity<>("Successful updated", OK);

  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
    clientService.deleteClientById(clientId);
    return new ResponseEntity<>("Successful deleted", OK);
  }
}
