package ma.octo.octoTesting.servicesTest;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.model.Compte;
import ma.octo.octoTesting.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    CompteDao compteDao;

    AccountService classUnderTest;
    @BeforeEach
    public void init(){
        classUnderTest = new AccountService();
    }

    @Test
    void getCompte_shouldReturnExactCompte_OfIdCompte(){

        String idCompte = "123";
        Compte compte = new Compte("123", BigDecimal.valueOf(300000000), "barry");
        Mockito.lenient().when(compteDao.getCompteByIdCompte(idCompte)).thenReturn(compte);

        final Compte cptAct = classUnderTest.getCompte(idCompte);

        //verify(compteDao).getCompteByIdCompte(idCompte);
        assertThat(cptAct.getIdCompte()).isEqualTo("123");
    }

    @Test
    void debiterCompte_shouldSubstractMontant_inSoldeOfCompte(){

        Compte compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");
        BigDecimal montant = BigDecimal.valueOf(1000);

        classUnderTest.debiterCompte(compte, montant);

        assertThat(compte.getSolde()).isEqualTo(BigDecimal.valueOf(2000));
    }

    @Test
    void crediterCompte_shouldAddMont_inSoldeOfCompte(){

        Compte compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");
        BigDecimal montant = BigDecimal.valueOf(1000);

        classUnderTest.crediterCompte(compte, montant);

        assertThat(compte.getSolde()).isEqualTo(BigDecimal.valueOf(4000));
    }
}
