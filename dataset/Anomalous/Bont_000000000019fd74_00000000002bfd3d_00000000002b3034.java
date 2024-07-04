import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            String[] arr = new String[N];
            String longestString = "";
            String result = "";

            for (int i = 0; i < N; i++) {
                arr[i] = in.next();
                if (arr[i].length() > longestString.length()) {
                    longestString = arr[i];
                }
            }

            for (int i = 0; i < N; i++) {
                String trimmedInput = arr[i].substring(1);
                String trimmedLongest = longestString.substring(1);

                if (trimmedLongest.contains(trimmedInput)) {
                    if (arr[i].charAt(arr[i].length() - 1) != longestString.charAt(longestString.length() - 1)) {
                        result = "*";
                        break;
                    }
                } else {
                    result = "*";
                    break;
                }
            }

            if (!result.equals("*")) {
                result = longestString.substring(1);
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}