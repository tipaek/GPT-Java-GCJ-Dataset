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
            //System.out.println(starts[b] + " " + ends[b]);
            boolean cFit = true;
            for (int s : c.keySet()) {
                //System.out.println("C: " + s + " " + c.get(s));
                if ((starts[b] >= s && starts[b] < c.get(s)) || (ends[b] >= s && ends[b] < c.get(s))) {
                    cFit = false;
                    break;
                }
            }
            if (cFit) {
                result += "C";
                c.put(starts[b], ends[b]);
            } else {
                boolean jFit = true;
                for (Integer sj : j.keySet()) {
                    //System.out.println("J: " + sj + " " + j.get(sj));
                    if ((starts[b] >= sj && starts[b] < j.get(sj)) || (ends[b] >= sj && ends[b] < j.get(sj))) {
                        jFit = false;
                        break;
                    }
                }
                if (jFit) {
                    result += "J";
                    j.put(starts[b], ends[b]);
                }
            }
            //System.out.println("---------");
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