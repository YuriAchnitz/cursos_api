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

import grupo3.cursos_api.modelo.Professor;
import grupo3.cursos_api.repository.ProfessorRepository;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "grupo3.cursos_api" })
@SpringBootTest
@AutoConfigureMockMvc

public class ProfessorEndpointTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ProfessorRepository professorRepository;

	@Test
	public void testeCriarAluno() throws Exception {
		final String expectedNome = "Pelé";
		final String expectedMatricula = "EA10";

		mockMvc.perform(MockMvcRequestBuilders.post("/professores").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nome\":\"Pelé\",\"matricula\":\"EA10\"}"))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
				.andExpect((ResultMatcher) jsonPath("matricula").value(expectedMatricula));
	}
	
	@Test
	public void deveRetornarListaDeProfessores() throws Exception {
		Professor professor1 = new Professor("Ronaldo", "RF09");
		Professor professor2 = new Professor("Messi", "LM10");
		professorRepository.saveAll(List.of(professor1, professor2));

		mockMvc.perform(MockMvcRequestBuilders.get("/professores")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[1].nome").value(professor1.getNome()))
				.andExpect(jsonPath("$[1].matricula").value(professor1.getMatricula()))
				.andExpect(jsonPath("$[2].nome").value(professor2.getNome()))
				.andExpect(jsonPath("$[2].matricula").value(professor2.getMatricula()));
	}
}
