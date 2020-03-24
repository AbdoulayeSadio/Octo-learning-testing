package ma.octo.octoTesting.dao;

import ma.octo.octoTesting.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Configuration
public class CompteDao implements ICompteDao {

    private Map<String, Compte> comptes = null;
    public CompteDao() {
        initComptes();
    }


    private void initComptes(){
        comptes = new LinkedHashMap<>();
        Compte cpt1 = new Compte("123", BigDecimal.valueOf(300000000), "barry");
        Compte cpt2 = new Compte("456", BigDecimal.valueOf(120000), "Jean");
        Compte cpt3 = new Compte("789", BigDecimal.valueOf(50000), "Joseph");
        Compte cpt4 = new Compte("987", BigDecimal.valueOf(30000), "Karim");
        this.comptes.put(cpt1.getIdCompte(), cpt1);
        this.comptes.put(cpt2.getIdCompte(), cpt2);
        this.comptes.put(cpt3.getIdCompte(), cpt3);
        this.comptes.put(cpt4.getIdCompte(), cpt4);
    }

    @Override
    public Compte getCompteByIdCompte(String idCompte) {
        this.initComptes();
        return this.comptes.get(idCompte);
    }

}
