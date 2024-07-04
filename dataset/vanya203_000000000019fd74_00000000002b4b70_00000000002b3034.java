import java.util.*;
import java.io.*;

public class Solution {

    public static boolean[][] visited = null;

    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(cs.nextLine());

        for (int i = 1; i <= T; ++i) {
            int stringCount = Integer.valueOf(cs.nextLine());
            String[] vals = new String[stringCount];

            for (int j = 0; j < stringCount; j++){
                vals[j] = cs.nextLine();
            }

            String res = conzat(vals);
            System.out.printf("Case #%d: %s\n", i, res);
        }
    }

    public static String conzat(String[] vals) {
        Arrays.sort(vals, (a,b) -> {
            return b.length() - a.length();
        });

        String main = vals[0];
        boolean match = true;
        for (int i = 1; match && i < vals.length; i++){
            match = main.endsWith(vals[i].replace("*",""));
        }
        main = main.replace("*","");

        return match ? main : "*";
    }

}
