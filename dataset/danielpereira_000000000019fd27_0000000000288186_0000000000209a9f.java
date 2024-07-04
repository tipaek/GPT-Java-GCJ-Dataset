import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = reader.readLine().split("");
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();
            for (int x = 0; x < line.length; x++) {
                int number = Integer.parseInt(line[x]);
                for (int z = openBrackets; z < number; z++) {
                    result.append("(");
                    openBrackets++;
                }
                while (openBrackets > number) {
                    result.append(")");
                    openBrackets--;
                }
                result.append(number);
            }
            for (int z = 0; z < openBrackets; z++) {
                result.append(")");
            }
            System.out.println(String.format("Case #%d: %s", (i + 1), result.toString()));
        }
    }

}