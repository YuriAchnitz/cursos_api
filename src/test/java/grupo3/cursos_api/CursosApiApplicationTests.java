package grupo3.cursos_api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "grupo3.cursos_api" })
@SpringBootTest
@AutoConfigureMockMvc
class CursosApiApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void createCursoDefault() throws Exception {
		final String expectedNome = "Criação de Pneus";
		final int expectedPreco = 50;
		mockMvc.perform(MockMvcRequestBuilders.post("/cursos").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nome\":\"Criação de Pneus\",\"preco\":50}"))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
				.andExpect((ResultMatcher) jsonPath("preco").value(expectedPreco));
	}

}
