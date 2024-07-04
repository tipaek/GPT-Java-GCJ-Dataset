import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main1(String[] args) {
        String data = "4\n" +
                "6\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*\n"+
                "*S\n" +
                "2\n" +
                "*ABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHI\n" +
                "*I\n"+
                "2\n" +
                "*XYZ\n" +
                "*XZ\n"+
                "2\n" +
                "*ABC\n" +
                "*K\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int N = Integer.valueOf(in.nextLine());
                List<String> patterns = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    String pattern = in.nextLine();
                    patterns.add(pattern);
                }
                System.out.println("Case #" + i + ": " + result(N, patterns));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.valueOf(in.nextLine());
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String pattern = in.nextLine();
                patterns.add(pattern);
            }
            System.out.println("Case #" + i + ": " + result(N, patterns));
        }
    }

    private static String result2(int N, List<String> patterns) {
        // part 1 - sort length, contains
        // part 1 fix - have to match from the right
        patterns.sort(Comparator.comparingInt(String::length));

        StringBuilder longest = new StringBuilder(patterns.get(N - 1).substring(1));
        /* if (longest.length() == 0) { // At least one character of P is an uppercase English letter
            return "A";
        } */
        for(int i = N - 2; i >= 0; i--) {
            String pattern = patterns.get(i).substring(1);
            //System.out.println(pattern);
            if (!longest.toString().contains(pattern)) {

            }
        }
        return longest.toString();
    }

    private static String result(int N, List<String> patterns) {
        // part 1 - sort length, contains
        // part 1 fix - have to match from the right
        patterns.sort(Comparator.comparingInt(String::length));

        //String regex = patterns.get(N - 1).replace("*",".*");
        String longest = patterns.get(N - 1).substring(1);
        //System.out.println(longest);
        for(int i = N - 2; i >= 0; i--) {
            String pattern = patterns.get(i).replace("*",".*");
            //System.out.println(pattern);
            if (!Pattern.matches(pattern, longest)) {
                return "*";
            }
        }
        return longest;
    }
}