import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nbCases = Integer.parseInt(bufferedReader.readLine());

        ArrayList<String> patterns = new ArrayList<>();

        for(int i = 0; i < nbCases; i++) {
            String result = "*";
            int nbPatterns = Integer.parseInt(bufferedReader.readLine());
            int sizeMax = 0;
            int patternSizeMax = 0;
            boolean isPossible = true;
            String pattern = bufferedReader.readLine();
            patterns.add(pattern.substring(1, pattern.length()));
            for(int iPatterns = 1; iPatterns < nbPatterns; iPatterns++) {
                pattern = bufferedReader.readLine();
                patterns.add(pattern.substring(1, pattern.length()));
                if(pattern.length() > sizeMax) {
                    isPossible = pattern.contains(patterns.get(patternSizeMax));
                    sizeMax = pattern.length();
                    patternSizeMax = iPatterns;
                }
            }

            if(isPossible) result = patterns.get(patternSizeMax);

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
