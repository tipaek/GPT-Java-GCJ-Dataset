import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = in.nextInt();
            in.nextLine();


            for (int t = 1; t <= T; ++t) {
                String ligne = in.nextLine();

                StringBuilder builder = new StringBuilder();

                int current = 0;
                for (int i = 0; i < ligne.length(); i++) {
                    int number = ligne.charAt(i) - '0';
                    String chars = "";
                    if (current > number) chars = repeat(")", current - number);
                    if (current < number) chars = repeat("(", number - current);
                    builder.append(chars);
                    builder.append(number);
                    current = number;
                }


                if (current > 0) builder.append(repeat(")", current));

                System.out.println("Case #" + t + ": " + builder.toString());
            }
        }
    }

    private static String repeat(String character, int repeat) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            builder.append(character);
        }

        return builder.toString();
    }


}
