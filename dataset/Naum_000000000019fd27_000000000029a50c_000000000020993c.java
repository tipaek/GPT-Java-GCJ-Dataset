import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int trace = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    a[j][k] = sc.nextInt();
                    if (j == k){
                        trace += a[j][k];
                    }
                }
            }
            int repeated_x = 0;
            int repeated_y = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < k; l++){
                        if (a[j][k] == a[j][l]){
                            repeated_x += 1;
                            k = n;
                            break;
                        }
                    }
                }
            }
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < k; l++){
                        if (a[k][j] == a[l][j]){
                            repeated_y += 1;
                            k = n;
                            break;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeated_x + " " + repeated_y);
        }
    }
    
}