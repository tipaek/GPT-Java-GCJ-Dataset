import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            List<Integer> permutationList = generatePermutationList(n);
            List<String> rowStrings = generateRowStrings(permutationList, n);
            List<List<String>> permutations = permute(rowStrings.toArray(new String[0]));
            
            boolean isPossible = false;
            int traceIndex = -1;
            
            for (int i = 0; i < permutations.size(); i++) {
                if (calculateTrace(permutations.get(i)) == k) {
                    isPossible = true;
                    traceIndex = i;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNum + ": ");
            if (isPossible) {
                System.out.println("POSSIBLE");
                printSolution(permutations.get(traceIndex), n);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    
    private static List<Integer> generatePermutationList(int n) {
        List<Integer> permutationList = new ArrayList<>();
        int p = n + 1;
        
        for (int i = 1; i <= n; i++) {
            for (int temp = p; temp <= n; temp++) {
                permutationList.add(temp);
            }
            for (int j = 1; j < p; j++) {
                permutationList.add(j);
            }
            p--;
        }
        
        return permutationList;
    }
    
    private static List<String> generateRowStrings(List<Integer> permutationList, int n) {
        List<String> rowStrings = new ArrayList<>();
        StringBuilder rowString = new StringBuilder();
        int count = 0;
        
        for (int num : permutationList) {
            rowString.append(num);
            count++;
            if (count % n == 0) {
                rowStrings.add(rowString.toString());
                rowString.setLength(0);
            }
        }
        
        return rowStrings;
    }
    
    private static int calculateTrace(List<String> matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.size(); i++) {
            trace += Character.getNumericValue(matrix.get(i).charAt(i));
        }
        return trace;
    }
    
    private static void printSolution(List<String> solution, int n) {
        for (String row : solution) {
            for (int i = 0; i < n; i++) {
                System.out.print(row.charAt(i) + (i == n - 1 ? "\n" : " "));
            }
        }
    }
    
    public static List<List<String>> permute(String[] num) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (String s : num) {
            List<List<String>> current = new ArrayList<>();
            for (List<String> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    List<String> temp = new ArrayList<>(l);
                    temp.add(j, s);
                    current.add(temp);
                }
            }
            result = current;
        }
        
        return result;
    }
}