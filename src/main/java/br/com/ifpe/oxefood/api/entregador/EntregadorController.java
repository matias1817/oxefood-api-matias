package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

   @Autowired
   private EntregadorService entregadorService;

   @ApiOperation(value = "Serviço responsável por salvar um entregador no sistema.")
   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {

       Entregador entregador = entregadorService.save(request.build());
       return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
   }
   @ApiOperation(value = "Serviço responsável por listar todos os entregadores do sistema.")
     @GetMapping
    public List<Entregador> findAll() {
  
        return entregadorService.findAll();
    }

    @ApiOperation(value = "Serviço responsável por obter um entregador referente ao Id passado na URL.")
    @GetMapping("/{id}")
    public Entregador findById(@PathVariable Long id) {

        return entregadorService.findById(id);
    }

    
@ApiOperation(value = "Serviço responsável por alterar um entregador referente ao Id passado na URL.")
     @PutMapping("/{id}")
   public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

       entregadorService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @ApiOperation(value = "Serviço responsável por deletar um entregador referente ao Id passado na URL.")
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       entregadorService.delete(id);
       return ResponseEntity.ok().build();
   }

}
