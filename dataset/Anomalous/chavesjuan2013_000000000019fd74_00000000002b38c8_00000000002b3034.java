import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int iter = 0; iter < T; iter++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> reversedSuffixes = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                String cleanedString = br.readLine().replace("*", "");
                reversedSuffixes.add(new StringBuilder(cleanedString).reverse().toString());
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
                System.out.println("Case #" + (iter + 1) + ": " + new StringBuilder(longestSuffix).reverse());
            } else {
                System.out.println("Case #" + (iter + 1) + ": NO");
            }
        }
    }
}