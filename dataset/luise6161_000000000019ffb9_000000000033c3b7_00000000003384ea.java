import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static class Solar {
        int tid;
        Solar(int t){
            tid = t;
        }

        long calcEnd(long start, long num, long step) {
            return start+(num-1)*step;
        }

        Long calcSum(long start, long num, long step) {
            Long end = calcEnd(start, num, step);
            return (start+end)* num / 2;
        }

        long detect(long start, long total, long step) {
            if(start > total) return 0;
            if(start == total) return 1;
            long num = 1;
            while(calcSum(start, num, step) < total) {
                num *= 2;
            }
            if(calcSum(start, num, step) == total)
                return num;
            long end = num;
            num /= 2;
            long mid = (num + end) / 2;
            while(num < end - 1) {
                mid = (num + end) / 2;
                if(calcSum(start, mid, step) < total) {
                    num = mid;
                } else if(calcSum(start, mid, step) > total) {
                    end = mid;
                } else {
                    return mid;
                }
            }
            return num;
        }

        public void solve(){
            Long l, r;
            l = in.nextLong();
            r = in.nextLong();
            long eater = 0;
            if(l-r > 0) {
                long numl = detect(1, l-r, 1);
                l -= calcSum(1L, numl, 1);
                eater = numl;
            } else if(l-r<0) {
                long numr = detect(1, r-l, 1);
                r -= calcSum(1L, numr, 1);
                eater = numr;
            }

            long eatl, eatr;
            long ans = 0;
            if(l>=r) {
                eatl = detect(eater+1, l, 2);
                eatr = detect(eater+2, r, 2);

                if(eatl > eatr) {
                    if(eatr>0) {
                        ans = calcEnd(eater + 1, eatr + 1, 2);
                        l -= calcSum(eater + 1, eatr + 1, 2);
                        r -= calcSum(eater + 2, eatr, 2);
                    } else {
                        ans = eater + 1;
                        l -= ans;
                    }
                } else {
                    if(eatl>0) {
                        ans = calcEnd(eater + 2, eatl, 2);
                        l -= calcSum(eater + 1, eatl, 2);
                        r -= calcSum(eater + 2, eatl, 2);
                    } else {
                        ans = eater;
                    }
                }
            } else {
                eatl = detect(eater+2, l, 2);
                eatr = detect(eater+1, r, 2);

                if(eatr > eatl) {
                    if(eatl>0) {
                        ans = calcEnd(eater + 2, eatl + 1, 2);
                        l -= calcSum(eater + 2, eatl + 1, 2);
                        r -= calcSum(eater + 1, eatl, 2);
                    } else {
                        ans = eater + 1;
                        r -= ans;
                    }
                } else {
                    if(eatr>0) {
                        ans = calcEnd(eater + 1, eatr, 2);
                        l -= calcSum(eater + 2, eatr, 2);
                        r -= calcSum(eater + 1, eatr, 2);
                    } else {
                        ans = eater;
                    }
                }
            }

            System.out.println("Case #" + tid + ": " + ans + " " + l + " " + r) ;
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Solar s = new Solar(i);
            s.solve();
        }
    }
}
