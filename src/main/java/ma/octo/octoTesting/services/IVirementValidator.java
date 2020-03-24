package ma.octo.octoTesting.services;

import ma.octo.octoTesting.model.Compte;

import java.math.BigDecimal;

public interface IVirementValidator {

    public boolean virementValidatorCompteEmetteur(Compte compte, BigDecimal montant);
    public boolean virementValidatorCompteRecepteur(Compte compte);
}
