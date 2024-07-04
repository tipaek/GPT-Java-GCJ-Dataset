import java.io.FileInputStream;
import java.util.*;

public class Solution {

    static class Info implements Comparable<Info> {
        public int count;
        public char chr;

        Info(char chr, int count) {
            this.count = count;
            this.chr = chr;
        }

        @Override
        public String toString() {
            return chr + "-" + count;
        }

        @Override
        public int compareTo(Info o) {
            return o.count - this.count;
        }
    }

    private static String process(Scanner in) {
        Set<Character> uniqueChars = new HashSet<>();
        int U = in.nextInt();
        int[] digitCount = new int[255];

        for (int i = 0; i < 10000; i++) {
            char[] qDigitsNotUsed = in.next().toCharArray();
            char[] rDigits = in.next().toCharArray();

            if (rDigits.length == U) {
                digitCount[rDigits[0]]++;
            }

            for (char rDigit : rDigits) {
                uniqueChars.add(rDigit);
            }
        }

        List<Info> infoList = new ArrayList<>();
        char[] result = new char[10];

        for (char i = 'A'; i <= 'Z'; i++) {
            if (digitCount[i] > 0) {
                infoList.add(new Info(i, digitCount[i]));
            }
        }

        Collections.sort(infoList);

        for (int i = 0; i < infoList.size(); i++) {
            result[i + 1] = infoList.get(i).chr;
            uniqueChars.remove(infoList.get(i).chr);
        }

        result[0] = uniqueChars.iterator().next();

        return new String(result);
    }

    private static String processOrig(Scanner in) {
        int U = in.nextInt();
        int[] maxCharPos = new int[255];
        Arrays.fill(maxCharPos, 99);

        for (int i = 0; i < 10000; i++) {
            char[] qDigits = in.next().toCharArray();
            char[] rDigits = in.next().toCharArray();

            if (qDigits.length == rDigits.length) {
                int digit = qDigits[0] - '0';
                if (digit < maxCharPos[rDigits[0]]) {
                    maxCharPos[rDigits[0]] = digit;
                }
            }

            for (char rDigit : rDigits) {
                if (maxCharPos[rDigit] > 10) {
                    maxCharPos[rDigit] = 10;
                }
            }
        }

        char[] result = new char[10];

        for (char i = 'A'; i <= 'Z'; i++) {
            if (maxCharPos[i] <= 10) {
                if (maxCharPos[i] == 10) {
                    result[0] = i;
                } else {
                    result[maxCharPos[i]] = i;
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in.available() > 0 ? System.in :
                new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));

        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.format("Case #%d: %s\n", i, process(in));
        }
    }
}