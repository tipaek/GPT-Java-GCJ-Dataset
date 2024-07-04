import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int b = sc.nextInt();

        while (t > 0) {
            String result = "";
            if (b == 10) {
                result = readBits(sc, 10);
            } else {
                String s1 = readBits(sc, 10);
                String s2 = readBits(sc, 10, -5);
                String s3 = readBits(sc, 5, -20);
                String s4 = readBits(sc, 5, -10);

                result = reconstructString(s1, s2, s3, s4);
            }

            System.out.println(result);
            System.out.flush();
            String feedback = sc.next();

            if (feedback.equals("N")) {
                break;
            }
            t--;
        }
    }

    private static String readBits(Scanner sc, int count) {
        return readBits(sc, count, 0);
    }

    private static String readBits(Scanner sc, int count, int offset) {
        StringBuilder bits = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            System.out.println(i + offset);
            System.out.flush();
            bits.append(sc.next());
        }
        return bits.toString();
    }

    private static String reconstructString(String s1, String s2, String s3, String s4) {
        String s1a = s1.substring(0, 5);
        String s1b = s1.substring(5);
        String s2a = s2.substring(0, 5);
        String s2b = s2.substring(5);

        String s1ar = reverse(s1a);
        String s1br = reverse(s1b);
        String s2r = reverse(s2);

        String s1ac = complement(s1a);
        String s1bc = complement(s1b);
        String s2c = complement(s2);

        String s1arc = complement(s1ar);
        String s1brc = complement(s1br);
        String s2rc = complement(s2r);

        if (s1b.equals(s2a)) {
            if (s1a.equals(s3)) return s3 + s2 + s4;
            if (s1ar.equals(s4)) return s3 + s2r + s4;
            if (s1ac.equals(s3)) return s3 + s2c + s4;
            if (s1arc.equals(s4)) return s3 + s2rc + s4;
        }

        if (s1br.equals(s2b)) {
            if (s1ar.equals(s4)) return s3 + s2 + s4;
            if (s1a.equals(s3)) return s3 + s2r + s4;
            if (s1arc.equals(s4)) return s3 + s2c + s4;
            if (s1ac.equals(s3)) return s3 + s2rc + s4;
        }

        if (s1bc.equals(s2a)) {
            if (s1ac.equals(s3)) return s3 + s2 + s4;
            if (s1arc.equals(s4)) return s3 + s2r + s4;
            if (s1a.equals(s3)) return s3 + s2c + s4;
            if (s1ar.equals(s4)) return s3 + s2rc + s4;
        }

        if (s1brc.equals(s2b)) {
            if (s1arc.equals(s4)) return s3 + s2 + s4;
            if (s1ac.equals(s3)) return s3 + s2r + s4;
            if (s1ar.equals(s4)) return s3 + s2c + s4;
            if (s1a.equals(s3)) return s3 + s2rc + s4;
        }

        return "";
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String complement(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            result.append(c == '1' ? '0' : '1');
        }
        return result.toString();
    }
}