package ma.octo.octoTesting.daoTest;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.model.Compte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

public class CompteDaoTest {

    @Test
    void getCompteByIdCompte_ShouldReturnTheCompte_WithTheExactId(){

        String idCompte = "123";
        CompteDao compteDao = new CompteDao();

        Compte compte = compteDao.getCompteByIdCompte(idCompte);

        assertThat(compte.getIdCompte()).isEqualTo("123");
    }
}
