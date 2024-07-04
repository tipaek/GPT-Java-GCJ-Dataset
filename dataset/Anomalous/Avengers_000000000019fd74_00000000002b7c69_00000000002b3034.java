import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            String result = "*";
            Set<String> extensions = new HashSet<>();
            boolean hasCommonExtension = false;

            int numberOfFiles = Integer.parseInt(reader.readLine());
            for (int j = 0; j < numberOfFiles; j++) {
                String fileName = reader.readLine();
                hasCommonExtension = hasCommonExtension || hasCommonExtension(fileName, extensions);
                extensions.add(fileName.substring(1));
            }

            if (hasCommonExtension) {
                result = findLongestString(extensions);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String findLongestString(Set<String> strings) {
        String longestString = "";
        for (String s : strings) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }
        return longestString;
    }

    public static boolean hasCommonExtension(String fileName, Set<String> extensions) {
        return extensions.stream().allMatch(fileName::endsWith);
    }
}