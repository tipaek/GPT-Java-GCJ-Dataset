
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            int u = in.nextInt();
//            int upper = (int)Math.pow(10, u);

            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
//                int q = in.nextInt();
                String qstr = in.next();
                int qlen = qstr.length();
                int firstDigit = Integer.parseInt(qstr.substring(0, 1));
                String rstr = in.next();
//                char[] r = in.next().toCharArray();
                char c = rstr.charAt(0);
//                System.out.printf("\nq=%s, r=%s", qstr, rstr);
                if (rstr.length() == qlen) {
                    if (map.containsKey(c)) {
                        int val = map.get(c);
                        if (val == -1 || firstDigit < val) {
                            map.put(c, firstDigit);
                        }
                    } else {
                        map.put(c, firstDigit);
                    }
                }
                for (int j=0; j<rstr.length(); j++) {
                    char cj = rstr.charAt(j);
                    map.putIfAbsent(cj, -1);
                }
            }

            char[] result = new char[10];
            Set<Integer> missingDigits = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                missingDigits.add(i);
            }
            Character missingLetter = null;


            for (Character c : map.keySet()) {
                int val = map.get(c);
                System.out.printf("\nc=%s, val=%d", c, val);

                if (val != -1) {
                    if (result[val] != 0) {
                        System.out.printf("\nError. c=%s, val=%d", c, val);
                    } else {
                        result[val] = c;
                        missingDigits.remove(val);
                    }
                } else {
                    missingLetter = c;
                }

            }

            if (missingDigits.size() > 1) {
                System.out.println("Error missingDigits size > 1. " + missingDigits.toString());
            }


            for (int i = 0; i < 10; i++) {
                if (result[i] == 0) {
                    result[i] = missingLetter.charValue();
                }
            }

            System.out.println("Case #" + ti + ": " + new String(result));



        }
    }
}
