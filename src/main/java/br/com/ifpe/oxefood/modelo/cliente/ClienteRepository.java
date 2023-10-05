package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

   //Exemplo de uma busca com mais de um atributo
   @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome%")
   List<Cliente> consultarPorNome(String nome);

    //Exemplo de uma busca com mais de um atributo
   @Query(value = "SELECT c FROM Cliente c WHERE c.cpf like %:cpf%")
   List<Cliente> consultarPorCpf(String cpf);

   @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% AND c.cpf like %:cpf%")
   List<Cliente> consultarPorNomeECpf(String nome, String cpf);



}
