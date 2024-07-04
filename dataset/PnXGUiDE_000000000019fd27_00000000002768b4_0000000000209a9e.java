import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();
        for(int i = 1; i <= T; i++) {
            int known = 0;

            boolean[] norm = new boolean[B];

            int compIdx = -1;
            int revsIdx = -1;

            // 1st round
            for(int j = 0; j < 5; j++) {
                System.out.println(j + 1);
                System.out.flush();
                boolean front = in.nextInt() == 1;
                norm[j] = front;

                System.out.println(B - j);
                System.out.flush();
                boolean back = in.nextInt() == 1;
                norm[B - j - 1] = back;

                if(front == back) compIdx = j;
                else revsIdx = j;

                known += 2;
            }

            int curPos = 4;
            boolean isComp = false;
            boolean isRevs = false;

            while(known < B) {
                if(compIdx == -1) {
                    System.out.println("1");
                    System.out.flush();
                    in.nextInt();
                } else {
                    System.out.println(compIdx + 1);
                    System.out.flush();
                    isComp = (in.nextInt() == 1) != norm[compIdx];
                }

                if(revsIdx == -1) {
                    System.out.println("1");
                    System.out.flush();
                    in.nextInt();
                } else {
                    System.out.println(revsIdx + 1);
                    System.out.flush();
                    isRevs = (in.nextInt() == 1) != (isComp ^ norm[revsIdx]);
                }

                boolean[] fronts = new boolean[4];
                boolean[] backs = new boolean[4];

                for(int j = 0; j < 4; j++) {
                    System.out.println(j + 1 + curPos + 1);
                    System.out.flush();

                    // 1 2 3 4 5
                    fronts[j] = in.nextInt() == 1;

                    System.out.println(B - (j + 1 + curPos));
                    System.out.flush();

                    // 5 4 3 2 1
                    backs[j] = in.nextInt() == 1;

                    if(fronts[j] == backs[j]) compIdx = j + 1 + curPos;
                    else revsIdx = j + 1 + curPos;

                    known += 2;
                }

                // System.out.println(isComp + " " + isRevs);

                if(isComp && isRevs) {
                    for(int j = 0; j < 4; j++) {
                        norm[curPos + 1 + j] = !backs[j];
                        norm[B - (curPos + 1 + 1 + j)] = !fronts[j];
                    }
                } else if(isComp && !isRevs) {
                    for(int j = 0; j < 4; j++) {
                        norm[curPos + 1 + j] = !fronts[j];
                        norm[B - (curPos + 1 + 1 + j)] = !backs[j];
                    }
                } else if(!isComp && isRevs) {
                    for(int j = 0; j < 4; j++) {
                        norm[curPos + 1 + j] = backs[j];
                        norm[B - (curPos + 1 + 1 + j)] = fronts[j];
                    }
                } else {
                    for(int j = 0; j < 4; j++) {
                        norm[curPos + 1 + j] = fronts[j];
                        norm[B - (curPos + 1 + 1 + j)] = backs[j];
                    }
                }
                curPos += 4;
            }

            System.out.println(boolArrToInt(norm, isComp, isRevs));

            System.out.flush();
            String result = in.next();
            if(result.equals("Y")) continue;
            else System.exit(0);
        }
    }

    public static String boolArrToInt(boolean[] data, boolean comp, boolean revs) {
        StringBuilder sb = new StringBuilder();
        for(boolean b : data) {
            sb.append(comp ^ b ? 1 : 0);
        }
        if(revs) sb.reverse();
        return sb.toString();
    }
}
