import java.io.*;
import java.util.*;

public class Solution {
    
    static int[] order;
    static ArrayList<Integer[]> permutations;
    
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(new Locale("US"));
            int testCases = scanner.nextInt();
            
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                
                Integer[] initialList = new Integer[n];
                for (int i = 0; i < n; i++) initialList[i] = i;
                permutations = new ArrayList<>();
                generatePermutations(initialList, permutations, new Integer[n], 0, false);
                
                String result = "IMPOSSIBLE";
                
                if (n <= 5) {
                    order = new int[n];
                    int[][] matrix = generateMatrix(0, n, k);
                    if (matrix != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("POSSIBLE\n");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                sb.append(matrix[i][j]);
                                if (j < n - 1) sb.append(" ");
                                else sb.append("\n");
                            }
                        }
                        result = sb.toString();
                    }
                }
                
                System.out.printf("Case #%d: %s%n", t, result);
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
    
    static int[][] generateMatrix(int level, int n, int k) {
        int[][] matrix = null;
        if (level < n) {
            for (int i = 0; i < n; i++) {
                boolean used = false;
                for (int j = 0; j < level; j++) {
                    if (order[j] == i) {
                        used = true;
                        break;
                    }
                }
                if (!used) {
                    order[level] = i;
                    matrix = generateMatrix(level + 1, n, k);
                    if (matrix != null) break;
                }
            }
        } else {
            for (Integer[] perm : permutations) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += perm[(n - order[i] + i) % n] + 1;
                }
                
                if (sum == k) {
                    matrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = perm[(n - order[i] + j) % n] + 1;
                        }
                    }
                }
            }
        }
        
        return matrix;
    }
    
    static <T> void generatePermutations(T[] elements, List<T[]> permutations, T[] permutation, int level, boolean noDuplicates) {
        HashSet<T> usedElements = noDuplicates ? new HashSet<>() : null;
        if (level < permutation.length) {
            for (int i = 0; i < elements.length; i++) {
                T element = elements[i];
                if (element != null) {
                    if (usedElements != null && usedElements.contains(element)) continue;
                    if (usedElements != null) usedElements.add(element);
                    T[] newPerm = permutation.clone();
                    newPerm[level] = element;
                    elements[i] = null;
                    generatePermutations(elements, permutations, newPerm, level + 1, noDuplicates);
                    elements[i] = element;
                }
            }
        } else {
            permutations.add(permutation);
        }
    }
}