package antoniobertuccio.u5w2d5.payloads.devices;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewDeviceDTO(
        @NotEmpty(message = "Devi dare un nome al dispositivo!")
        @Size(min = 4, max = 20, message = "Il nome deve essere compreso tra 4 e 20 caratteri")
        String name,
        @NotEmpty(message = "Devi dichiarare il tipo di dispositivo!")
        @Size(min = 4, max = 20, message = "Il tipo deve essere compreso tra 4 e 20 caratteri")
        String type) {
}
