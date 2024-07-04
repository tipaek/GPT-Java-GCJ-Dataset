import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int limit = Integer.parseInt(in.nextLine());
        for(int i = 0; i < limit; i ++){
            StringTokenizer limits = new StringTokenizer(in.nextLine());
            int x = Integer.parseInt(limits.nextToken());
            int y = Integer.parseInt(limits.nextToken());
            String path = limits.nextToken();
            char[] p = path.toCharArray();
            
            boolean possible = false;
            for(int j = 0; j < p.length; j ++){
                switch(p[j]){
                    case 'N':
                        y ++;
                        break;
                    case 'S':
                        y --;
                        break;
                    case 'E':
                        x ++;
                        break;
                    case 'W':
                        x --;
                        break;
                }
                if(Math.abs(x) + Math.abs(y) <= j+1){
                    System.out.println("Case #" + (i+1) + ": " + (j+1));
                    j = p.length + 1;
                    possible = true;
                }
            }
            if(!possible) System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
        }
    }
}