import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main1(String[] args) {
        String data = "2\n" +
                "5\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*S\n" +
                "2\n" +
                "*XZ\n" +
                "*XYZ";
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

    private static String result(int N, List<String> patterns) {
        // part 1 - sort length, contains
        patterns.sort(Comparator.comparingInt(String::length));

        String longest = patterns.get(N-1).substring(1);
        for(int i = N - 2; i >= 0; i--) {
            String pattern = patterns.get(i).substring(1);
            if (!longest.contains(pattern)) {
                return "*";
            }
        }
        return longest;
    }
}
