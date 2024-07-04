import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = in.nextInt();
            System.out.println("Case #" + caseNum + ": ");
            
            System.out.println("1 1");
            N--;
            
            int nextV = 1;
            int nextRow = 2;
            while (N >= nextV) {
                System.out.println(nextRow + " 2");
                N-=nextV;
                nextV++;
                nextRow++;
            }
            
            if (N >= 1) {
                nextRow--;
            }
            
            while (N >= 1) {
                System.out.println(nextRow + " 1");
                N--;
                nextRow++;
            }
            
        }
    }
}