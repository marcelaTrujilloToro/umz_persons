package com.umanizales.umz_persons.infrastructure.controller;

import com.umanizales.umz_persons.application.dto.ErrorDTO;
import com.umanizales.umz_persons.application.dto.PersonDTO;
import com.umanizales.umz_persons.application.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "person")
@Validated
public class PersonController {


    /*metodo de API Rest que responde en la URL localhost con un texto Hola campeones
    se manda por GET*/
    @GetMapping
    public ResponseEntity<ResponseDTO> helloChampions()
    {
        return new ResponseEntity<>(new ResponseDTO("success", "Hola campeones", null), HttpStatus.OK);
        //return "Hola campeones";
    }

    @GetMapping("/dto")
    public PersonDTO PersonDTO()
    {
        return new PersonDTO("Marcela Trujillo", "1053811156", (byte)43 );
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> listPersons(){
        List<PersonDTO> listPersonDTO = new ArrayList<>();
        listPersonDTO.add(new PersonDTO("Zharick", "10000000",(byte)21) );
        listPersonDTO.add(new PersonDTO("zafiro", "10000000",(byte)21) );
        listPersonDTO.add(new PersonDTO("ada", "10000000",(byte)21) );
        listPersonDTO.add(new PersonDTO("hongo", "10000000",(byte)21) );

        if(listPersonDTO.size()>0)
            return new ResponseEntity<>
                    (new ResponseDTO("success",listPersonDTO,null), HttpStatus.OK);
        else {
            List<ErrorDTO> errorDTOS = new ArrayList<>();
            errorDTOS.add(new ErrorDTO(HttpStatus.NOT_FOUND.value(),"La consulta no generó resultado"));
            return new ResponseEntity<>
                    (new ResponseDTO("error", null, errorDTOS), HttpStatus.OK);
        }
    }

    @GetMapping("/{name}")
    public String helloPerson(@PathVariable String name) {return "Hola " + name;}

    @GetMapping("/{message1}/{message2}")
    public String getDoubleMessage(@PathVariable String message1, @PathVariable String message2)
    {
        return message1 + " " + message2;
    }

    @PostMapping
    //@Requestbody para indicar que va a recibir un body
    public PersonDTO savePerson(@Valid @RequestBody PersonDTO personDTO){
        personDTO.setName("Bienvenid@ " + personDTO.getName());
        return personDTO;
    }



}
