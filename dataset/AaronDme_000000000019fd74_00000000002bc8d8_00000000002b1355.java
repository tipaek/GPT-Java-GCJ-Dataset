import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for(int i = 1; i <= t; i++){
          System.out.print("Case #" + i + ": ");
           int r = getInt();
           int c = getInt();
          long out = 0;
           int[][] floor = new int[r][c];

          for(int j = 0; j < r; j++){
            for(int k = 0; k < c; k++){
              floor[j][k] = getInt();
            }
          }
          
          while(true){
            LinkedList<int[]> toEliminate = new LinkedList<>();
            for(int j = 0; j < r; j++){
              for(int k = 0; k < c; k++){
                if(floor[j][k] == 0)
                  continue;
                out += floor[j][k];
                int neighboutCount = 0;
                int sumOfNeighbours = 0;
                int a = k - 1;
                while(a >= 0){
                  if(floor[j][a] != 0){
                    sumOfNeighbours += floor[j][a];
                    neighboutCount++;
                    break;
                  }
                  a--;
                }
                a = k + 1;
                while(a < c){
                  if(floor[j][a] != 0){
                    sumOfNeighbours += floor[j][a];
                    neighboutCount++;
                    break;
                  }
                  a++;
                }
                a = j - 1;
                while(a >= 0){
                  if(floor[a][k] != 0){
                    sumOfNeighbours += floor[a][k];
                    neighboutCount++;
                    break;
                  }
                  a--;
                }
                a = j + 1;
                while(a < r){
                  if(floor[a][k] != 0){
                    sumOfNeighbours += floor[a][k];
                    neighboutCount++;
                    break;
                  }
                  a++;
                }

                if(neighboutCount == 0)
                  continue;
                if(floor[j][k] * neighboutCount >= sumOfNeighbours)
                  continue;
                else toEliminate.add(new int[]{j, k});
              }
            }
            if(toEliminate.size() == 0)
              break;
            for(int[] s : toEliminate){
              floor[s[0]][s[1]] = 0;
            }
          }
          System.out.println(out);
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