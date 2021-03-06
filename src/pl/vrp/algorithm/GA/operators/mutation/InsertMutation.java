package pl.vrp.algorithm.GA.operators.mutation;

import pl.vrp.algorithm.GA.Chromosome;
import pl.vrp.algorithm.GA.Gene;
import pl.vrp.algorithm.GA.support.ProbabilityMathHelper;

public class InsertMutation {
	
    public static Chromosome mutateChromosome(float probability, Chromosome genes) {
    	
        Gene[] arrayOfGene;
        int j = (arrayOfGene = genes.getGenes()).length;
        
        for (int i = 0; i < j; i++) {
          Gene geneA = arrayOfGene[i];
          if (ProbabilityMathHelper.checkProbability(probability)) {
            Gene geneB = null;
            do {
                int randomIndex = ProbabilityMathHelper.randomInt(genes.getLenght());
                geneB = genes.getGene(randomIndex);
            } while (geneA == geneB);
            
            int indexA = genes.indexOf(geneA);
            int indexB = genes.indexOf(geneB);
            
            while (indexA + 1 < indexB) {
                genes.swapGenes(indexB, indexB - 1);
                indexB--;
            }
            
            while (indexA - 1 > indexB){
                genes.swapGenes(indexB, indexB + 1);
                indexB++;
            }
          }
        }
        return genes;
    }
}
