package ma.octo.octoTesting.services;

import ma.octo.octoTesting.model.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VirementValidator implements IVirementValidator {

    private final Logger log = LoggerFactory.getLogger(VirementValidator.class);

    @Override
    public boolean virementValidatorCompteEmetteur(Compte compte, BigDecimal montant){

        BigDecimal zero = BigDecimal.valueOf(0);
        if(compte == null) return false;
        if (montant == null || montant.compareTo(zero) <= 0) return false;
        if (compte.getSolde().compareTo(montant) == -1) return false;
        log.info("Compte emetteur {} valide", compte.getIdCompte());
        return true;
    }

    @Override
    public boolean virementValidatorCompteRecepteur(Compte compte){
        if(compte == null) return false;
        log.info("Compte emetteur {} valide", compte.getIdCompte());
        return true;
    }
}
