import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            String s = sc.next();
            int open = 0;
            ArrayList<Character> sd = new ArrayList<>();
            int k = 0;
            for (int j = 0; j < s.length(); j++) {
                int temp = Integer.parseInt(String.valueOf(s.charAt(j)));
                if (temp == open) {
                    sd.add(s.charAt(j));
                    k++;
                } else if (temp > open) {
                    while (temp > open) {

                        sd.add('(');
                        open++;
                        k++;
                    }

                    sd.add(s.charAt(j));

                } else {
                    while (temp < open) {
                        sd.add(')');
                        open--;

                    }
                    sd.add(s.charAt(j));

                }

            }

            while (open > 0) {
                sd.add(')');
                open--;
            }
            String ans = "";
            for (int m = 0; m < sd.size(); m++) {
                ans += sd.get(m);
            }
            System.out.println("Case #" + i + ": " + ans);
        }

    }
}