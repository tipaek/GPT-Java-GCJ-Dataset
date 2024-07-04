import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] s = new int[r][c];
            for(int j=0; j<r; j++) {
                for(int k=0; k<c; k++) {
                    s[j][k] = in.nextInt();
                }
            }
            testCase(r, c, s);
        }
    }
    private static void testCase(int r, int c, int[][] s) {
        long sum = 0;
        while(true) {
            boolean isElliminated = false;
            int[][] snapshot = copy(s);
            for(int y=0; y<r; y++) {
                for(int x=0; x<c; x++) {
                    sum += snapshot[y][x];
                    if(isToBeEliminated(r, c, snapshot, y, x)) {
                        isElliminated = true;
                        s[y][x] = 0;
                    }
                }
            }
            if(!isElliminated) {
                break;
            }
        }
        System.out.println(sum);
    }
    private static boolean isToBeEliminated(int r, int c, int[][] s, int y, int x) {
        int sk = s[y][x];
        if(sk<=0) {
            return false;
        }
        int sum = 0;
        int count = 0;
    
        for(int i=y-1; i>=0; i--) {
            int so = s[i][x];
            if(so>0) {
                sum += so;
                count++;
                break;
            }
        }
        for(int i=y+1; i<r; i++) {
            int so = s[i][x];
            if(so>0) {
                sum += so;
                count++;
                break;
            }
        }
        for(int i=x-1; i>=0; i--) {
            int so = s[y][i];
            if(so>0) {
                sum += so;
                count++;
                break;
            }
        }
        for(int i=x+1; i<c; i++) {
            int so = s[y][i];
            if(so>0) {
                sum += so;
                count++;
                break;
            }
        }
        
        if(count<=0) {
            return false;
        }
        return sk < (int)Math.ceil((double)sum/(double)count);
    }
    private static int[][] copy(int[][] s) {
        int[][] result = new int[s.length][];
        for(int i=0; i<s.length; i++) {
            result[i] = s[i].clone();
        }
        return result;
    }
}