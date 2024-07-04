import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import jdk.nashorn.api.tree.Tree;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t_i = 1; t_i <= test; ++t_i) {
            StringBuffer sans = new StringBuffer("");
            int U = Integer.parseInt(br.readLine());
            HashSet<String> list = new HashSet<String>();
            HashSet<String> map[] = new HashSet[10];
            for (int i = 0; i < 10; i++) {
                map[i] = new HashSet<String>();
            }
            String ans[] = new String[10];
            HashMap<String, Integer> finaa = new HashMap<String, Integer>();
            TreeMap<Integer, String> tfinaa = new TreeMap<Integer, String>();
            for (int i = 0; i < 10000; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(token.nextToken());
                String eachStr = token.nextToken();
                for (int j = 0; j < eachStr.length(); j++) {
                    String strm = "" + eachStr.charAt(j);
                    int val = 1;
                    if (finaa.containsKey(strm)) {
                        val += finaa.get(strm);
                    }
                    finaa.put(strm, val);
                }
            }
            Iterator<String> it = finaa.keySet().iterator();
            while (it.hasNext()) {
                String ttt = it.next();
                tfinaa.put(finaa.get(ttt), ttt);
            }
            Iterator<Integer> itr = tfinaa.keySet().iterator();
            int ind = 0;
            while (itr.hasNext()) {
                int xxxxxxx = itr.next();
                ans[ind++] = tfinaa.get(xxxxxxx);
            }

            sb.append("Case #" + t_i + ": " + ans[0] + ans[1] + ans[2] + ans[3] + ans[4] + ans[5] + ans[6] + ans[7]
                    + ans[8] + ans[9]).append("\n");

            // sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}