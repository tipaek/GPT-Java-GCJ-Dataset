import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String path = scanner.next();
                int moves = 0, currentDistance = 0;
                String result = "IMPOSSIBLE";
                for (char c : path.toCharArray()) {
                    switch (c) {
                        case 'E' : x++; break;  
                        case 'W' : x--; break;
                        case 'N' : y++; break;
                        case 'S' : y--; break;
                    }
                    currentDistance = Math.abs(x) + Math.abs(y);
                    moves++;
                    if (currentDistance <= moves) {
                        result = String.valueOf(moves);
                        break;
                    }
                }
                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}