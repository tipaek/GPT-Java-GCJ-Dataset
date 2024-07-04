import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner has functions to read ints, longs, strings, chars, etc.
        String line = in.nextLine();
        String[] inputParam = line.split("\\s+");
        int T = Integer.parseInt(inputParam[0]);
        int B = Integer.parseInt(inputParam[1]);
        in.nextLine();
        for (int i = 1; i <= T; ++i) {
            boolean success = interact(in, B);

            if (!success) {
                break;
            }
        }
    }

    public static boolean interact(final Scanner in, int B) {
        List<Boolean> startList = new ArrayList<>(B/2);
        List<Boolean> endList = new ArrayList<>(B/2);

        int remainingBit = B;
        int bitpos = 0;
        boolean reverse = false;
        int cycle = 10;
        for (int i=0; i<150; i++) {
            String line = in.nextLine();
            if ("N".equals(line)) {
                return false;
            }

            final boolean bitVal;
            if ("1".equals(line)) {
                bitVal = true;
            } else {
                bitVal = false;
            }

            if (!reverse) {
                System.out.println(bitpos + 1);
                System.out.flush();

                startList.add(bitVal);
            } else {
                System.out.println(B - bitpos);
                System.out.flush();

                endList.add(bitVal);
                bitpos++;
            }

            remainingBit--;
            reverse = !reverse;

            if (remainingBit <=0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder(B);
        for (int i=0; i<startList.size(); i++) {
            if (startList.get(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        for (int i=endList.size(); i>0; i--) {
            if (endList.get(i-1)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        System.out.println(sb.toString());
        System.out.flush();

        String response = in.nextLine();
        if ("Y".equals(response)) {
            return true;
        }

        return false;
    }
}