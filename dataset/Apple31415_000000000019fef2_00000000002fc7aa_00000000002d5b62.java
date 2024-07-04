import java.io.*;
import java.util.*;
public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        int numcases = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numcases; i++ ){
             st = new StringTokenizer(br.readLine());
            System.out.printf("Case #%d: %s%n", i + 1, gen(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        br.close();
    }
    
    public static String gen(int x0, int y0) {
        
        int x = Math.abs(x0);
        int y = Math.abs(y0);
        
        String ret = "";
        while (x != 0 || y != 0) {
            //System.out.println(ret);
            if (x % 2 == 0 && y % 2 == 0 || x % 2 == 1 && y % 2 == 1)
                return "IMPOSSIBLE";
            if (x % 2 == 1) {
                y /= 2;
                if (y % 2 == 1) {
                    if (x % 4 == 1) {
                        ret = ret.concat("W");
                        x /= 2;
                    } else {
                        ret = ret.concat("E");
                        x = (x + 1) / 2;
                    }
                } else {
                    if (x % 4 == 1 && (x != 1 || y != 0)) {
                        ret = ret.concat("E");
                        x = (x + 1) / 2;
                    } else {
                        ret = ret.concat("W");
                        x = x / 2;
                    }
                }
            } else {
                x /= 2;
                if (x % 2 == 1) {
                    if (y % 4 == 1) {
                        ret = ret.concat("S");
                        y /= 2;
                    } else {
                        ret = ret.concat("N");
                        y = (y + 1) / 2;
                    }
                } else {
                    if (y % 4 == 1  && (y != 1 || x != 0)) {
                        ret = ret.concat("N");
                        y = (y + 1) / 2;
                    } else {
                        ret = ret.concat("S");
                        y = y / 2;
                    }
                }
            }
        }
        
        if (x0 > 0) ret = flipX(ret);
        if (y0 > 0) ret = flipY(ret);
        
        return ret;
    }
    
    public static String flipY (String input) {
        for (int i = 0; i < input.length(); i++)
            switch (input.charAt(i)) {
                case 'S': input = input.substring(0, i).concat("N").concat(input.substring(i + 1)); break;
                case 'N': input = input.substring(0, i).concat("S").concat(input.substring(i + 1)); break;
            }
        return input;
    }
    
    public static String flipX (String input) {
        for (int i = 0; i < input.length(); i++)
            switch (input.charAt(i)) {
                case 'W': input = input.substring(0, i).concat("E").concat(input.substring(i + 1)); break;
                case 'E': input = input.substring(0, i).concat("W").concat(input.substring(i + 1)); break;
            }
        return input;
    }
}
