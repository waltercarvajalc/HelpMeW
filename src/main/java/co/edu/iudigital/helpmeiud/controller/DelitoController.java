package co.edu.iudigital.helpmeiud.controller;


import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    IDelitoService delitoService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<DelitoDTO>> index(){
        return ResponseEntity
                .ok()
                .body(
                        delitoService.consultarTodos()
                );
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<DelitoDTO> create(
            @RequestBody @Valid DelitoDTORequest delitoDTORequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                   delitoService.guardarDelito(delitoDTORequest)
                );
    }
}
