import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightForWeights {


    public static void main(String[] args) {


    }



    public static String orderWeight(String weights) {
        weights = weights.trim();
        String[] split = weights.split(" ");
        List<FatToFit> weightsOfWeights = new ArrayList<>();

        for (String currentWeight : split) {
            int weight = 0;
            for (int j = 0; j < currentWeight.length(); j++) {
                weight += Character.getNumericValue(currentWeight.charAt(j));
            }
            FatToFit person = new FatToFit(currentWeight, weight);
            weightsOfWeights.add(person);

        }

        Collections.sort(weightsOfWeights);
        StringBuilder finalOutputOfWeights = new StringBuilder();

        for (int i = 0; i < weightsOfWeights.size(); i++) {
            finalOutputOfWeights.append(weightsOfWeights.get(i).getActualWeight()).append(" ");
        }

        return finalOutputOfWeights.toString().trim();
    }

    private static class FatToFit implements Comparable<FatToFit> {

        private String actualWeight;
        private Integer weight;
        public FatToFit(String actualWeight, Integer weight) {
            this.actualWeight = actualWeight;
            this.weight = weight;
        }

        public String getActualWeight() {
            return actualWeight;
        }

        public Integer getWeight() {
            return weight;
        }


        @Override
        public int compareTo(FatToFit fattyTwo) {

            if(weight.equals(fattyTwo.getWeight()) && !actualWeight.equals(fattyTwo.getActualWeight())) {
                // same weight so we do it on the order they came in
                return actualWeight.compareTo(fattyTwo.getActualWeight());
            } else {
                return weight - fattyTwo.getWeight();
            }
        }
    }


    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightForWeights.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightForWeights.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

}
