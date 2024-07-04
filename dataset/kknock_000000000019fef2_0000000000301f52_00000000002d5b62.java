import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static BigInteger X, Y;
    public static boolean did = false;
    public static String ans = "IMPOSSIBLE";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []res = new String[cases];
        for (int i = 1; i <= cases; i++) {
            X = new BigInteger(String.valueOf(in.nextInt()));
            Y = new BigInteger(String.valueOf(in.nextInt()));

            String sol = getSolution(new BigInteger("0"), new BigInteger("0"), "", 0);
            res[i-1] = "Case #"+i+": "+ans;
            did = false;
            ans = "IMPOSSIBLE";
        }
        in.close();
        for (String s: res) {
            System.out.println(s);
        }
    }

    private static String getSolution(BigInteger x, BigInteger y, String s, int move) {
        if(x.compareTo(X)==0 && y.compareTo(Y)==0) {
            if(did && s.length() < ans.length()) {
                ans = s;
            } else if(!did) {
                ans = s;
            }
            did = true;
        } else if(x.compareTo(X.multiply(X)) > 0 || y.compareTo(Y.multiply(Y)) > 0) {
            // nothingness
        } else if(x.compareTo(X.multiply(X).negate()) < 0 || y.compareTo(Y.multiply(Y).negate()) < 0) {
            // nothingness
        } else {
            BigInteger b = new BigInteger("2");
            BigInteger moveVal = b.pow(move);
            getSolution(x.add(moveVal), y, s+"E", move+1);
            getSolution(x.subtract(moveVal), y, s+"W", move+1);
            getSolution(x, y.add(moveVal), s+"N", move+1);
            getSolution(x, y.subtract(moveVal), s+"S", move+1);
        }
        return s;
    }
}
