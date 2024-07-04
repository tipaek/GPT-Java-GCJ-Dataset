import java.util.*;
import java.io.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int i = 1; i <= T; i++){
        solve(in, i);
        }
    }
    
    static void solve(Scanner in, int T){
        int x = in.nextInt();
        int y = in.nextInt();
        if(x == 0 && y == 0) System.out.println("Case #" + T + ": 0");
        int counter = 0;
        String m = in.next();
        int length = m.length();
        boolean solvable = false;
        while(!solvable && counter < length){
            String a = m.substring(counter, counter + 1);
            counter += 1;
            switch(a) {
            case "N": y++; break;
            case "E": x++; break;
            case "S": y--; break;
            case "W": x--; break;
            }
            if(Math.abs(x) + Math.abs(y) <= counter) {
            	solvable = true;
            }
        }
        if(solvable) {
        	System.out.println("Case #" + T + ": " + counter);
        } else {
        	System.out.println("Case #" + T + ": IMPOSSIBLE");
        }
    }
}