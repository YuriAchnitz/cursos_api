package grupo3.cursos_api.endpoint_tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

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

import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.repository.CursoRepository;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "grupo3.cursos_api" })
@SpringBootTest
@AutoConfigureMockMvc

public class CursoEndpointTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void testeCriarAluno() throws Exception {
		final String expectedNome = "Programação";
		final int expectedPreco = 70;

		mockMvc.perform(MockMvcRequestBuilders.post("/cursos").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nome\":\"Programação\",\"preco\":70}"))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
				.andExpect((ResultMatcher) jsonPath("preco").value(expectedPreco));
	}

	@Test
	public void deveRetornarListaDeCursos() throws Exception {
		Curso curso1 = new Curso("Borracharia", 60);
		Curso curso2 = new Curso("Eletricista", 75);
		cursoRepository.saveAll(List.of(curso1, curso2));

		mockMvc.perform(MockMvcRequestBuilders.get("/cursos")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[1].nome").value(curso1.getNome()))
				.andExpect(jsonPath("$[1].preco").value(curso1.getPreco()))
				.andExpect(jsonPath("$[2].nome").value(curso2.getNome()))
				.andExpect(jsonPath("$[2].preco").value(curso2.getPreco()));
	}
}
