import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static boolean areEqual(StringBuffer a, StringBuffer b) {
        for (int i = 0; i < 5; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static StringBuffer complement(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            result.append(1 - str.charAt(i) + '0');
        }
        return result;
    }

    public static StringBuffer reverse(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        return result;
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
                    int n = br.readLine().charAt(0) - '0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                br.readLine();
            } else if (B == 20) {
                StringBuffer a = new StringBuffer();
                StringBuffer b = new StringBuffer();
                StringBuffer c = new StringBuffer();
                StringBuffer d = new StringBuffer();
                StringBuffer e = new StringBuffer();
                StringBuffer f = new StringBuffer();

                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    a.append(n);
                }
                for (int i = 16; i <= 20; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    b.append(n);
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    c.append(n);
                }
                for (int i = 11; i <= 15; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    d.append(n);
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    e.append(n);
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    f.append(n);
                }

                StringBuffer c1 = complement(c);
                StringBuffer c2 = reverse(d);
                StringBuffer c3 = complement(c2);
                StringBuffer a1 = complement(a);
                StringBuffer a2 = reverse(b);
                StringBuffer a3 = complement(a2);

                StringBuffer answer = new StringBuffer();

                if (areEqual(c, f)) {
                    answer.append(c).append(d);
                } else if (areEqual(c1, f)) {
                    answer.append(c1).append(complement(d));
                } else if (areEqual(c2, f)) {
                    answer.append(c2).append(reverse(c));
                } else {
                    answer.append(c3).append(complement(reverse(c)));
                }

                if (areEqual(a, e)) {
                    System.out.println(a.toString() + answer.toString() + b.toString());
                } else if (areEqual(a1, e)) {
                    System.out.println(a1.toString() + answer.toString() + complement(b).toString());
                } else if (areEqual(a2, e)) {
                    System.out.println(a2.toString() + answer.toString() + reverse(a).toString());
                } else {
                    System.out.println(a3.toString() + answer.toString() + complement(reverse(a)).toString());
                }

                br.readLine();
            }
        }
    }
}