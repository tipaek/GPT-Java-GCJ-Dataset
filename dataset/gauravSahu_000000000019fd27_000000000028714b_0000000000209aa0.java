//indicium 5th
import java.io.*;
import java.util.*;
class Solution {

    public static boolean isValid(int[][] arr, int r, int c, int cho) {
        for(int j = c - 1 ; j >= 0; j--) {
            if(arr[r][j] == cho) return false;
        }

        for(int i = r - 1 ; i >= 0; i--) {
            if(arr[i][c] == cho) return false;
        }

        return true;
    } 


    public static void printAnswer(int[][] arr, int ct) {
        System.out.println("Case #" + ct +": " + "POSSIBLE");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean flag = false;

    public static void getAnswer(int[][] arr, int i, int j, int trace, int ct, int m) {        
        if(i == arr.length && j == 0) {
            if(trace == m) {
                // System.out.println("hello-" + trace);
                // flag = true;
                flag = true;
                printAnswer(arr, ct);
            }
            return;
        }
        
        if(j == arr[0].length - 1) {
            for(int c = 1; c <= arr.length; c++) {
                if(isValid(arr, i, j, c) == true) {
                    arr[i][j] = c;
                    if(i == j) trace += c;
                    getAnswer(arr, i + 1, 0, trace, ct, m);
                    if(flag == true) return;
                    if(i == j) trace -= c;
                    arr[i][j] = 0;
                }
            }
        }
        else {
            for(int c = 1; c <= arr.length; c++) {
                if(isValid(arr, i, j, c) == true) {
                    arr[i][j] = c;
                    if(i == j) trace += c;
                    getAnswer(arr, i , j + 1, trace, ct, m);
                    if(flag == true) return;
                    if(i == j) trace -= c;
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();

        int ct = 1;
        while(ct <= t) {
            flag = false;
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[][] arr = new int[n][n];

            getAnswer(arr, 0, 0, 0, ct, m);
            if(flag == false) {
                System.out.println("Case #" + ct + ": " + "IMPOSSIBLE");
            }
            ct++;
        }
    }
}

