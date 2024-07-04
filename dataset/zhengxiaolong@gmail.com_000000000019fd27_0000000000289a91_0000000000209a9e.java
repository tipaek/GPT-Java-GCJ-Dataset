import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            handleTestCase(in, tc, B);
        }

        in.close();
    }

    private static void handleTestCase(Scanner in, int tc, int B) {
        Set<Integer> tbd = new HashSet<>();
        for (int i = 0; i < B; ++i) {
            tbd.add(i);
        }

        char[] arr = new char[B];
        Arrays.fill(arr, '#');
        String bits = new String(arr);

        int i, j, r=-1, c=-1;
        char q;
        String verdict;

        for(i = 1, j = 0; j < B / 2; i+=2)
        {
            if(i > 10 && i % 10 == 1)
            {
                if(c != -1) {
                    System.out.println(c + 1);
                    System.out.flush();
                    q = in.next().charAt(0);
                    if(bits.charAt(c) != q)
                        bits = complement(bits);
                } else {
                    System.out.println(1);
                    System.out.flush();
                    q = in.next().charAt(0);
                }
                if(r != -1) {
                    System.out.println(r + 1);
                    System.out.flush();
                    q = in.next().charAt(0);
                    if(bits.charAt(r) != q)
                        bits = reverse(bits);
                } else {
                    System.out.println(1);
                    System.out.flush();
                    q = in.next().charAt(0);
                }
            } else {
                System.out.println(j + 1);
                System.out.flush();
                bits = setCharAt(bits, j, in.next().charAt(0));
                System.out.println(B - j);
                System.out.flush();
                bits = setCharAt(bits, B - j - 1, in.next().charAt(0));
                if(bits.charAt(j) == bits.charAt(B - j - 1)) {
                    c = j;
                } else if(bits.charAt(j) != bits.charAt(B - j - 1)) {
                    r = j;
                }
                ++j;
            }
        }

        System.out.println(bits);
        System.out.flush();

        verdict = in.next();
        if (verdict.equals("N")) {
            System.exit(0);
        }
    }

    static String complement(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
            } else if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            }
        }
        return sb.toString();
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    static String setCharAt(String s, int i, char ch) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, ch);
        return sb.toString();
    }
}