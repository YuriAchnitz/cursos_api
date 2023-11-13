package grupo3.cursos_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class CursosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApiApplication.class, args);

	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Olá mundo!";
	}

}
