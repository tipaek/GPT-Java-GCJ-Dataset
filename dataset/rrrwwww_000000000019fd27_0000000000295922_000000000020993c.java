import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer input;
        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            int[][] matrix = new int[n][n];
            int tr = 0;
            int r = 0;
            int c = 0;//trace, row, column
            //read values and assign in matrix
            for(int j = 0; j < n; j++) {
                input = new StringTokenizer(in.readLine());
                for(int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(input.nextToken());
                    if(j==k) 
                        k += matrix[j][k];
                }
            }
            //row
            for(int m = 0; m < n; m++) {
                ArrayList<Integer> list = new List<Integer>();
                for(int o = 0; o < matrix[m]; o++){
                    list.add(matrix[m][o]);
                    if(n != list.size())
                        r++;
                }
            }
            //column
            for(int p = 0; p < n; p++) {
                ArrayList<Integer> list = new List<Integer>();
                for(int q = 0; q < matrix[p]; q++){
                    list.add(matrix[p][q]);
                    if(n != list.size())
                        c++;
                }
            }
            out.println("Case #" + i + " " + tr + " " + r + " " + c);
        }
        out.close();
    }
}