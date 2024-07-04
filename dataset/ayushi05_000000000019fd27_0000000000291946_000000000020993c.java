import java.io.*;
import java.util.*;

/**
 * Created by Ayushi on 04 Apr 2020.
 * Problem:
 * Round:
 */

public class Vestigium {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int m = 1; m <= t; m++){
            int n = Integer.parseInt(br.readLine());
            int a, r, c;
            a = r = c = 0;
            int in;
            boolean posr;
            boolean[] posc = new boolean[n];
            ArrayList<Integer> cur = new ArrayList<>();
            HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
            for (int k = 0; k < n; k++) {
                hmap.put(k, new ArrayList<>());
                posc[k] = false;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                cur.clear();
                posr = false;
                for (int j = 0; j < n; j++) {
                    in = Integer.parseInt(st.nextToken());
                    if (i == j) a += in;

                    if (cur.contains(in) && !posr) {
                        posr = true;
                        r++;
                    }
                    else {
                        cur.add(in);
                    }
                    if (hmap.get(j).contains(in) && !posc[j]) {
                        posc[j] = true;
                        c++;
                    }
                    else {
                        hmap.get(j).add(in);
                    }
                }
            }
            System.out.println("Case #" + m + ": " + a + " " + r + " " + c);
        }
        br.close();
    }
}
