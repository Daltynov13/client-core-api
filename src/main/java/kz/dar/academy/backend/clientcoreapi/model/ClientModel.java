package kz.dar.academy.backend.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientModel {

  private String clientId;
  private String name;
  private String surname;
  private String email;

}
