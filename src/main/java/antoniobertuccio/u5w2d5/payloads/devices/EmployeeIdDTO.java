package antoniobertuccio.u5w2d5.payloads.devices;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record EmployeeIdDTO(
        @NotEmpty(message = "Devi specificare l'id!")
        UUID uuid) {
}
