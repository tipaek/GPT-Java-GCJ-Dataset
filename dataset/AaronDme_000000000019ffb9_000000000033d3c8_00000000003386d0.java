import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for(int i = 1; i <= t; i++){
            System.out.print("Case #" + i + ": ");
            int n = getInt();
            int[][] positions = new int[n][2];
            HashMap<String, Integer> amounts = new HashMap<>();
            int max = 1;
            for(int j = 0; j < n; j++){
              positions[j][0] = getInt();
              positions[j][1] = getInt();
            }
            for(int j = 0; j < n; j++){
              boolean didAdd = false;
              for(int k = j + 1; k < n; k++){
                int x = positions[j][0] - positions[k][0];
                int y = positions[j][1] - positions[k][1];
                if(y < 0){
                  x *= -1;
                  y *= -1;
                }
                if(y == 0){
                  x = 1;
                }
                else if(x == 0){
                  y = 1;
                }
                else{
                  int a = gcd(x, y);
                  x /= a;
                  y /= a;
                }
                if(amounts.containsKey("" + x + " " + y)){
                  Integer w = amounts.get("" + x + " " + y);
                  if(didAdd)
                    w++;
                  else{
                    w += 2;
                    didAdd = true;
                  }
                  if(max < w)
                    max = w;
                    amounts.put("" + x + " " + y, w);
                }
                else{
                  amounts.put("" + x + " " + y, 2);
                  if(max < 2)
                    max = 2;
                  didAdd = true;
                }
              }
            }
            
            System.out.println(Math.min(max + 2, n));
           
        }
    }
    public static int gcd(int a, int b){
      if(a < 0)
        a *= -1;
      if(b < 0)
        b *= -1;
      if(a == 0)
        return b;
      if(b == 0)
        return a;
      if(b > a)
        return gcd(b, a);
      return gcd(b, a % b);
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