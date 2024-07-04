

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int U = in.nextInt();
            in.nextLine();
            String[] str = new String[10000];
            HashMap<Character, Long> allChar = new HashMap<>();
            HashSet<Character> firstChar = new HashSet<>();
            StringBuilder result = new StringBuilder();
            char first = 'A';
            for (int i = 0; i < 10000; i++) {
                str[i] = in.nextLine().split(" ")[1];
                for (int j = 0; j < str[i].length(); j++) {
                    char tmp = str[i].charAt(j);
                    if (allChar.containsKey(tmp)) {
                        allChar.put(tmp, allChar.get(tmp) + 1);
                    } else {
                        allChar.put(tmp, (long) 1);
                    }
                }
                firstChar.add(str[i].charAt(0));
            }
            for (char ch : allChar.keySet()) {
                if (!firstChar.contains(ch)) {
                    first = ch;
                }
            }
            result.append(first);
            for (int i = 1; i <= 9; i++) {
                long maxValue = -1;
                char maxChar = 'A';
                for (char ch : allChar.keySet()) {
                    if (ch != first && maxValue < allChar.get(ch)) {
                        maxValue = allChar.get(ch);
                        maxChar = ch;
                    }
                }
                result.append(maxChar);
                allChar.remove(maxChar);
            }
            out.write(String.format("Case #%d: %s\n", t + 1, result.toString()));
        }

        out.close();
        in.close();
    }

}
