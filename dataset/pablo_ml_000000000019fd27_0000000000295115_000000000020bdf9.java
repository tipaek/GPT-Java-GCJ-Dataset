import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Integer> cameronStarts = new ArrayList<>();
        ArrayList<Integer> cameronFinish = new ArrayList<>();
        ArrayList<Integer> jaimeStarts = new ArrayList<>();
        ArrayList<Integer> jaimeFinish = new ArrayList<>();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            StringBuilder solution = new StringBuilder();

            cameronStarts.clear();
            cameronFinish.clear();
            jaimeStarts.clear();
            jaimeFinish.clear();

            boolean available = false;
            boolean impossible = false;

            for(int j = 0; j < n; j++) {
                int startTime = in.nextInt();
                int finishTime = in.nextInt();

                if(!impossible) {
                    available = true;
                    for (int k = 0; k < cameronStarts.size(); k++) {
                        if (overlap(startTime, finishTime, cameronStarts.get(k), cameronFinish.get(k))) {
                            available = false;
                            break;
                        }
                    }
                    if (available) {
                        cameronStarts.add(startTime);
                        cameronFinish.add(finishTime);

                        solution.append("C");
                    } else {
                        available = true;
                        for (int k = 0; k < jaimeStarts.size(); k++) {
                            if (overlap(startTime, finishTime, jaimeStarts.get(k), jaimeFinish.get(k))) {
                                available = false;
                                break;
                            }
                        }
                        if (available) {
                            jaimeStarts.add(startTime);
                            jaimeFinish.add(finishTime);

                            solution.append("J");
                        } else {
                            solution = new StringBuilder("IMPOSSIBLE");
                            impossible = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ":"  + " " + solution);
        }


    }



    private static boolean overlap(int start1,int finish1, int start2, int finish2) {
        return start1 < finish2 && start2 <= finish1;
    }
}

