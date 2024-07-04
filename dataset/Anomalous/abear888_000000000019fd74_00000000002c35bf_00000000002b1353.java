import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int cases = 1; cases <= t; cases++) {
            int n = sc.nextInt();
            boolean even = (n % 2 == 0);
            String bin = Integer.toBinaryString(n);
            boolean left = true;
            ArrayList<Integer> r = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();
            int extra = 0;
            
            while (n > 0) {
                if (n == 1) {
                    r.add(1);
                    c.add(1);
                    n = 0;
                } else if (bin.charAt(0) == '1') {
                    int remaining = n - (int) Math.pow(2, bin.length() - 1);
                    if (remaining < bin.length() - 1) {
                        r.add(bin.length());
                        c.add(left ? 1 : bin.length());
                        extra = n - (int) Math.pow(2, bin.length() - 1);
                        n = (int) Math.pow(2, bin.length() - 1) - 1;
                        int oldLength = bin.length();
                        bin = Integer.toBinaryString(n);
                        while (bin.length() < oldLength - 1) {
                            bin = "0" + bin;
                        }
                    } else {
                        for (int i = 0; i < bin.length(); i++) {
                            r.add(bin.length());
                            c.add(left ? i + 1 : bin.length() - i);
                        }
                        left = !left;
                        n -= Math.pow(2, bin.length() - 1);
                        bin = bin.substring(1);
                    }
                } else {
                    r.add(bin.length());
                    c.add(left ? 1 : bin.length());
                    n -= 1;
                    int oldLength = bin.length();
                    bin = Integer.toBinaryString(n);
                    while (bin.length() < oldLength - 1) {
                        bin = "0" + bin;
                    }
                }
            }
            
            System.out.println("Case #" + cases + ":");
            for (int i = r.size() - 1; i >= 0; i--) {
                System.out.println(r.get(i) + " " + c.get(i));
            }
            int lastRow = r.get(0);
            for (int i = 1; i <= extra; i++) {
                System.out.println(lastRow + i + " " + 1);
            }
        }
        sc.close();
    }
}