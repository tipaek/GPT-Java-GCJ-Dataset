import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int min = Math.abs(x);

            if (s.length() < min) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            int step = 0;
            for (; step < min; step++) {
                y = y + next(s, step);
            }
            if (y == 0) System.out.println("Case #" + i + ": " + min);
            else {
                int my = 0;
                boolean flag = false;
                if (y > 0) {
                    while (step < s.length() && !flag) {
                        if (checkS(s, step) && y - my == 1) {
                            System.out.println("Case #" + i + ": " + (step+1));
                            flag = true;
                        }
                        else {
                            y += next(s, step);
                            my++;
                            step++;
                            if(y - my == 0){
                                System.out.println("Case #" + i + ": " + (step));
                                flag = true;
                            }
                        }
                    }
                }
                else {
                    while (step < s.length() && !flag) {
                        if (checkN(s, step) && y - my == -1) {
                            System.out.println("Case #" + i + ": " + (step+1));
                            flag = true;
                        }
                        else {
                            y += next(s, step);
                            my--;
                            step++;
                            if(y - my == 0){
                                System.out.println("Case #" + i + ": " + (step));
                                flag = true;
                            }
                        }
                    }

                }
                if(!flag){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
        in.close();
    }

    private static boolean checkS(String s, int num) {
        return next(s, num) == -1;
    }

    private static boolean checkN(String s, int num) {
        return next(s, num) == 1;
    }

    private static int next(String s, int num) {
        // if(num == s.length()) return 1;
        if (s.charAt(num) == 'N') return 1;
        else
            return -1;
    }
}