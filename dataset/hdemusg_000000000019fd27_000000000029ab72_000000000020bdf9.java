import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    static Scanner input;
    public static void solve(int x) {
        int n = input.nextInt();
        String result = "";
        HashMap<Integer, Integer> c = new HashMap<>();
        HashMap<Integer, Integer> j = new HashMap<>();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int a = 0; a < n; a++) {
            starts[a] = input.nextInt();
            ends[a] = input.nextInt();
        }
        for (int b = 0; b < n; b++) {
            boolean cFit = true;
            for (int d = starts[b]; d < ends[b]; d++) {
                if (c.containsKey(d)) {
                    cFit = false;
                    break;
                }
            }
            if (cFit) {
                for (int e = starts[b]; e < ends[b]; e++) {
                    c.put(e, 0);
                }
                result += "C";
            } else {
                boolean jFit = true;
                for (int f = starts[b]; f < ends[b]; f++) {
                    if (j.containsKey(f)) {
                        jFit = false;
                        break;
                    }
                }
                if (jFit) {
                    for (int g = starts[b]; g < ends[b]; g++) {
                        j.put(g, 0);
                    }
                    result += "J";
                }
            }
        }
        if (result.length() != n) {
            //System.out.println(result);
            result = "IMPOSSIBLE";
        } 
        System.out.println("Case #" + x + ": " + result);
    }
    
    public static void main(String args[]) {
      input = new Scanner(System.in);
      int t = input.nextInt();
      for (int i = 0; i < t; i++) {
          solve(i + 1);
      }
    }
}