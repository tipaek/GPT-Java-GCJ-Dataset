
import javafx.util.Pair;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= tCases; ++t) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] floor = new int[R][C];

            for (int i = 0; i <R ; i++) {
                for (int j = 0; j <C ; j++) {
                    floor[i][j] = in.nextInt();
                }
            }
            // competitionScore is the sum of all rounds
            int competitionScore = 0;
            boolean canContinueRound = true;
            // while can still make rounds
            while (canContinueRound) {
                ArrayList<Pair<Integer, Integer>> pairsToBeRemoved = new ArrayList<>();
                int roundScore = 0;
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        roundScore += floor[i][j];
                        int north = findNorthCN(floor, i, j - 1, R, C);
                        int south = findSouthCN(floor, i, j + 1, R, C);
                        int east = findEastCN(floor, i + 1, j, R, C);
                        int west = findWestCN(floor, i - 1, j, R, C);
                        double count = ((north > 0) ? 1 : 0) + ((south > 0) ? 1 : 0) + ((east > 0) ? 1 : 0) + ((west > 0) ? 1 : 0) ;
                        // TODO break if count is one
                        double sum = north + south + east + west;
                        double average = sum / count;
                        // keep if skill is equal to average skill and up
                        if (floor[i][j] < average) {
                            // add to list of pairs to be removed
                            pairsToBeRemoved.add(new Pair(i, j));
                        }
                    }
                }
                // calculate round score  and add it to competition score
                competitionScore += roundScore;
                // remove pairs from matrix
                int numberOfEleminations = pairsToBeRemoved.size();
                for (int i = 0; i < numberOfEleminations; i++) {
                    Pair<Integer, Integer> p = pairsToBeRemoved.get(i);
                    floor[p.getKey()][p.getValue()] = 0;

                }
                pairsToBeRemoved.clear();
                // if no one is eleminated then it was the final round
                if (numberOfEleminations == 0) {
                    canContinueRound = false;
                }

            }

            System.out.println("Case #" + t + ": " + competitionScore);
        }
    }
    //CN Stands for compassNeibor
    // return the element north to current position
    static int findNorthCN(int[][] floor, int row, int col, int rowMax, int colMax){
        // general validation

        if (row < 0 ||row >= rowMax|| col < 0 ||col >= colMax)
            return 0;
        return (floor[row][col]>0) ? floor[row][col]: findNorthCN(floor, row, col - 1, rowMax, colMax);
    }

    static int findSouthCN(int[][]floor, int row, int col, int rowMax, int colMax){
        // general validation
        if (row < 0 ||row >= rowMax|| col < 0 ||col >= colMax)
            return 0;
        return (floor[row][col]>0) ? floor[row][col]: findSouthCN(floor, row, col + 1, rowMax, colMax);
    }

    static int findWestCN(int[][]floor, int row, int col, int rowMax, int colMax){
        // general validation
        if (row < 0 ||row >= rowMax|| col < 0 ||col >= colMax)
            return 0;
        return (floor[row][col]>0) ? floor[row][col]: findWestCN(floor, row - 1, col , rowMax, colMax);
    }
    // return the element north to current position
    static int findEastCN(int[][]floor, int row, int col, int rowMax, int colMax){
        // general validation
        if (row < 0 ||row >= rowMax|| col < 0 ||col >= colMax)
            return 0;
        return (floor[row][col]>0) ? floor[row][col]: findEastCN(floor, row, col + 1, rowMax, colMax);
    }

}