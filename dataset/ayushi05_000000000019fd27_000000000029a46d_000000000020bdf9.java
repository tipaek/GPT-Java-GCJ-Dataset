import java.io.*;
import java.util.*;

/**
 * Created by Ayushi on 04 Apr 2020.
 * Problem:
 * Round:
 */

class Solution {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 1; z <= t; z++) {
            int n = Integer.parseInt(br.readLine());
            int[] s = new int[n];
            int[] e = new int[n];
            //boolean answer = true;
            //HashMap<Integer, String> hmap = new HashMap<>();
            ArrayList<Integer> c = new ArrayList<>();
            ArrayList<Integer> j = new ArrayList<>();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                boolean p1, p2;
                p1 = p2 = true;
                st = new StringTokenizer(br.readLine(), " ");
                s[i] = Integer.parseInt(st.nextToken());
                e[i] = Integer.parseInt(st.nextToken());
                for (int k : c) {
                    if ((s[i] >= s[k] && s[i] < e[k]) || (e[i] > s[k] && e[i] <= e[k])) {
                        p1 = false;
                        break;
                    }
                }
                if (p1) {
                    c.add(i);
                    ans.append("C");
                }
                else {
                    for (int k : j) {
                        if ((s[i] >= s[k] && s[i] < e[k]) || (e[i] > s[k] && e[i] <= e[k])) {
                            p2 = false;
                            break;
                        }
                    }
                    if (p2) {
                        j.add(i);
                        ans.append("J");
                    }
                    else {
                        ans.delete(0, ans.length());
                        ans.append("IMPOSSIBLE");
                        //answer = false;
                        //System.out.println("Case #" + z + ": IMPOSSIBLE");
                        //continue main;
                    }
                }
            }
            System.out.println("Case #" + z + ": " + ans);
        }
        br.close();
    }
}
