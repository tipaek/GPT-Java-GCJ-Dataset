import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i < t; i++){
            int n = Integer.parseInt(in.nextLine());
            int[][] mat = getMat(in, n);
        }
    }

    public static int[][] getMat(Scanner in, int n){
        int[][] mat = new int[n][n];
        for(int i =0 ; i<n; i++){
            String s = in.nextLine();
            System.out.println(s);
        }
        return mat;
    }

}


    