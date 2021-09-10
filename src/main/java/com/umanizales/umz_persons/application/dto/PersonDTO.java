package com.umanizales.umz_persons.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
public class PersonDTO {

    private String name;
    @NotNull
    @NotBlank
    private String identification;
    @Positive
    private byte age;
}
