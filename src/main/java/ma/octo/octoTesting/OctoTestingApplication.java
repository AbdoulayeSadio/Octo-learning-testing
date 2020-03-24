package ma.octo.octoTesting;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.services.IVirementService;
import ma.octo.octoTesting.services.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class OctoTestingApplication {

	public static void main(String[] args) {

		SpringApplication.run(OctoTestingApplication.class, args);
		VirementService virementService = new VirementService();
		//CompteDao compteDao = new CompteDao();
		virementService.performTransfert("456", "789", BigDecimal.valueOf(20000));
	}

}
