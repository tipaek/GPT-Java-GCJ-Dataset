import java.util.*;
import java.io.*;

public class Solution {
    public static int trace (int[][] arr) {
        int ans = 0;
        for (int x = 0; x < arr.length; x++) {
            ans += arr[x][x];
        }
        return ans;
    }
    public static int repeatRow (int[][] arr) {
        int ans = 0;
        HashMap<Integer, Boolean> h;
        for (int x = 0; x < arr.length; x++) {
            h = new HashMap<Integer, Boolean>();
            for (int i = 0; i < arr[x].length; i++) {
                if (h.containsKey(arr[x][i])) {
                    ans++;
                    break;
                }
                else {
                    h.put(arr[x][i],true);
                }
            }
        }
        return ans;
    }
    public static int repeatCol (int[][] arr) {
        int ans = 0;
        HashMap<Integer, Boolean> h;
        for (int x = 0; x < arr.length; x++) {
            h = new HashMap<Integer, Boolean>();
            for (int i = 0; i < arr[x].length; i++) {
                if (h.containsKey(arr[i][x])) {
                    ans++;
                    break;
                }
                else {
                    h.put(arr[i][x],true);
                }
            }
        }
        return ans;
    }
    public static void main (String[] args) {
            Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int tests = Integer.parseInt(s.nextLine());
            for (int q = 1; q <= tests; q++) {
                int rows = Integer.parseInt(s.nextLine());
                int[][] arr = new int[rows][rows];
                String[] sp;
                for (int x = 0; x < rows; x++) {
                    sp = s.nextLine().split(" ");
                    for (int i = 0; i < rows; i++) {
                        arr[x][i] = Integer.parseInt(sp[i]);
                    }
                }
                int tr = trace(arr);
                int r = repeatRow(arr);
                int c = repeatCol(arr);
                System.out.println("Case #" + q + ": " + tr + " " + r + " " + c);
            }
    }
}