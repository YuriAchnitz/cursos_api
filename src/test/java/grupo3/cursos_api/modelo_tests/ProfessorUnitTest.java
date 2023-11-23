package grupo3.cursos_api.modelo_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grupo3.cursos_api.modelo.Aluno;
import grupo3.cursos_api.modelo.Professor;

public class ProfessorUnitTest {

	@Test
	public void testCursoEquals() {
		Professor professor = new Professor("Lebron James", "LB23");
		Professor professor_copia = professor;
		
		Professor professor2 = new Professor("Casimiro", "CAZE");
		professor2.setId((long)999);
		
		Aluno aluno = new Aluno();
		
		//É o mesmo objeto
		assertTrue(professor.equals(professor_copia));
		
		//Não é null
		assertFalse(professor.equals(null));
		
		//Não é outra classe de objeto
		assertFalse(professor.equals(aluno));
		
		//Id de professor é null e de professor2 não
		assertFalse(professor.equals(professor2));
		
		//Os ids são diferentes
		professor.setId((long)555);
		assertFalse(professor.equals(professor2));
		
		//Os ids são iguais
		professor2.setId((long)555);
		assertTrue(professor.equals(professor2));
		
		//Os ids são iguais e null
		professor.setId(null);
		professor2.setId(null);
		assertTrue(professor.equals(professor2));
		
	}
}
