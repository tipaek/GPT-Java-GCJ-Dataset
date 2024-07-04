import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(); // Number of rows

            int repeatedCols = 0;
            int repeatedRows = 0;
            int sumOfDiagonal = 0;

            // Initialize column sets
            List<Set<Integer>> columnSets = new ArrayList<>(n);
            for (int j = 0; j < n; j++){
                columnSets.add(new HashSet<>());
            }

            for (int j = 0; j < n; j++){
                // Row set
                Set<Integer> set = new HashSet<>();
                boolean isRepeated = false;
                for (int k = 0; k < n; k++){
                    int element = in.nextInt();
                    if (set.contains(element)){
                        isRepeated = true;
                    }
                    set.add(element);
                    columnSets.get(k).add(element);
                    if (k == j){
                        sumOfDiagonal += element;
                    }
                }
                if (isRepeated){
                    repeatedRows++;
                }
            }

            for (Set<Integer> columnSet : columnSets){
                if (columnSet.size() < n){
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + i + ": " + sumOfDiagonal + " " + repeatedRows + " " + repeatedCols);
        }
    }
}