import java.io.*;
import java.util.*;

public class Solution {
    
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            processCase(caseNumber);
        }
    }
    
    private static void processCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        String movements = st.nextToken();
        
        int currX = X;
        int currY = Y;
        
        for (int i = 1; i <= movements.length(); i++) {
            char move = movements.charAt(i - 1);
            
            switch (move) {
                case 'N': currY++; break;
                case 'S': currY--; break;
                case 'E': currX++; break;
                case 'W': currX--; break;
            }
            
            if (Math.abs(currX) + Math.abs(currY) <= i) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}