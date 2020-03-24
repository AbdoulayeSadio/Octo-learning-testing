package ma.octo.octoTesting.services;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.dao.ICompteDao;
import ma.octo.octoTesting.model.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Configuration
public class VirementService implements  IVirementService {

    private final Logger log = LoggerFactory.getLogger(VirementService.class);

   // @Autowired
    ICompteDao compteDao = new CompteDao();

    //@Autowired
    IAccountService accountService = new AccountService();

    //@Autowired
    IVirementValidator virementValidator = new VirementValidator();

    @Override
    public int performTransfert(String idEmetteur, String idRecepteur, BigDecimal montantToTranfert){
        //log.info("accountService : {}", accountService);
        Compte compteE = accountService.getCompte(idEmetteur);
        Compte compteR = accountService.getCompte(idRecepteur);

        if(!virementValidator.virementValidatorCompteEmetteur(compteE, montantToTranfert)) return -1;
        if(!virementValidator.virementValidatorCompteRecepteur(compteR)) return  -1;

        accountService.debiterCompte(compteE, montantToTranfert);
        accountService.crediterCompte(compteR, montantToTranfert);

        log.info("Virement du compte {} vers le compte {} fait avec succès", idEmetteur, idRecepteur);
        return 0;
    }
}
