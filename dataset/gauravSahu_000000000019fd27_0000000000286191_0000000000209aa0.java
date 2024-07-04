import java.util.*;

class Solution {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String [] args) {
        int t = scn.nextInt();
        for(int i = 1; i <= t; i++){
            int n = scn.nextInt();
            int k = scn.nextInt();
            solve(n,k, i);
        }
    }
    static boolean flag = false;
    static void solve(int n, int k, int t){
        int [][] arr = new int[n][n];
        isPossible(arr, k, 0, 0, 0, t);
        if(flag == false)
            System.out.println("Case #" + t +": Impossible");
    }

    static void print(int [][] arr, int t){
        System.out.println("Case #" + t +": " + "POSSIBLE");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void isPossible(int [][] arr, int k, int row, int col, int tr, int t){
        if(row == arr.length && col == 0){
            if(tr == k){
                flag = true;
                print(arr, t);
            }
            return;
        }
        if(col == arr.length - 1){
            for(int j = 1; j <= arr.length; j++){
                if(isSafe(arr, row, col, j)){
                    arr[row][col] = j;
                    if(row == col)
                        tr += arr[row][col];
                    isPossible(arr, k, row + 1, 0, tr, t);
                    if(flag == true) return;
                    if(row == col)
                        tr -= arr[row][col];
                    arr[row][col] = 0;
                }
            }
        }
        else{
            for(int j = 1; j <= arr.length; j++){
                if(isSafe(arr, row, col, j)){
                    arr[row][col] = j;
                    if(row == col)
                        tr += arr[row][col];
                    isPossible(arr, k, row, col + 1, tr, t);
                    if(flag == true) return;
                    if(row == col)
                        tr -= arr[row][col];
                    arr[row][col] = 0;
                }
            }
        }
    }
    static boolean isSafe(int [][] arr, int row, int col, int val) {
        for(int i = 0; i < row; i++){ // checking row if their is any value present as same as val
            if(arr[i][col] == val){
                return false;
            }
        }
        for(int j = 0; j < col; j++){ // checking col if their is any value present as samse as val
            if(arr[row][j] == val){
                return false;
            }
        }
        return true;
    }
}
