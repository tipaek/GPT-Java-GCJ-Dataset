import java.util.Scanner;

public class CodeJam2020_NestingDepth {

    public static void main(String[] args) {
        int testCases;
        StringBuilder str = new StringBuilder();
        String k;
        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();
        boolean oneFound, zeroFound, opened;
        oneFound = zeroFound = opened = false;
        for (int i = 0; i < testCases; i++) {
            k = sc.next();
            for (int j = 0; j < k.length(); j++) {
                if (k.charAt(j) == '1') {
                    if (!oneFound) {
                        str.append('(');
                        opened = true;
                        str.append(k.charAt(j));
                        oneFound = true;
                        zeroFound = false;
                    } else {
                        str.append(k.charAt(j));
                    }
                } else if (k.charAt(j) == '0') {
                    if (!zeroFound) {
                        str.append(')');
                        opened = false;
                        str.append(k.charAt(j));
                        zeroFound = true;
                        oneFound = false;
                    } else {
                        str.append(k.charAt(j));
                    }
                }
            }
            if (opened) {
                str.append(")");
            }
            System.out.println(str.toString());
            str = new StringBuilder();
            oneFound = zeroFound = false;
        }
    }
}
