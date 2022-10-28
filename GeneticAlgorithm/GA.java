import java.util.Random;

//Main class
public class GA {

    Population population = new Population();
    
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

 //Selection
 void selection() {

    //Select the most fittest individual
    fittest = population.getFittest();

    //Select the second most fittest individual
    secondFittest = population.getSecondFittest();
}

//Crossover
void crossover() {
    Random rn = new Random();

    //Select a random crossover point
    int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);

    //Swap values among parents
    for (int i = 0; i < crossOverPoint; i++) {
        int temp = fittest.genes[i];
        fittest.genes[i] = secondFittest.genes[i];
        secondFittest.genes[i] = temp;

    }

}

//Mutation
void mutation() {
    Random rn = new Random();

    //Select a random mutation point
    int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

    //Mutate at mutation point
    if (fittest.genes[mutationPoint] >= 5) {
        fittest.genes[mutationPoint] = 0 ;
    } else {
        fittest.genes[mutationPoint] = rn.nextInt(8);
    }

    mutationPoint = rn.nextInt(population.individuals[0].geneLength);

    if (secondFittest.genes[mutationPoint] <= 4) {
        secondFittest.genes[mutationPoint] = 0;
    } else {
        secondFittest.genes[mutationPoint] = rn.nextInt(8);
    }
}

//Get fittest offspring
Individual getFittestOffspring() {
    if (fittest.fitness > secondFittest.fitness) {
        return fittest;
    }
    return secondFittest;
}


//Replace least fittest individual from most fittest offspring
void adDFittestOffspring() {

    //Update fitness values of offspring
    fittest.calcFitness2();
    secondFittest.calcFitness2();

    //Get index of least fit individual
    int leastFittestIndex = population.getLeastFittestIndex();

    //Replace least fittest individual from most fittest offspring
    population.individuals[leastFittestIndex] = getFittestOffspring();
}


public static void main(String[] args) {

    Random rn = new Random();

    GA demo = new GA();

    //Initialize population
    demo.population.initializePopulation(10);

    //Calculate fitness of each individual
    demo.population.calculateFitness();

    System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);

    //While population gets an individual with maximum fitness
    while (demo.population.fittest < 10) {
        ++demo.generationCount;

        //Do selection
        demo.selection();

        //Do crossover
        demo.crossover();

        //Do mutation under a random probability
        if (rn.nextInt()%7 < 5) {
            demo.mutation();
        }

        //Add fittest offspring to population
        demo.adDFittestOffspring();

        //Calculate new fitness value
        demo.population.calculateFitness();

        System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
        System.out.print("Fittest genes: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(demo.population.getFittest().genes[i]);
        }
        System.out.println();
    }

    System.out.println("\nSolution found in generation " + demo.generationCount);
    System.out.println("Fitness: "+demo.population.getFittest().fitness);
    System.out.print("Winner genes: ");
    for (int i = 0; i < 10; i++) {
        System.out.print(demo.population.getFittest().genes[i]);
    }

    System.out.println("");

}





}