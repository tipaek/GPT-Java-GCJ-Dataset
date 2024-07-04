
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            List<String> output = new ArrayList<>(numberOfCases);
            for (int i = 0; i < numberOfCases; i++) {
                int size = Integer.parseInt(br.readLine());
                int[][] matrix = new int[size][size];
                int trace = 0;
                int rowsDuplicate = 0;
                int colsDuplicate = 0;
                Map<Integer, Set<Integer>> rowsMap = new HashMap<>();
                Map<Integer, Boolean> map = new HashMap<>();
                for (int j = 0; j < size; j++) {
                    String[] input = br.readLine().split(" ");
                    Set<Integer> dups = new HashSet<>(size);
                    boolean dAdded = false;
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = Integer.parseInt(input[k]);
                        if (!dAdded && !dups.add(matrix[j][k])) {
                            dAdded = true;
                            rowsDuplicate++;
                        }
                        if (map.get(k) != Boolean.TRUE) {
                            rowsMap.putIfAbsent(k, new HashSet<>(size));
                            if (!rowsMap.get(k).add(matrix[j][k])) {
                                colsDuplicate++;
                                map.put(k, Boolean.TRUE);
                            }
                        }

                        if (k == j) {
                            trace += matrix[j][k];
                        }
                    }

                }
                output.add("Case #" + i + ": " + trace + " " + rowsDuplicate + " " + colsDuplicate);
            }
            output.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
