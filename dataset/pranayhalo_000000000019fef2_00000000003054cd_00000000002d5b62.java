import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder strBu = new StringBuilder();

        int t = std.nextInt();

        int caseN = 0;
        while (caseN++ < t) {
            long xx = std.nextLong();
            long yy = std.nextLong();

            long x = xx;
            long y = yy;

            char posNS = 'S';
            char negNS = 'N';
            char posWE = 'W';
            char negWE = 'E';

            if (y > 0) {
                posNS = 'N';
                negNS = 'S';
            }

            if (x > 0) {
                posWE = 'E';
                negWE = 'W';
            }

            x = Math.abs(x);
            y = Math.abs(y);

            if ( (((x%2) ^ (y%2)) == 0)) { //both 0 or 1
                log.write("Case #" + caseN + ": IMPOSSIBLE");
                log.write("\n");
                continue;
            }

            //one odd, one even

            boolean xOdd = true;
            if (y % 2 == 1) {
                xOdd = false;
            }

            int largestBit = 0;

            char[] ans;
            int ansPoint = 0;
            boolean isPos = true;

            if (xOdd) { //try adding one to it
                x = Math.abs(xx) + 1;
                largestBit = Math.max(MSB(x), MSB(y));
                ans = new char[largestBit + 1];
                ans[ansPoint] = negWE;
                ansPoint++;
            } else {
                y = Math.abs(yy) + 1;
                largestBit = Math.max(MSB(x), MSB(y));
                ans = new char[largestBit + 1];
                ans[ansPoint] = negNS;
                ansPoint++;
            }


            for (int i = 1; i <= largestBit; i++) {
                //need it to still compare to the very last one
                long shift1 = 1 << i;
                long shift2 = 1 << (i+1);
                if (((x & shift1) != 0) && ((y & shift1) == 0)) { //x has a 1, y does not
                    //dealing with WE direction!
                    while (ansPoint < largestBit && ((x & shift2) == 0) && ((y & shift2) == 0)) { //the next bit is a 0 (must cover)
                        ans[ansPoint] = negWE;
                        ansPoint++;
                        shift2 = shift2 << 1;
                    }
                    if (ansPoint <= largestBit) {
                        ans[ansPoint] = posWE;
                        ansPoint++;
                        i = ansPoint - 1; //due to i++ later
                    }
                    continue;
                } else if (((y & shift1) != 0) && ((x & shift1) == 0)) { //y has a 1, x does not
                    //dealing with WE direction!
                    while (ansPoint < largestBit && ((x & shift2) == 0) && ((y & shift2) == 0)) { //the next bit is a 0 (must cover)
                        ans[ansPoint] = negNS;
                        ansPoint++;
                        shift2 = shift2 << 1;
                    }
                    if (ansPoint <= largestBit) {
                        ans[ansPoint] = posNS;
                        ansPoint++;
                        i = ansPoint - 1; //due to i++ later
                        continue;
                    }
                } else {
                    if (i != largestBit) {
                        isPos = false;
                        break;
                    }
                }
            }


            if (isPos) {
                log.write("Case #" + caseN + ": ");
                for (int i = 0; i < ans.length; i++) {
                    log.write(ans[i] + "");
                }
                log.write("\n");
            } else {
                ans = new char[largestBit + 1];
                ansPoint = 0;
                isPos = true;
                if (xOdd) { //try sub one to it
                    x = Math.abs(xx) - 1;
                    largestBit = Math.max(MSB(x), MSB(y));
                    ans = new char[largestBit + 1];
                    ans[ansPoint] = posWE;
                    ansPoint++;
                } else {
                    y = Math.abs(yy) - 1;
                    largestBit = Math.max(MSB(x), MSB(y));
                    ans = new char[largestBit + 1];
                    ans[ansPoint] = posNS;
                    ansPoint++;
                }


                for (int i = 1; i <= largestBit; i++) {
                    //need it to still compare to the very last one
                    long shift1 = 1 << i;
                    long shift2 = 1 << (i+1);
                    if (((x & shift1) != 0) && ((y & shift1) == 0)) { //x has a 1, y does not
                        //dealing with WE direction!
                        while (ansPoint < largestBit && ((x & shift2) == 0) && ((y & shift2) == 0)) { //the next bit is a 0 (must cover)
                            ans[ansPoint] = negWE;
                            ansPoint++;
                            shift2 = shift2 << 1;
                        }
                        if (ansPoint <= largestBit) {
                            ans[ansPoint] = posWE;
                            ansPoint++;
                            i = ansPoint - 1; //due to i++ later
                        }
                        continue;
                    } else if (((y & shift1) != 0) && ((x & shift1) == 0)) { //y has a 1, x does not
                        //dealing with WE direction!
                        while (ansPoint < largestBit && ((x & shift2) == 0) && ((y & shift2) == 0)) { //the next bit is a 0 (must cover)
                            ans[ansPoint] = negNS;
                            ansPoint++;
                            shift2 = shift2 << 1;
                        }
                        if (ansPoint <= largestBit) {
                            ans[ansPoint] = posNS;
                            ansPoint++;
                            i = ansPoint - 1; //due to i++ later
                            continue;
                        }
                    } else {
                        if (i != largestBit) {
                            isPos = false;
                            break;
                        }
                    }
                }

                if (isPos) {
                    log.write("Case #" + caseN + ": ");
                    for (int i = 0; i < ans.length; i++) {
                        log.write(ans[i] + "");
                    }
                    log.write("\n");
                } else {
                    log.write("Case #" + caseN + ": IMPOSSIBLE\n");
                }



            }
        }
        log.flush();

    }

    public static int MSB(long n) {
        int ndx = 0;
        while (1 < n) {
            n = (n >> 1);
            ndx++;
        }
        return ndx;
    }
}
