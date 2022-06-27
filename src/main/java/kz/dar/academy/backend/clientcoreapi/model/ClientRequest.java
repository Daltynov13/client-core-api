package kz.dar.academy.backend.clientcoreapi.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

  private String clientId;
  @NotNull(message = "name must not be null")
  private String name;
  @NotNull(message = "surname must not be null")
  private String surname;
  private String email;
}
