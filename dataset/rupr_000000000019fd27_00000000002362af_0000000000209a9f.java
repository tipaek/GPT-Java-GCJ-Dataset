import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            String input = scanner.nextLine();
            results.add(nest(input));
        }

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        for (int i = 0; i < results.size(); i++) {
            pw.println(String.format("Case #%d: %s", (i + 1), results.get(i)));
            pw.flush();
        }

        pw.close();
        scanner.close();
    }

    private static String nest(String input) {
        int depth = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            if(digit < depth) {
                while (depth != digit) {
                    output.append(')');
                    depth--;
                }
            } else {
                while(depth != digit) {
                    output.append('(');
                    depth++;
                }
            }
            output.append(digit);
        }

        while(depth > 0) {
            output.append(')');
            depth--;
        }

        return output.toString();
    }

}
