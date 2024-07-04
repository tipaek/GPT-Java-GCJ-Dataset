import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            if (solve(in, b) != 0)
                return;
        }
    }

    private static int solve(Scanner in, int b) {
        StringPair sp = new StringPair();
        readNext(in, b, sp, 0, 5);
        if (b == sp.length()) {
            return checkResult(in, sp);
        }

        int shift = 5;
        int sameCycle = 3;
        while (b != sp.length()) {
            StringPair complPair = complementStringPair(sp);
            StringPair reversedPair = reverseStringPair(sp);
            StringPair bothPair = reverseStringPair(complPair);

            String newStartStr = "";
            for (int read = 1; read <= 4; read++) {
                String str = readNextByte(in, read);
                newStartStr += str;
            }
            boolean checkCompl = complPair.start.startsWith(newStartStr);
            boolean checkRev = reversedPair.start.startsWith(newStartStr);
            boolean checkBoth = bothPair.start.startsWith(newStartStr);
            int matchNumber = 0;
            if (checkCompl)
                matchNumber++;
            if (checkRev)
                matchNumber++;
            if (checkBoth)
                matchNumber++;
            if (matchNumber >= 1) {
                StringPair newSp = new StringPair();
                newSp.start = newStartStr;
                readNext(in, b, newSp, 0, 5);
                sp = newSp;
                shift = 5;
                sameCycle--;
                if (sameCycle == 0) {
                    return checkResult(in, sp);
                }
                continue;
            }
            if (matchNumber != 0) {
                if (checkRev)
                    sp = reversedPair;
                if (checkCompl)
                    sp = complPair;
                if (checkBoth)
                    sp = bothPair;
            }

            int needToRead = b - sp.length();
            if (needToRead < 6) {
                readNextStart(in, sp, shift, needToRead);
            } else {
                readNext(in, b, sp, shift, 3);
                shift += 3;
            }
        }

        return checkResult(in, sp);
    }

    private static int checkResult(Scanner in, StringPair sp) {
        System.out.println(sp.toString());
        String res = in.next();
        return "Y".equals(res) ? 0 : 1;
    }

    private static void readNext(Scanner in, int b, StringPair sp, int startShift, int number) {
        readNextStart(in, sp, startShift, number);
        for (int j = b - startShift; j >= b - startShift - number; j--) {
            String byteStr = readNextByte(in, j);
            sp.addToEnd(byteStr);
        }
    }

    private static void readNextStart(Scanner in, StringPair sp, int startShift, int number) {
        for (int j = startShift + 1; j <= startShift + number; j++) {
            String byteStr = readNextByte(in, j);
            sp.addToStart(byteStr);
        }
    }

    private static String readNextByte(Scanner in, int position) {
        System.out.println(position);
        return in.next();
    }

    private static String complementByteString(String inputString) {
        String newString = "";
        for (int i = 0; i < inputString.length(); i++) {
            char resultChar;
            char c = inputString.charAt(i);
            switch (c) {
                case '0':
                    resultChar = '1';
                    break;
                case '1':
                    resultChar = '0';
                    break;
                default:
                    resultChar = c;
                    break;
            }
            newString += resultChar;
        }
        return newString;
    }

    private static StringPair complementStringPair(StringPair sp) {
        StringPair result = new StringPair();
        result.start = complementByteString(sp.start);
        result.end = complementByteString(sp.end);
        return result;
    }

    private static StringPair reverseStringPair(StringPair sp) {
        String oldStart = sp.start;
        String oldEnd = sp.end;
        StringPair result = new StringPair();
        for (int j = oldEnd.length() - 1; j >= 0; j--) {
            result.addToStart(oldEnd.charAt(j));
        }
        for (int j = 0; j < oldStart.length(); j++) {
            result.addToEnd(oldStart.charAt(j));
        }
        return result;
    }

    private static class StringPair {
        String start = "";
        String end = "";

        void addToStart(String str) {
            start += str;
        }

        void addToStart(char c) {
            start += c;
        }

        void addToEnd(String str) {
            end = str + end;
        }

        void addToEnd(char c) {
            end = c + end;
        }

        public int length() {
            return start.length() + end.length();
        }

        @Override
        public String toString() {
            return start + end;
        }
    }
}