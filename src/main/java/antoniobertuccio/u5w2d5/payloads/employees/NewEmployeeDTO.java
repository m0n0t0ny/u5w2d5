package antoniobertuccio.u5w2d5.payloads.employees;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record NewEmployeeDTO(
        @NotEmpty(message = "Lo username è obbligatorio")
        @Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{7,29}$", message = "Lo username non è valido. Può contenere solo numeri e lettere. Dev'essere lunga un minimo di 7 caratteri e un massimo di 29")
        String username,
        @NotEmpty(message = "Il nome è obbligatorio")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio")
        String surname,
        @NotEmpty(message = "L'email è obbligatoria")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email
) {
}