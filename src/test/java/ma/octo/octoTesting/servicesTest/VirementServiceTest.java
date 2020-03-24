package ma.octo.octoTesting.servicesTest;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.model.Compte;
import ma.octo.octoTesting.services.AccountService;
import ma.octo.octoTesting.services.VirementService;
import ma.octo.octoTesting.services.VirementValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class VirementServiceTest {

    @Mock
    CompteDao compteDao;

    @Mock
    AccountService accountService;

    @Mock
    VirementValidator virementValidator;

    VirementService classUnderTest;
    Compte compteE;
    Compte compteR;

    @BeforeEach
    public void init(){
        classUnderTest = new VirementService();
        compteE = new Compte("123", BigDecimal.valueOf(30000), "Karim");
        compteR = new Compte("456", BigDecimal.valueOf(20000), "Jean");
    }

    @Test
    void performTransfert_shouldPerformeTransfert_whenAllAreRight(){

        String idcompteE = "123";
        String idCompteR = "456";
        BigDecimal montant = BigDecimal.valueOf(4000);

        Mockito.lenient().when(accountService.getCompte(idcompteE)).thenReturn(null);
        Mockito.lenient().when(accountService.getCompte(idCompteR)).thenReturn(compteR);

        Mockito.lenient().when(virementValidator.virementValidatorCompteEmetteur(compteE, montant)).thenReturn(false);
        Mockito.lenient().when(virementValidator.virementValidatorCompteRecepteur(compteR)).thenReturn(true);

        int actual = classUnderTest.performTransfert(idcompteE, idCompteR, montant);

        assertThat(actual).isEqualTo(0);

    }
}
