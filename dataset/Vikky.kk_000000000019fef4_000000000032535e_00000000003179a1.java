import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            for (int i = 0; i < 10000; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(token.nextToken());
                String eachStr = token.nextToken();
                for (int j = 0; j < eachStr.length(); j++) {
                    list.add(eachStr.charAt(j) + "");
                }
                if (M < 10) {
                    map[M].add(eachStr);
                }
            }
            Iterator<String> it = map[1].iterator();
            String temp = (String) it.next();
            ans[1] = temp;
            map[2].remove(temp);
            map[3].remove(temp);
            map[4].remove(temp);
            map[5].remove(temp);
            map[6].remove(temp);
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);
            list.remove(temp);
            // ------------------
            it = map[2].iterator();
            temp = (String) it.next();
            ans[2] = temp;
            map[3].remove(temp);
            map[4].remove(temp);
            map[5].remove(temp);
            map[6].remove(temp);
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);
            list.remove(temp);
            // ---------------
            it = map[3].iterator();
            temp = (String) it.next();
            ans[3] = temp;
            map[4].remove(temp);
            map[5].remove(temp);
            map[6].remove(temp);
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);
            list.remove(temp);
            // -----------
            it = map[4].iterator();
            temp = (String) it.next();
            ans[4] = temp;
            map[5].remove(temp);
            map[6].remove(temp);
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);
            list.remove(temp);
            // -------------
            it = map[5].iterator();
            temp = (String) it.next();
            ans[5] = temp;
            map[6].remove(temp);
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);
            list.remove(temp);
            // --------------
            it = map[6].iterator();
            temp = (String) it.next();
            ans[6] = temp;
            map[7].remove(temp);
            map[8].remove(temp);
            map[9].remove(temp);

            list.remove(temp);
            // --------------
            it = map[7].iterator();
            temp = (String) it.next();
            ans[7] = temp;
            map[8].remove(temp);
            map[9].remove(temp);

            list.remove(temp);
            // -----------------------
            it = map[8].iterator();
            temp = (String) it.next();
            ans[8] = temp;
            map[9].remove(temp);
            list.remove(temp);
            // -----------
            it = map[9].iterator();
            temp = (String) it.next();
            ans[9] = temp;
            list.remove(temp);
            // --------------
            it = list.iterator();
            temp = (String) it.next();
            ans[0] = temp;
            sb.append("Case #" + t_i + ": " + ans[0] + ans[1] + ans[2] + ans[3] + ans[4] + ans[5] + ans[6] + ans[7]
                    + ans[8] + ans[9]).append("\n");

            // sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}