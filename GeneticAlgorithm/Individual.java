import java.util.Random;

//Individual class
class Individual {

    int fitness = 0;
    int[] genes = new int[10];
    int geneLength = 10;

    public Individual() {
        Random rn = new Random();
       

        //Set genes randomly for each individual
        for (int i = 0; i < genes.length; i++) {
            
            
            genes[i] = Math.abs(rn.nextInt()%20);
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes[i] == 0) {
                ++fitness;
            }
        }
    }

    public void calcFitness2() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes[i]*genes[i] == 0) {
                ++fitness;
            }
        }
    }

}
