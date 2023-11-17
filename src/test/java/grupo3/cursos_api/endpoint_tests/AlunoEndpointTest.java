package grupo3.cursos_api.endpoint_tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"grupo3.cursos_api"})
@SpringBootTest
@AutoConfigureMockMvc

public class AlunoEndpointTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testeCriarAluno() throws Exception {
		final String expectedNome = "Anderson Silva";
		final int expectedMoedas = 32;

		mockMvc.perform(MockMvcRequestBuilders.post("/alunos").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nome\":\"Anderson Silva\",\"moedas\":32}"))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
				.andExpect((ResultMatcher) jsonPath("moedas").value(expectedMoedas));
	}

}
