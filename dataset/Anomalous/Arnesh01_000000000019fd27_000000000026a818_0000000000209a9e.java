import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

    public static StringBuffer reverse(StringBuffer str) {
        return new StringBuffer(str).reverse();
    }

    public static StringBuffer complement(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            result.append(1 - (str.charAt(i) - '0'));
        }
        return result;
    }

    public static boolean isEqual(StringBuffer a, StringBuffer b) {
        return a.toString().equals(b.toString());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    sb.append(br.readLine().charAt(0) - '0');
                }
                System.out.println(sb);
                System.out.flush();
                br.readLine(); // Read the result feedback
            } else if (B == 20) {
                StringBuffer a = readBits(br, 1, 5);
                StringBuffer b = readBits(br, 16, 20);
                StringBuffer c = readBits(br, 6, 10);
                StringBuffer d = readBits(br, 11, 15);
                StringBuffer e = readBits(br, 1, 5);
                StringBuffer f = readBits(br, 6, 10);

                StringBuffer a1 = complement(a);
                StringBuffer a2 = reverse(b);
                StringBuffer a3 = complement(a2);
                StringBuffer c1 = complement(c);
                StringBuffer c2 = reverse(d);
                StringBuffer c3 = complement(c2);

                StringBuffer ans = determineAnswer(c, d, e, f, c1, c2, c3);

                printFinalAnswer(a, b, e, ans, a1, a2, a3);
                br.readLine(); // Read the result feedback
            }
        }
    }

    private static StringBuffer readBits(BufferedReader br, int start, int end) throws Exception {
        StringBuffer result = new StringBuffer();
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            System.out.flush();
            result.append(br.readLine().charAt(0) - '0');
        }
        return result;
    }

    private static StringBuffer determineAnswer(StringBuffer c, StringBuffer d, StringBuffer e, StringBuffer f,
                                                StringBuffer c1, StringBuffer c2, StringBuffer c3) {
        if (isEqual(c, f)) {
            return new StringBuffer(c).append(d);
        } else if (isEqual(c1, f)) {
            return new StringBuffer(c1).append(complement(d));
        } else if (isEqual(c2, f)) {
            return new StringBuffer(c2).append(reverse(c));
        } else {
            return new StringBuffer(c3).append(complement(reverse(c)));
        }
    }

    private static void printFinalAnswer(StringBuffer a, StringBuffer b, StringBuffer e, StringBuffer ans,
                                         StringBuffer a1, StringBuffer a2, StringBuffer a3) {
        if (isEqual(a, e)) {
            System.out.println(a + "" + ans + "" + b);
        } else if (isEqual(a1, e)) {
            System.out.println(a1 + "" + ans + "" + complement(b));
        } else if (isEqual(a2, e)) {
            System.out.println(a2 + "" + ans + "" + reverse(a));
        } else {
            System.out.println(a3 + "" + ans + "" + complement(reverse(a)));
        }
        System.out.flush();
    }
}