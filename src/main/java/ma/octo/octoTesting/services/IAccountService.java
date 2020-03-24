package ma.octo.octoTesting.services;

import ma.octo.octoTesting.model.Compte;

import java.math.BigDecimal;

public interface IAccountService {
    public Compte getCompte(String idCompte);
    public BigDecimal getBalance(String idCompte);
    public void setBalance(String idCompte, BigDecimal montant);
    public void debiterCompte(Compte compte, BigDecimal montant);
    public void crediterCompte(Compte compte, BigDecimal montant);
}
