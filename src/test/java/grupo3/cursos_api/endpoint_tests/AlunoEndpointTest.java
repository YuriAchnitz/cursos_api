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

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "grupo3.cursos_api" })
@SpringBootTest
@AutoConfigureMockMvc

public class AlunoEndpointTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Test
	public void deveCriarAluno() throws Exception {
		final String expectedNome = "Anderson Silva";
		final int expectedMoedas = 32;

		mockMvc.perform(MockMvcRequestBuilders.post("/alunos").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nome\":\"Anderson Silva\",\"moedas\":32}"))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
				.andExpect((ResultMatcher) jsonPath("moedas").value(expectedMoedas));
	}

	@Test
	public void deveRetornarListaDeAlunos() throws Exception {
		Aluno aluno1 = new Aluno("João", 12);
		Aluno aluno2 = new Aluno("Maria", 20);
		alunoRepository.saveAll(List.of(aluno1, aluno2));

		mockMvc.perform(MockMvcRequestBuilders.get("/alunos")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[1].nome").value(aluno1.getNome()))
				.andExpect(jsonPath("$[1].moedas").value(aluno1.getMoedas()))
				.andExpect(jsonPath("$[2].nome").value(aluno2.getNome()))
				.andExpect(jsonPath("$[2].moedas").value(aluno2.getMoedas()));
	}
	
}
