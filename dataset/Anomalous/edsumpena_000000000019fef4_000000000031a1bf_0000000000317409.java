import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int east = scanner.nextInt();
            int north = scanner.nextInt();
            String sequence = scanner.next();
            
            System.out.println("Case #" + caseNumber + ": " + findMinimumTime(east, north, sequence));
        }
        
        scanner.close();
    }
    
    private static String findMinimumTime(int east, int north, String sequence) {
        int[] position = {east, north};
        
        for (int i = 0; i < sequence.length(); i++) {
            char direction = sequence.charAt(i);
            
            switch (direction) {
                case 'N':
                    position[1]++;
                    break;
                case 'S':
                    position[1]--;
                    break;
                case 'E':
                    position[0]++;
                    break;
                case 'W':
                    position[0]--;
                    break;
            }
            
            if (Math.abs(position[0]) + Math.abs(position[1]) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        
        return "IMPOSSIBLE";
    }
}