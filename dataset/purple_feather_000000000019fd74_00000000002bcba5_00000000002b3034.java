import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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

            String strings[] = new String[n];
            for (int i = 0; i < n; i++) {
                String s = buff.readLine().substring(1);
                strings[i] = s;
            }
            Arrays.sort(strings, new java.util.Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();// comparision
                }
            });

            String last = strings[n - 1];
            result = last;
            for (int i = n - 2; i >= 0; i--) {
                if (!last.contains(strings[i])) {
                    result = "*";
                }
            }
            System.out.println("Case #" + tnum + ":" + " " + result);

            tnum++;
        }

    }
}
