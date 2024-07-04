import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] line = in.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        for (int x = 0; x++ < T;) {
            if (B == 10)
                solve10();
            else if (B == 20)
                try {
                    solve20();
                } catch (Exception e) {
                    break;
                }
            else
                solve100();
        }
    }

    static void solve10() throws Exception {
        String bits = "";
        for (int i = 1; i <= 10; i++) {
            bits += getBit(i);
        }
        System.out.println(bits);
        if (in.readLine().equals("N")) {
            throw new Exception("Drats!");
        }
    }

    static void solve20() throws Exception {
        String left = "" + getBit(10) + getBit(9) + getBit(8) + getBit(7) + getBit(6);
        String right = "" + getBit(11) + getBit(12) + getBit(13) + getBit(14) + getBit(15);
        left += getBit(5) + getBit(4) + getBit(3) + getBit(2) + getBit(1);
        right += getBit(16) + getBit(17) + getBit(18) + getBit(19) + getBit(20);
        String bits = "" + getBit(1) + getBit(2) + getBit(3) + getBit(4) + getBit(5) + getBit(6) + getBit(7) + getBit(8) + getBit(9) + getBit(10);
        for (int i = 0; i < 10; i++) {
            String b = "" + bits.charAt(9 - i);
            bits += left.charAt(i) == right.charAt(i) ? b : flip(b);
        }
        System.out.println(bits);
        if (in.readLine().equals("N")) {
            throw new Exception("Drats!");
        }
    }

    static void solve100() throws Exception {
        String[][] groups = new String[10][4];
        int[][] pair = new int[10][2];

        for (int i = 0; i < 50; i += 5) {
            String[] B = groups[i/5];
            B[0] = "" + getBit(i+1) + getBit(i+2) + getBit(i+3) + getBit(i+4) + getBit(i+5);
            B[1] = flip(B[0]);
            B[2] = "" + getBit(100-i) + getBit(99-i) + getBit(98-i) + getBit(97-i) + getBit(96-i);
            B[3] = flip(B[2]);
            int[] P = pair[i/5];
            P[1] = 1;
            for (int b1 = 0; b1 < 5; b1++) {
                for (int b2 = b1+1; b2 < 5; b2++) {
                    String a = B[0].charAt(b1) + "" + B[0].charAt(b2);
                    String b = B[1].charAt(b1) + "" + B[1].charAt(b2);
                    String c = B[2].charAt(b1) + "" + B[2].charAt(b2);
                    String d = B[3].charAt(b1) + "" + B[3].charAt(b2);
                    if (a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d)) continue;
                    P[0] = b1;
                    P[1] = b2;
                }
            }
        }

        String ABCDE = "";
        String abcde = "";
        for (int i = 0; i < 5; i++) {
            int offset = 5 * i + 1;
            char a = getBit(pair[i][0] + offset);
            char b = getBit(pair[i][1] + offset);
            int k = find(groups[i], pair[i][0], pair[i][1], a, b);
            ABCDE += groups[i][k];
            abcde += groups[i][(k+2)%4];
        }
        String FGHIJ = "";
        String fghij = "";
        for (int i = 5; i < 10; i++) {
            int offset = 5 * i + 1;
            char a = getBit(pair[i][0] + offset);
            char b = getBit(pair[i][1] + offset);
            int k = find(groups[i], pair[i][0], pair[i][1], a, b);
            FGHIJ += groups[i][k];
            fghij += groups[i][(k+2)%4];
        }

        groups[0][0] = ABCDE;
        groups[0][1] = flip(ABCDE);
        groups[0][2] = abcde;
        groups[0][3] = flip(abcde);
        groups[1][0] = FGHIJ;
        groups[1][1] = flip(FGHIJ);
        groups[1][2] = fghij;
        groups[1][3] = flip(fghij);
        for (int i = 0; i < 2; i++) {
            String[] B = groups[i];
            int[] P = pair[i];
            for (int b1 = 0; b1 < 25; b1++) {
                for (int b2 = b1+1; b2 < 25; b2++) {
                    String a = B[0].charAt(b1) + "" + B[0].charAt(b2);
                    String b = B[1].charAt(b1) + "" + B[1].charAt(b2);
                    String c = B[2].charAt(b1) + "" + B[2].charAt(b2);
                    String d = B[3].charAt(b1) + "" + B[3].charAt(b2);
                    if (a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d)) continue;
                    P[0] = b1;
                    P[1] = b2;
                }
            }
        }
        String ABCDEFGHIJ = "";
        String abcdefghij = "";
        for (int i = 0; i < 2; i++) {
            int offset = 25 * i + 1;
            char a = getBit(pair[i][0] + offset);
            char b = getBit(pair[i][1] + offset);
            int k = find(groups[i], pair[i][0], pair[i][1], a, b);
            ABCDEFGHIJ += groups[i][k];
            abcdefghij += groups[i][(k+2)%4];
        }
        String bits = ABCDEFGHIJ + reverse(abcdefghij);
        System.out.println(bits);
        if (in.readLine().equals("N")) {
            throw new Exception("Drats!");
        }
    }

    static char getBit(int i) throws Exception {
        System.out.println(i);
        return in.readLine().charAt(0);
    }

    static String flip(String str) {
        String x = "";
        for (char c : str.toCharArray()) {
            x += c == '1' ? 0 : 1;
        }
        return x;
    }

    static String reverse(String str) {
        String x = "";
        for (char c : str.toCharArray()) {
            x = c + x;
        }
        return x;
    }

    static int find(String[] bits, int i, int j, char a, char b) {
        for (int k = 0; k < 4; k++) {
            if (bits[k].charAt(i) == a && bits[k].charAt(j) == b) {
                return k;
            }
        }
        return 0;
    }
}