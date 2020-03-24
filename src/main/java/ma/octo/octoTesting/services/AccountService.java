package ma.octo.octoTesting.services;

import ma.octo.octoTesting.dao.CompteDao;
import ma.octo.octoTesting.dao.ICompteDao;
import ma.octo.octoTesting.model.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.math.BigDecimal;

@Service
@Configuration
public class AccountService implements  IAccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    public AccountService(){}

    //@Autowired
    ICompteDao compteDao = new CompteDao();

    @Override
    public Compte getCompte(String idCompte){

        return compteDao.getCompteByIdCompte(idCompte);
    }

    @Override
    public BigDecimal getBalance(String idCompte){
        return getCompte(idCompte).getSolde();
    }

    @Override
    public void setBalance(String idCompte, BigDecimal montant){
         getCompte(idCompte).setSolde(montant);
    }

    @Override
    public void debiterCompte(Compte compte, BigDecimal montant){
        log.info("debut du debitement du compte {} ", compte.getIdCompte());
        BigDecimal actualBalance = compte.getSolde();
        actualBalance = actualBalance.subtract(montant);
        compte.setSolde(actualBalance);
        log.info("debitement du compte {} réussi", compte.getIdCompte());
    }

    @Override
    public void crediterCompte(Compte compte, BigDecimal montant){
        log.info("debut d accreditation du compte {} ", compte.getIdCompte());
        BigDecimal actualBalance = compte.getSolde();
        actualBalance = actualBalance.add(montant);
        compte.setSolde(actualBalance);
        log.info("acreditation du compte {} réussie", compte.getIdCompte());
    }

}
