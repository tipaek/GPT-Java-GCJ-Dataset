import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author daksh
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        int tnum = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buff.readLine());
            String result = "";

            ArrayList<String> suf = new ArrayList<>();
            ArrayList<String> pre = new ArrayList<>();
            ArrayList<String> center = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = buff.readLine().replace("*", " ");
                String array[] = s.split("\\s+");
                if (!s.startsWith(" ")) {
                    pre.add(array[0]);
                }
                for (int j = 1; j < array.length - 1; j++) {
                    center.add(array[j]);
                }
                if (s.endsWith(" ")) {
                    center.add(array[array.length - 1]);
                } else {
                    suf.add(array[array.length - 1]);
                }
            }
            Collections.sort(suf, new java.util.Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();// comparision
                }
            });

            Collections.sort(pre, new java.util.Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();// comparision
                }
            });

            boolean flag = true;

            int plen = pre.size();
            String las = "";
            if (pre.size() > 0) {
                las = pre.get(plen - 1);
                for (int i = plen - 2; i >= 0; i--) {
                    if (!las.startsWith(pre.get(i))) {
                        flag = false;
                    }
                }
            }

            String last = "";
            int slen = suf.size();
            if (slen > 0) {
                last = suf.get(slen - 1);
                for (int i = slen - 2; i >= 0; i--) {
                    if (!last.endsWith(suf.get(i))) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                StringBuilder sb = new StringBuilder();
                sb.append(las);
                for (int i = 0; i < center.size(); i++) {
                    sb.append(center.get(i));
                }
                sb.append(last);
                System.out.println("Case #" + tnum + ":" + " " + sb.toString());

            } else {
                System.out.println("Case #" + tnum + ":" + " " + "*");

            }

            tnum++;
        }

    }
}
