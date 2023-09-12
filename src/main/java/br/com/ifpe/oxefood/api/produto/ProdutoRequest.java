package br.com.ifpe.oxefood.api.produto;


import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {


   private String codigo;
   
  
    private String titulo;
   

    private String descricao;

   private Double valorUnitario;
    
 
    private Integer tempoEntregaMinimo;
   
   private Integer tempoEntregaMaximo;
    

   public Produto build() {
       return Produto.builder()
               .codigo(codigo)
               .descricao(descricao)
               .tempoEntregaMaximo(tempoEntregaMaximo)
               .tempoEntregaMinimo(tempoEntregaMinimo)
               .titulo(titulo)
               .valorUnitario(valorUnitario)
               .build();
   }
}
