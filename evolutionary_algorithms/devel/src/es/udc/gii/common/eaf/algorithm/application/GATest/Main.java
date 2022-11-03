package es.udc.gii.common.eaf.algorithm.application.GATest;

import es.udc.gii.common.eaf.algorithm.EvolutionaryAlgorithm;
import es.udc.gii.common.eaf.facade.EAFFacade;
import es.udc.gii.common.eaf.stoptest.StopTest;
import es.udc.gii.common.eaf.util.EAFRandom;

public class Main {

    public static void main(String[] args) {
        
    

    EAFFacade facade = new EAFFacade();
    EvolutionaryAlgorithm algorithm;
    StopTest stopTest;
    EAFRandom.init();
    
    
    String eaConfig = SimulationConfiguration.getEaConfigFile();
    System.out.println("Using EA config file: " + eaConfig);
    algorithm = facade.createAlgorithm("./" + eaConfig);
    stopTest = facade.createStopTest("./" + eaConfig);
    
    
    var iniTime = System.currentTimeMillis();
    facade.resolve(stopTest, algorithm);

    
    }
}


