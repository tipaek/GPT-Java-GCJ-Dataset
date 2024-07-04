import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int nact = sc.nextInt();
            processing(nact, i + 1);
        }
    }

    public static void processing(int nact, int ncase) {
        Integer[][] ordered = new Integer[nact][2];
        for (int i = 0; i < nact; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ordered[i][0] = start;
            ordered[i][1] = end;
        }
        char[] result = new char[nact];
        boolean impossible = false;
        for (int i = 0; i < ordered.length; i++) {
            int startI = ordered[i][0];
            int endI = ordered[i][1];
            int j = i + 1;

            while (true) {
                if (j < ordered.length) {
                    //Get Next
                    int nextStart = ordered[j][0];
                    int nextEnd = ordered[j][1];

                    //OVERLAP
                    int prevMinStart = Math.min(startI, nextStart);
                    int prevMaxStart = Math.max(startI, nextStart);
                    int prevMinEnd = Math.min(endI, nextEnd);
                    if (prevMinStart < prevMaxStart && prevMaxStart < prevMinEnd) {
                        if (j + 1 < ordered.length) {

                            //IMPOSSIBLE
                            int nextNextStart = ordered[j + 1][0];
                            int maxStart = Math.max(Math.max(startI, nextStart), nextNextStart);
                            if (prevMaxStart < maxStart && maxStart < prevMinEnd) {
                                impossible = !impossible;
                                i = ordered.length;
                                break;
                            }
                        }
                        if(ordered.length == 2){
                            result[0] = 'J';
                            result[1] = 'C';
                        }
                        if(i == 0 && result[i] != 'J'){
                            result[i] = 'C';
                        }
                        if(i == 0 || result[j] != 'C'){
                            result[j] = 'J';
                        }
                    } else {
                        //NO OVERLAP
                        if(ordered.length == 2){
                            result[0] = 'J';
                            result[1] = 'J';
                        }
                        if(i == 0 && result[j] != 'J'){
                            result[j] = 'C';
                        }
                    }
                    j++;
                } else {
                    break;
                }
            }
        }
        if(impossible){
            print(ncase, "IMPOSSIBLE");
        } else {
            print(ncase, new String(result));
        }
    }

    public static void print(int ncase, String result) {
        System.out.println("Case #" + ncase + ":" + " " + result);
    }
}
