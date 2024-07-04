import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            long trace = 0;
            int r = 0, c = 0;
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) trace += arr[j][k];
                    
                    if (!rowFlags[j]) {
                        for (int l = 0; l < k; l++) {
                            if (arr[j][l] == arr[j][k]) {
                                rowFlags[j] = true;
                                r++;
                                break;
                            }
                        }
                    }
                    
                    if (!colFlags[k]) {
                        for (int l = 0; l < j; l++) {
                            if (arr[l][k] == arr[j][k]) {
                                colFlags[k] = true;
                                c++;
                                break;
                            }
                        }
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);
        }
        
        sc.close();
    }
}