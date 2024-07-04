import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            int x = in.nextInt();
            int y = in.nextInt();

            ArrayList<Integer> addX = add(Math.abs(x));
            ArrayList<Integer> subX = sub(Math.abs(x));

            ArrayList<Integer> addY = add(Math.abs(y));
            ArrayList<Integer> subY = sub(Math.abs(y));

            sb.append("Case #");
            sb.append(i);
            sb.append(": ");

            if (consecutive(addX, addY)) {
                sb.append(printer(addX, addY, x, y));
            }

            else if (consecutive(addX, subY)) {
                sb.append(printer(addX, subY, x, y));
            }

            else if (consecutive(subX, addY)) {
                sb.append(printer(subX, addY, x, y));
            }

            else if (consecutive(subX, subY)) {
                sb.append(printer(subX, subY, x, y));
            }

            else {
                sb.append("IMPOSSIBLE");
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    public static String printer(ArrayList<Integer> p1, ArrayList<Integer> p2, int x, int y) {
        ArrayList<Integer> together = new ArrayList<>();
        together.addAll(p1);
        together.addAll(p2);

        Collections.sort(together, new AbsComparator());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < together.size(); i++) {
            int cur = together.get(i);

            if (p1.contains(cur)) {
                // now we need to take the sign and select which val

                if (cur > 0 && x > 0) {
                    sb.append('E');
                }

                else if (cur < 0 && x > 0) {
                    sb.append('W');
                }

                else if (cur > 0 && x < 0) {
                    sb.append('W');
                }

                else {
                    sb.append('E');
                }
            }

            else {
                if (cur > 0 && y > 0) {
                    sb.append('N');
                }

                else if (cur < 0 && y > 0) {
                    sb.append('S');
                }

                else if (cur > 0 && y < 0) {
                    sb.append('S');
                }

                else {
                    sb.append('N');
                }
            }
        }

        return sb.toString();
    }

    public static boolean consecutive(ArrayList<Integer> p1, ArrayList<Integer> p2) {
        ArrayList<Integer> together = new ArrayList<>();
        together.addAll(p1);
        together.addAll(p2);

        Collections.sort(together, new AbsComparator());

        for (int i = 0; i < together.size(); i++) {
            if (Math.abs(together.get(i)) != i+1) return false;
        }

        return true;
    }

    public static ArrayList<Integer> add(int n) {
        String s = Integer.toBinaryString(n);

        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                digits.add(s.length()-i);
            }
        }

        return digits;
    }

    public static ArrayList<Integer> sub(int n) {

        int next = (int) Math.pow(2, Math.ceil(Math.log(n)/Math.log(2)));

        if (isPowerOfTwo(n)) {
            next = (int) Math.pow(2, Math.ceil(Math.log(n+1)/Math.log(2)));
        }

        int diff = next - n;

        String s1 = Integer.toBinaryString(diff);

        String s2 = Integer.toBinaryString(next);

        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                digits.add(-(s1.length()-i));
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '1') {
                digits.add(s2.length()-i);
            }
        }

        return digits;
    }

    public static boolean isPowerOfTwo(int n)
    {
        if(n==0)
            return false;

        return (Math.ceil(log2(n)) == Math.floor(log2(n)));
    }

    public static int log2(int x)
    {
        return (int) (Math.log(x) / Math.log(2));
    }

    static class AbsComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Math.abs(i1) - Math.abs(i2);
        }
    }

}
