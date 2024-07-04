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
                Set<Integer> list = new HashSet<>();
                for(int num: matrix[m]) {
                    list.add(matrix[m][o]);
                    if(n != list.size())
                        r++;
                }
            }
            //column
            for(int p = 0; p < n; p++) {
                Set<Integer> list1 = new HashSet<>();
                for(int q = 0; q < n; q++){
                    list1.add(matrix[p][q]);
                    if(n != list1.size())
                        c++;
                }
            }
            out.println("Case #" + i + " " + tr + " " + r + " " + c);
        }
        out.close();
    }
}