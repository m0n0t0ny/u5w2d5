package antoniobertuccio.u5w2d5.exceptions;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(UUID id) {
    super("Il dipendente con id " + id + " non è stato trovato");
  }
}
