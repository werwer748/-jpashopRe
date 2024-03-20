package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

//	@Bean
//	Hibernate5JakartaModule hibernate5JakartaModule() {
////		return new Hibernate5JakartaModule();
//		Hibernate5JakartaModule hibernate5JakartaModule = new Hibernate5JakartaModule();
////!				.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true); // LAZY로딩 걸려있는것들 강제로 다 가져옴
//		return hibernate5JakartaModule;
//	}
}
