import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

 class Solution {

    

    public static void main(String[] args) throws IOException {

        Scanner ob = new Scanner(System.in);
        int T = ob.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = ob.nextInt();
            int[] arr = new int[n];
            int[] brr = new int[n];
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            Map<Integer, Integer> l = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = ob.nextInt();

                brr[i] = ob.nextInt();
            }
            String s = "";
            int i = 0;
            while (i < n) {
                boolean b = true;
                boolean c = true;
                for (Integer k : m.keySet()) {
                     if (brr[i] <= k || arr[i] >= m.get(k)) {
                        continue;
                    } else {
                        b = false;
                        break;
                    }

                }
                if (b == true) {
                    s = s + "C";
                    m.put(arr[i], brr[i]);
                    i++;
                    continue;
                }

                for (Integer e : l.keySet()) {
                    if (brr[i] <= e || arr[i] >= l.get(e)) {
                        continue;
                    } else {
                        c = false;
                        break;
                    }
                }
                if (c == true) {
                    s = s + "J";
                    l.put(arr[i], brr[i]);
                    i++;
                    continue;
                }
                else {
                    s = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + t + ": " + s);
           // System.out.println();
        }
    }
}
