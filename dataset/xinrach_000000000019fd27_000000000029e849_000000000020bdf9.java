import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++){
            int n = Integer.parseInt(br.readLine());
            String ans = "C";
            int [][] arr = new int [n][2];
            for (int i = 0; i < n; i++){
                input = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++){
                    arr[i][j] = Integer.parseInt(input.nextToken());
                }
            }
            int c = arr[0][1];
            int j = 0;
            for (int i = 1; i < n; i++){
                if (arr[i][0] >= c){
                    c = arr[i][1];
                    ans += "C";
                }
                else if (arr[i][0] >= j){
                    j = arr[i][1];
                    ans += "J";
                }
            }
            if (ans.length() != n){
                ans = "IMPOSSIBLE";
            } 
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}