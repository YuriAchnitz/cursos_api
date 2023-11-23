package grupo3.cursos_api.modelo_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grupo3.cursos_api.modelo.Curso;
import grupo3.cursos_api.modelo.Professor;

public class CursoUnitTest {

	@Test
	public void testCursoEquals() {
		Curso curso = new Curso("Motores I", 40);
		Curso curso_copia = curso;
		
		Curso curso2 = new Curso("Elétrica Automotiva", 50);
		curso2.setId((long)999);
		
		Professor professor = new Professor();
		
		//É o mesmo objeto
		assertTrue(curso.equals(curso_copia));
		
		//Não é null
		assertFalse(curso.equals(null));
		
		//Não é outra classe de objeto
		assertFalse(curso.equals(professor));
		
		//Id de curso é null e de curso2 não
		assertFalse(curso.equals(curso2));
		
		//Os ids são diferentes
		curso.setId((long)555);
		assertFalse(curso.equals(curso2));
		
		//Os ids são iguais
		curso2.setId((long)555);
		assertTrue(curso.equals(curso2));
		
		//Os ids são iguais e null
		curso.setId(null);
		curso2.setId(null);
		assertTrue(curso.equals(curso2));
		
	}
	
}
