import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            List<Pair> shuffles = calculateShuffles(n, m);
            System.out.println("Case #" + caseNumber + ": " + shuffles.size());
            
            for (int index = 0; index < shuffles.size(); index++) {
                System.out.print(shuffles.get(index).a + " " + shuffles.get(index).b);
                if (index < shuffles.size() - 1) {
                    System.out.println();
                }
            }
        }
    }
    
    private static List<Pair> calculateShuffles(int rows, int columns) {
        List<Pair> shuffles = new ArrayList<>();
        
        if (columns == 1) {
            return shuffles;
        }
        
        int counter = 0;
        for (int b = rows * columns - rows - 1; counter / (columns - 1) < rows - 1; b--) {
            int a = rows - (counter++ / (columns - 1));
            shuffles.add(new Pair(a, b));
        }
        
        return shuffles;
    }
    
    static class Pair {
        int a;
        int b;
        
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}