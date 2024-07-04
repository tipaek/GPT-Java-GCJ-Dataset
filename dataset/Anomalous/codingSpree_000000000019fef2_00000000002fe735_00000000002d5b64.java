import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int rank = scanner.nextInt();
            int suit = scanner.nextInt();
            List<Integer> result = calculateOrder(rank, suit);
            int numPairs = result.size() / 2;
            
            System.out.println("Case #" + caseNum + ": " + numPairs);
            for (int i = 0; i < result.size(); i += 2) {
                System.out.println(result.get(i) + " " + result.get(i + 1));
            }
        }
    }
    
    public static List<Integer> calculateOrder(int rank, int suit) {
        List<Integer> steps = new ArrayList<>();
        int currentRank = rank - 1;
        int suitCount = 0;
        
        for (int i = rank * (suit - 1); i >= suit; i--) {
            steps.add(i);
            steps.add(currentRank);
            suitCount++;
            
            if (suitCount == suit - 1) {
                suitCount = 0;
                currentRank--;
            }
        }
        
        return steps;
    }
}