import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for(int i = 1; i <= t; i++){
            int n = getInt();
            int[][] nums = new int[n][n];

            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    nums[j][k] = getInt();
                }
            }
            int trace = 0;
            for(int j = 0; j < n; j++){
                trace += nums[j][j];
            }
            int dupeRows = 0;
            for(int j = 0; j < n; j++){
                boolean[] isPresent = new boolean[n];
                for(int k = 0; k < n; k++){
                    int x = nums[j][k] - 1;
                    if(isPresent[x]){
                        dupeRows++;
                        break;
                    }
                    isPresent[x] = true;
                }
            }
            int dupeCols = 0;
            for(int j = 0; j < n; j++){
                boolean[] isPresent = new boolean[n];
                for(int k = 0; k < n; k++){
                    int x = nums[k][j] - 1;
                    if(isPresent[x]){
                        dupeCols++;
                        break;
                    }
                    isPresent[x] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + dupeRows + " " + dupeCols);
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static int getInt() throws IOException{
      int c = skipSpace();
      boolean isNeg = (char) c == '-';
      int out = 0;
      if(isNeg)
        c = input.read();
      do {
        out *= 10;
        out += c - '0';
        c = input.read();
      } while (c <= '9' && c >= '0');
      return (isNeg)? -out: out;
    }
    public static int skipSpace() throws IOException{
        int s = input.read();
        while(s == ' ' || s == '\n' || s == '\r') {
          s = input.read();
        }
        return s;
      }
}