package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EntregadorService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       entregador.setVersao(1L);
       entregador.setDataCriacao(LocalDate.now());
       return repository.save(entregador);
   }

   
   public List<Entregador> findAll() {
  
    return repository.findAll();
}

public Entregador findById(Long id) {

    return repository.findById(id).get();
}


@Transactional
   public void update(Long id, Entregador entregadorAlterado) {

      Entregador entregador = repository.findById(id).get();
      entregador.setAtivo(entregadorAlterado.getAtivo());
      entregador.setCpf(entregadorAlterado.getCpf());
      entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
      entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
      entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
	  entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
      entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
      entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
      entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
      entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
	  entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
      entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
      entregador.setNome(entregadorAlterado.getNome());
      entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
      entregador.setRg(entregadorAlterado.getRg());
      entregador.setValorFrete(entregadorAlterado.getValorFrete());
   
	   
      entregador.setVersao(entregador.getVersao() + 1);
      repository.save(entregador);
  }
  
  @Transactional
  public void delete(Long id) {

      Entregador entregador = repository.findById(id).get();
      entregador.setHabilitado(Boolean.FALSE);
      entregador.setVersao(entregador.getVersao() + 1);

      repository.save(entregador);
  }


}
