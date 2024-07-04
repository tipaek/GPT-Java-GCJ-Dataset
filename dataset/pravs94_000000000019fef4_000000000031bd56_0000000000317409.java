import java.util.*;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int j = 0; j<tests; j++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String directions = sc.nextLine();
            char[] arrDir = directions.toCharArray();
            int len = arrDir.length;
            String output = "IMPOSSIBLE";
            for(int i = 1; i<len; i++) {
                int moves = i;
                if(arrDir[i]=='N') {
                    y++;
                } else if(arrDir[i]=='S') {
                    y--;
                } else if(arrDir[i]=='E') {
                    x++;
                } else if(arrDir[i]=='W') {
                    x--;
                }
                int dist = getManDist(x, y);
                if(dist<=moves){
                    output = String.valueOf(moves);
                    break;
                }
            }
            System.out.printf("Case #%d: %s", j+1, output);
            System.out.println();
        }
    }
    
    public static int getManDist(int x, int y) {
        return Math.abs(x-0) + Math.abs(y-0);
    }
}