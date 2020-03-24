package ma.octo.octoTesting.services;

import java.math.BigDecimal;

public interface IVirementService {

    public int performTransfert(String idEmetteur, String idRecepteur, BigDecimal montantToTranfert);
}

