import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(in.next());
        for(int i = 0 ; i < testCount ; i++){
            String dimension = in.next();
            String trace = in.next();
            int dimensionInt = Integer.parseInt(dimension);
            int traceInt = Integer.parseInt(trace);
            String[][] res = isLegal(dimensionInt, traceInt);
            System.out.print("Case #"+ (i+1)+ ": ");
            if (res.length>60 ||res[0].length>60){
                String impos = res[0][0];
                System.out.print(impos);
            }
            else{
                System.out.print("POSSIBLE");
                System.out.println();
                for(int p = 0 ; p < res.length; p++){
                    for(int j = 0; j < res[0].length; j++){
                        System.out.print(res[p][j]+ " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String[][] isLegal(int dimension, int trace) {
        Random rand = new Random();
        boolean isFound = true;
        int[][] candidateMatrix = new int[dimension][dimension];
        int counter = 0;
        while(isFound) {
            counter++;
            if (counter >= 1000) {
                String[][] noSol = new String[100][1];
                noSol[0][0] = "IMPOSSIBLE";
                return noSol;
            }
            candidateMatrix= new int[dimension][dimension];
            int[] candidates = findCandidate(trace,dimension);
            ArrayList<Integer> indexHist = new ArrayList<>();
            for(int integ : candidates){
                indexHist.add(integ);
            }
            for(int i = 0 ; i < candidateMatrix.length; i++){
                int index = rand.nextInt(indexHist.size());
                candidateMatrix[i][i] = indexHist.get(index);
                indexHist.remove(index);
            }
            for (int i = 0; i < candidateMatrix.length; i++) {
                for (int j = 0; j < candidateMatrix.length; j++) {
                    if (candidateMatrix[i][j] == 0) {
                        ArrayList<Integer> rows = new ArrayList<Integer>();
                        ArrayList<Integer> cols = new ArrayList<Integer>();
                        for (int k = 0; k < candidateMatrix.length; k++) {
                            rows.add(candidateMatrix[i][k]);
                        }
                        for (int m = 0; m < candidateMatrix.length; m++) {
                            cols.add(candidateMatrix[m][j]);
                        }
                        boolean found = false;
                        int count = 0;
                        while (!found) {
                            count++;
                            int randmValue = rand.nextInt(candidateMatrix.length) + 1;
                            if (count >= 1000) {
                                found = true;
                            }
                            if (!rows.contains(randmValue) && !cols.contains(randmValue)) {
                                found = true;
                                candidateMatrix[i][j] = randmValue;
                            }
                        }
                    }
                }
            }
            isFound = false;
            for (int i = 0; i < candidateMatrix.length; i++) {
                for (int j = 0; j < candidateMatrix.length; j++) {
                    if (candidateMatrix[i][j] == 0) {
                        isFound = true;
                    }
                }
            }
        }
        String [][] str = new String[dimension][dimension];
        for(int i = 0 ; i < dimension; i ++){
            for(int j = 0; j < dimension; j ++) {
                str[i][j] = String.valueOf(candidateMatrix[i][j]);
            }
        }
        return str;
    }

    private static int[] findCandidate(int trace, int dimension) {
        int[] monteCarlo = new int[dimension];
        boolean found = false;
        while(!found) {
            for (int i = 0; i < dimension; i++) {
                monteCarlo[i] = getRandomInteger(dimension+1, 1);
            }
            int sum = 0;
            for (int i = 0; i < monteCarlo.length; i++) {
                sum += monteCarlo[i];
            }
            if (sum == trace) {
                return monteCarlo;
            }
        }
        return null;
    }

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }


}
// java LastExo <test4.txt> out4.txt