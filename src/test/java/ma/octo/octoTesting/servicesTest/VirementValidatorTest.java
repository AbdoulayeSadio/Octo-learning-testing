package ma.octo.octoTesting.servicesTest;

import ma.octo.octoTesting.model.Compte;
import ma.octo.octoTesting.services.VirementValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class VirementValidatorTest {

    VirementValidator classUnderTest;
    public Compte compte;

    @BeforeEach
    public void init(){
        classUnderTest = new VirementValidator();
        compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");
    }

    @Test
    void virementValidatorCompteEmetteur_shouldReturnTrue_whenAllAreRight(){

        //Compte compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");
        BigDecimal montant = BigDecimal.valueOf(1000);

        boolean actual = classUnderTest.virementValidatorCompteEmetteur(compte, montant);

        assertThat(actual).isTrue();
    }

    @Test
    void virementValidatorCompteEmetteur_shouldReturnFalse_whenCompteIsNull(){

        BigDecimal montant = BigDecimal.valueOf(1000);

        boolean actual = classUnderTest.virementValidatorCompteEmetteur(null, montant);

        assertThat(actual).isFalse();
    }

    @Test
    void virementValidatorCompteEmetteur_shouldReturnFalse_whenMontantIsZero(){

        //Compte compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");
        BigDecimal montant = BigDecimal.valueOf(0);

        boolean actual = classUnderTest.virementValidatorCompteEmetteur(compte, montant);

        assertThat(actual).isFalse();
    }

    @Test
    void virementValidatorCompteEmetteur_shouldReturnFalse_whenMontantIsNull(){

        //Compte compte = new Compte("123", BigDecimal.valueOf(3000), "Karim");

        boolean actual = classUnderTest.virementValidatorCompteEmetteur(compte, null);

        assertThat(actual).isFalse();
    }

    @Test
    void virementValidatorCompteEmetteur_shouldReturnFalse_whenMontantIsNegatif(){


        BigDecimal montant = BigDecimal.valueOf(-2000);

        boolean actual = classUnderTest.virementValidatorCompteEmetteur(compte, montant);

        assertThat(actual).isFalse();
    }

    @Test
    public void virementValidatorCompteRecepteur_shouldReturnTrue_whenCompteNotNull(){

        boolean actual = classUnderTest.virementValidatorCompteRecepteur(compte);

        assertThat(actual).isTrue();
    }

    @Test
    public void virementValidatorCompteRecepteur_shouldReturnFalse_whenCompteIsNull(){

        boolean actual = classUnderTest.virementValidatorCompteRecepteur(null);

        assertThat(actual).isFalse();
    }
}
