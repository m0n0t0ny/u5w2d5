package antoniobertuccio.u5w2d5.exceptions;

import java.util.UUID;

public class DeviceNotFoundException extends RuntimeException {
  public DeviceNotFoundException(UUID id) {
    super("Il device con id " + id + " non è stato trovato");
  }
}
