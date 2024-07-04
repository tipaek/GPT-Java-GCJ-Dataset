import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int dim = in.nextInt();
            boolean[][] c = new boolean[dim][dim];
            boolean[] col = new boolean[dim];
            int rows = 0;
            int coloumns = 0;
            int count = 0;
            for(int j = 0; j < dim; j++){
                boolean[] check = new boolean[dim];
                boolean r = false;
                for(int k = 0; k < dim; k++){
                    int a = in.nextInt();
                    if(c[k][a-1] && !col[k]){
                        col[k] = true;
                        coloumns++;
                    }
                    if(check[a-1]) r = true; 
                    check[a-1] = true;
                    c[k][a-1] = true;
                    if(j == k) count += a;
                
                }
                if(r) rows++;
            }
            System.out.println("Case #" + i + ": " + count + " " + rows + " " + coloumns);
        }
    }
}