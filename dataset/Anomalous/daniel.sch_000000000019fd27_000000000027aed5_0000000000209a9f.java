import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberInstances = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberInstances; ++i) {
                StringBuilder sb = new StringBuilder();
                char[] input = br.readLine().toCharArray();
                int currentDepth = 0;
                for (char c : input) {
                    int requiredDepth = Character.getNumericValue(c);
                    while (requiredDepth > currentDepth) {
                        sb.append("(");
                        currentDepth++;
                    }
                    while (requiredDepth < currentDepth) {
                        sb.append(")");
                        currentDepth--;
                    }
                    sb.append(c);
                }
                while (currentDepth > 0) {
                    sb.append(")");
                    currentDepth--;
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}