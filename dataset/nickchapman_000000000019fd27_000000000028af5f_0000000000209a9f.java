import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(reader.readLine());
        String[] output = new String[t];

        //bracketify each
        for (int i = 0; i < t; i++) {
            output[i] = assemble(splitIntoParts(reader.readLine()));
        }

        //output final answers
        for (int i = 1; i <= output.length; i++) {
            System.out.println("Case #" + i + ": " + output[i-1]);
        }
    }

    public static String assemble(String[] parts) {
        String output = "";

        for (int i = 0; i < parts.length; i++) {
            output += parts[i];
        }

        return output;
    }

    public static String[] splitIntoParts(String input) {

        String[] out = input.split("(?<=(.))(?!\\1)");

        for (int i=0;i<out.length;i++) {
            out[i] = addBrackets(out[i]);
        }

        return out;
    }

    public static String addBrackets(String input) {
        if (input.charAt(0) == '1') {
            return "(" + input + ")";
        } else {
            return input;
        }
  }
}