import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> reversedSuffixes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String input = reader.readLine().replace("*", "");
                reversedSuffixes.add(new StringBuilder(input).reverse().toString());
            }

            String longestSuffix = reversedSuffixes.get(0);
            boolean isValid = true;

            for (int i = 1; i < reversedSuffixes.size(); i++) {
                String currentSuffix = reversedSuffixes.get(i);

                if (!longestSuffix.startsWith(currentSuffix)) {
                    if (currentSuffix.startsWith(longestSuffix)) {
                        longestSuffix = currentSuffix;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + t + ": " + new StringBuilder(longestSuffix).reverse());
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}