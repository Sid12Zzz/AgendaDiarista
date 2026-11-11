package com.agendadiarista;


import com.agendadiarista.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.awt.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerPostTeste {
    @Autowired
    MockMvc mockMvc;

    @Test
    void deveCadastrarClienteComSucesso() throws Exception {
        String jsonBody = """
                {
                  "nome": "Ana Maria da Silva",
                  "email": "ana.silva@email.com",
                  "telefone": "(41) 98888-7777",
                  "endereco": "rua das flores 2000"
                }
                """;

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))

                .andDo(print())

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Ana Maria da Silva"));

    }
}
