package com.umanizales.umz_persons.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.beans.ConstructorProperties;
import java.util.List;


@Data
public class PersonDTO {

    @Size(min = 2, max = 20, message = "{name.size}")
    private String name;
    @NotNull(message = "{identificacion.notNull}")
    @NotBlank(message = "{identification.notBlank}")
    private String identification;
    @Positive(message = "{age.size}")
    private byte age;
    @NotBlank(message = "{email.notBlank}")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+$", message = "{email.required}")
    private String email;

    public PersonDTO(String name, String identification, byte age, String s) {
        this.name = name;
        this.identification = identification;
        this.age = age;
    }
    @Size(min = 1, max = 20) // para que si se van a meter children que al menos ingrese uno
    @Valid //para que tambien haga las validaciones internas de los objetos
    private List<PersonDTO> children;
}
