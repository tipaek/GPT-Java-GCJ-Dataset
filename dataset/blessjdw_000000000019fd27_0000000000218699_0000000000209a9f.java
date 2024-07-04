import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            char[] word = in.next().toCharArray();
            char lastC = ' ';
            List<Character> arr = new ArrayList<>();
            int pCount = 0;
            for (int i = 0; i < word.length; i++) {
                if (lastC != word[i]) {
                    for (int j = 0; j < pCount; j++) {
                        arr.add(')');
                    }
                    pCount = word[i] - '0';
                    for (int j = 0; j < pCount; j++) {
                        arr.add('(');
                    }
                    lastC = word[i];
                }
                arr.add(word[i]);
            }
            pCount = arr.get(arr.size()-1) - '0';
            for (int j = 0; j < pCount; j++) {
                arr.add(')');
            }
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}