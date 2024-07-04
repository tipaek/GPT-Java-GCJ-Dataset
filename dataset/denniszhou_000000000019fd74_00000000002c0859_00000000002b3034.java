import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            List<String> words = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                words.add(in.nextLine());
            }
            System.out.println("Case #" + i + ": " + getResult(words));
        }
    }

    private static String getResult(List<String> words) {
        int[] pointer = new int[words.size()];
        StringBuilder sb = new StringBuilder();
        while (true) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).charAt(pointer[i]) != '*')
                    set.add(words.get(i).charAt(pointer[i]));
            }
            if (set.size() == 0) break;
            if (set.size() > 1) return "*";
            for (int i = 0; i < words.size(); i++) {
                if (set.contains(words.get(i).charAt(pointer[i])))
                    pointer[i]++;
            }
            for (char c : set) {
                sb.append(c);
            }
        }

        int[] pointer2 = new int[words.size()];
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            pointer2[i] = words.get(i).length() - 1;
        }
        while (true) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < words.size(); i++) {
                if (pointer2[i] > pointer[i] && words.get(i).charAt(pointer2[i]) != '*')
                    set.add(words.get(i).charAt(pointer2[i]));
            }
            if (set.size() == 0) break;
            if (set.size() > 1) return "*";
            for (int i = 0; i < words.size(); i++) {
                if (set.contains(words.get(i).charAt(pointer2[i])))
                    pointer2[i]--;
            }
            for (char c : set) {
                sb2.append(c);
            }
        }
        return sb.toString() + sb2.reverse().toString();
    }
}