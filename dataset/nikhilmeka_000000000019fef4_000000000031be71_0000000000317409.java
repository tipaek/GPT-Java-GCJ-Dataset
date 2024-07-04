import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        long n = Long.parseLong(s.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] x = s.nextLine().split(" ");
            long[] coord = new long[] {Long.parseLong(x[0]), Long.parseLong(x[1])};
            String path = x[2];
            if(coord[0] == 0 && coord[1] == 0){
                System.out.println("Case #" + i + ": " + 0);
                continue;
            }
            long moveNum = -1;
            for (int j = 1; j <= path.length(); j++) {
                coord = findNewCoord(path.charAt(j-1), coord);
                long sum = findSum(coord);
                if(sum <= j){
                    moveNum = j;
                    break;
                }
            }
            if(moveNum == -1){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + i + ": " + moveNum);
            }
        }
        s.close();
    }
    public static long[] findNewCoord(char d, long[] coord){
        if(d == 'S'){
            coord[1] -= 1;
            return coord;
        }
        else if(d == 'N'){
            coord[1] += 1;
            return coord;
        }
        else if(d == 'E'){
            coord[0] += 1;
            return coord;
        }
        coord[0] -= 1;
        return coord;
    }
    public static long findSum(long[] coord){
        return Math.abs(coord[0]) + Math.abs(coord[1]);
    }
}
