package ma.octo.octoTesting.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class Compte {

    String idCompte;
    BigDecimal solde;
    String ownerCompte;

    public Compte(String idCompte, BigDecimal solde, String ownerCompte) {
        this.idCompte = idCompte;
        this.solde = solde;
        this.ownerCompte = ownerCompte;
    }
    public Compte(){}

    public String getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(String idCompte) {
        this.idCompte = idCompte;
    }

    public String getOwnerCompte() {
        return ownerCompte;
    }

    public void setOwnerCompte(String ownerCompte) {
        this.ownerCompte = ownerCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte='" + idCompte + '\'' +
                ", solde=" + solde +
                ", ownerCompte='" + ownerCompte + '\'' +
                '}';
    }
}
