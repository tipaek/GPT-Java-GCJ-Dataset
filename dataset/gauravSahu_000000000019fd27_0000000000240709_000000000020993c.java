import java.util.*;
class Solution {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String [] args) {
        int t = scn.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = scn.nextInt();
            int [][] arr = new int[n][n];
            solve(arr, n, i);
        }
    }
    public static void solve(int [][] arr, int n, int t) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int d_sum = 0;
        int row = 0;
        int col = 0;
        for(int i = 0; i < n; i++){
            boolean flag_row = false;
            for(int j = 0; j < n; j++){
                if(i == j){
                    d_sum += arr[i][j];
                }
                if(flag_row == false){
                    for(int k = j + 1; k < n; k++) {
                        if(arr[i][j] == arr[i][k]) {
                            flag_row = true;
                        }
                    }
                }
            }
            if(flag_row){
                row++;
            }
        }
        for(int j = 0; j < n; j++){
            boolean flag_col = false;
            for(int i = 0; i < n; i++){
                if(flag_col == false){
                    for(int k = i + 1; k < n; k++){
                        if(arr[i][j] == arr[k][j]){
                            flag_col = true;
                        }
                    }
                }
            }
            if(flag_col){
                col++;
            }
        }
        System.out.print("Case #"+t+": ");
        System.out.println(d_sum + " " + row + " " + col);
    }
}