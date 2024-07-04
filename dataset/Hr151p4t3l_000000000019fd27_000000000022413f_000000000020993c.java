import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = 0;
        if(input.hasNextInt()) {
            T = input.nextInt();
        }
        
        for(int i = 0; i < T; i++) {
            int N = 0;
            if(input.hasNextInt()) {
                N = input.nextInt();
            }
            
            int[][] M = new int[N][N];
            int sum = 0;
            int rCount = 0;
            boolean rFlag = false;
            int cCount = 0;
            boolean[] cFlag = new boolean[N];
            
            for(int j = 0; j < N; j++) {
                rFlag = false;
                for(int k = 0; k < N; k++) {
                    if(input.hasNextInt()) {
                        M[j][k] = input.nextInt();
                        if(j == k) {
                            sum += M[j][k];
                        }
                        if(!rFlag) {
                            for(int l = k-1; l >= 0; l--) {
                                if(M[j][l] == M[j][k]) {
                                    rCount++;
                                    
                                    rFlag = true;
                                    break;
                                }
                            }
                        }
                        if(!cFlag[k]) {
                            for(int l = j-1; l >= 0; l--) {
                                if(M[l][k] == M[j][k]) {
                                    cCount++;
                                    cFlag[k] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + sum + " " + rCount + " " + cCount);
        }
    }
}