package grupo3.cursos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import grupo3.cursos_api.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
