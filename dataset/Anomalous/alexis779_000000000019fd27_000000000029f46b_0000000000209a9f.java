import java.io.*;

public class Solution {
    private static final char ZERO = '0';

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //InputStream inputStream = new FileInputStream(new File("NestingDepth"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine().trim());
        for (int t = 1; t <= T; t++) {
            String S = reader.readLine();
            String nestedString = getNestedString(S);
            writer.write("Case #" + t + ": " + nestedString);
            writer.newLine();
        }
        writer.flush();
    }

    private static String getNestedString(String S) {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char c : S.toCharArray()) {
            int digit = c - ZERO;
            while (currentLevel < digit) {
                result.append('(');
                currentLevel++;
            }
            while (currentLevel > digit) {
                result.append(')');
                currentLevel--;
            }
            result.append(c);
        }

        while (currentLevel > 0) {
            result.append(')');
            currentLevel--;
        }

        return result.toString();
    }
}