import java.util.*;

public class Solution {

    public static void solve(int N, String[] patterns, int testNum) {
        List<String> list = new ArrayList<>();
        
        for (String pattern : patterns) {
            StringBuilder sb = new StringBuilder();
            for (char ch : pattern.toCharArray()) {
                if (ch != '*') {
                    sb.append(ch);
                }
            }
            list.add(sb.toString());
        }
        
        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        });

        String longestPattern = list.get(list.size() - 1);
        boolean isValid = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (!isSubSequence(list.get(i), longestPattern)) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.println("Case #" + testNum + ": " + longestPattern);
        } else {
            System.out.println("Case #" + testNum + ": *");
        }
    }

    private static boolean isSubSequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str2.length() && j < str1.length(); i++) {
            if (str1.charAt(j) == str2.charAt(i)) {
                j++;
            }
        }
        return j == str1.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // consume newline
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.nextLine();
            }
            solve(N, patterns, t);
        }
        scanner.close();
    }
}