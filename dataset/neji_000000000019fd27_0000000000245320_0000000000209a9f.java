import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.next();
                int depth = 0;
                StringBuilder result1 = new StringBuilder();
                StringBuffer str = new StringBuffer();
                for (int i = 0; i < input.length(); i++) {

                    int a = Integer.parseInt(input.charAt(i) + "");
                    while (depth != a) {
                        if (depth < a) {
                            str.append("(");
                            depth++;
                        } else if (depth > a) {
                            str.append(")");
                            depth--;
                        }
                    }
                    str.append(input.charAt(i));
                }
                while (depth != 0) {
                    str.append(")");
                    depth--;
                }
                System.out.println("Case #" + testNumber + ": " + str);
            }
        } catch (Exception e) {

        }
    }
}