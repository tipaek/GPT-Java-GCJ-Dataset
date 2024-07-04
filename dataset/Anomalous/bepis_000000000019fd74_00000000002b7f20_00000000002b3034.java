import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] elements = new String[n];
            String longestString = "";

            for (int j = 0; j < n; j++) {
                elements[j] = br.readLine().substring(1);
                if (elements[j].length() > longestString.length()) {
                    longestString = elements[j];
                }
            }

            boolean isMatch = true;
            for (String element : elements) {
                if (!longestString.contains(element)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                sb.append("Case #").append(i).append(": ").append(longestString).append("\n");
            } else {
                sb.append("Case #").append(i).append(": *\n");
            }
        }
        System.out.print(sb);
    }
}