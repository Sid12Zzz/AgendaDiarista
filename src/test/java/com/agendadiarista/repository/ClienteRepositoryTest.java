package com.agendadiarista.repository;

import com.agendadiarista.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ClienteRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ClienteRepository repository;


    void deveCriarNovoCliente(){
        Cliente cliente = new Cliente();
        cliente.setEmail("sidneijunioranjos@gmail.com");
        cliente.setEndereco("Mario zanlorenzi 1880");
        cliente.setNome("Sidnei");
        cliente.setTelefone("41974018591");

        Cliente salvo = repository.save(cliente);

        System.out.println(cliente.getEmail() + cliente.getEndereco() + cliente.getNome() + cliente.getId() );




    }
}
