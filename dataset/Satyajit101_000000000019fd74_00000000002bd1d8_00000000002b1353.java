import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ": ");
            System.out.println(pascalSum(n));
        }
    }

    public static String pascalSum(int n){
       int [][] pascal = new int[31][31];

        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0)
                    pascal[i][j] = 1;
                else
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        pascal[0][0] = 1;
       for(int i = 1; i < pascal.length; i++) {
           for(int j = 0; j <= i; j++) {
               if(j != i) {
                   pascal[i][j] = pascal[i-1][j] + pascal[i][j];
               } else {
                   pascal[i][j] = pascal[i-1][j-1] + pascal[i][j];
               }
           }
       }

       StringBuffer out = new StringBuffer();
        for(int i = 0; i < pascal.length; i++) {
            for(int j = 0; j <= i; j++) {
               if(pascal[i][j] == n){
                   int x = i;
                   int y = j;
                   while(x >= 0) {
                       out.insert(0, "\n" + (x+1) + " " + (y+1));
                       if(y > 0 && y >= x) y--;
                       x--;
                   }
                   return out.toString().trim();
               }
            }
        }
       return "";
    }

}
