package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   
    private String nome;
    
    private String cpf;

      @NotBlank(message = "O Email é de preenchimento obrigatório")
   @Email
   private String email;
    
    private  String rg;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    private  String foneCelular;
    
    private  String foneFixo;
    
    private Integer qtdEntregasRealizadas;
    
    private Double valorFrete;
    
    private String enderecoRua;
    
    private  String enderecoNumero;
    
    private String enderecoBairro;
    
    private String enderecoCidade;
    
    private String enderecoCep;
    
    private  String enderecoUf;
    
    private  String enderecoComplemento;
    
    private Boolean ativo;
    

   public Entregador build() {
       return Entregador.builder()
               .nome(nome)
               .ativo(ativo)
               .cpf(cpf)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .dataNascimento(dataNascimento)
               .enderecoBairro(enderecoBairro)
               .enderecoCep(enderecoCep)
               .enderecoCidade(enderecoCidade)
               .enderecoComplemento(enderecoComplemento)
               .enderecoNumero(enderecoNumero)
               .email(email)
               .enderecoRua(enderecoRua)
               .enderecoUf(enderecoUf)
               .qtdEntregasRealizadas(qtdEntregasRealizadas)
               .rg(rg)
               .valorFrete(valorFrete)
               .build();
   }

}
