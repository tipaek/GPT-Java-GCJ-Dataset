import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int b = sc.nextInt();

        while (t > 0) {
            String[] segments = new String[4];
            int x = 1;

            for (int i = 0; i < 4; i++) {
                segments[i] = "";
                int limit = (i == 0) ? 10 : (i == 1) ? 20 : (i == 2) ? 25 : 30;
                int offset = (i == 0) ? 0 : (i == 1) ? -5 : (i == 2) ? -20 : -10;

                while (x <= limit) {
                    System.out.println(x + offset);
                    System.out.flush();
                    segments[i] += sc.next();
                    x++;
                }
            }

            String s1 = segments[0];
            String s2 = segments[1];
            String s3 = segments[2];
            String s4 = segments[3];

            String s1a = s1.substring(0, 5);
            String s1b = s1.substring(5, 10);
            String s2a = s2.substring(0, 5);
            String s2b = s2.substring(5, 10);

            String s1ar = reverse(s1a);
            String s1br = reverse(s1b);
            String s2r = reverse(s2);

            String s1ac = complement(s1a);
            String s1bc = complement(s1b);
            String s2c = complement(s2);

            String s1arc = complement(s1ar);
            String s1brc = complement(s1br);
            String s2rc = complement(s2r);

            if (tryMatch(sc, s1b, s2a, s1a, s3, s2, s4, s2r, s2c, s2rc) || 
                tryMatch(sc, s1br, s2b, s1ar, s4, s2, s4, s2r, s2c, s2rc) || 
                tryMatch(sc, s1bc, s2a, s1ac, s3, s2, s4, s2r, s2c, s2rc) || 
                tryMatch(sc, s1brc, s2b, s1arc, s4, s2, s4, s2r, s2c, s2rc)) {
                t--;
            } else {
                break;
            }
        }
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String complement(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '1' ? '0' : '1');
        }
        return sb.toString();
    }

    private static boolean tryMatch(Scanner sc, String s1, String s2, String s3a, String s3b, String s2a, String s4, String s2r, String s2c, String s2rc) {
        if (s1.equals(s2)) {
            if (matchAndCheck(sc, s3a, s3b, s2a, s4) || matchAndCheck(sc, s3a, s3b, s2r, s4) ||
                matchAndCheck(sc, s3a, s3b, s2c, s4) || matchAndCheck(sc, s3a, s3b, s2rc, s4)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchAndCheck(Scanner sc, String s3a, String s3b, String s2, String s4) {
        if (s3a.equals(s3b)) {
            String result = s3a + s2 + s4;
            System.out.println(result);
            System.out.flush();
            String ans = sc.next();
            return ans.equals("N");
        }
        return false;
    }
}