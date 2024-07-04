import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            ArrayList<Character> RESULT = new ArrayList<>();
            boolean isPossible = true;

            for (int i = 0; i < N; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            int countK = 0;
            RESULT.add('C');
            for (int i = 1; i < N; i++) {
               boolean triggerC = false;
               boolean triggerJ = false;
               for (int j = 0; j < i; j ++) {
                   if (RESULT.get(j) == 'C') {
                       triggerC = isDuplicated(start[i], start[j], end[i], end[j]);
                   }
               }
               for (int j = 0; j < i; j ++) {
                   if (RESULT.get(j) == 'J') {
                       triggerJ = isDuplicated(start[i], start[j], end[i], end[j]);
                   }
               }
               if (triggerC && !triggerJ) {
                   RESULT.add('J'); continue;
               }
               if (!triggerC && triggerJ) {
                   RESULT.add('C'); continue;
               }
               if (!triggerC && !triggerJ) {
                   RESULT.add('K'); countK++; continue;
               }
               if (triggerC && triggerJ){
                   isPossible = false;
                   break;
               }
            }
            if (isPossible)
                for (int i = 0; i < N; i++) {
                    boolean triggerC = false;
                    boolean triggerJ = false;
                    if (RESULT.get(i) == 'K') {
                        for (int j = 0; j < N; j ++) {
                            if (i == j) continue;
                            if (RESULT.get(j) == 'C') {
                                triggerC = isDuplicated(start[i], start[j], end[i], end[j]);
                            }
                        }
                        for (int j = 0; j < N; j ++) {
                            if (i == j) continue;
                            if (RESULT.get(j) == 'J') {
                                triggerJ = isDuplicated(start[i], start[j], end[i], end[j]);
                            }
                        }
                        if (triggerC && !triggerJ) {
                            RESULT.set(i,'J');
                            countK--;
                            continue;
                        }
                        if (!triggerC && triggerJ) {
                            RESULT.set(i,'C');
                            countK--;
                            continue;
                        }
                    }
                }
            if (isPossible)
                for (int i = 0; i<N; i++)
                    if (RESULT.get(i)=='K') RESULT.set(i, 'C');
            System.out.print("Case #"+testCase+": ");
            if (!isPossible) System.out.println("IMPOSSIBLE");
            else {
                for (int i = 0; i < RESULT.size(); i++){
                    System.out.print(RESULT.get(i));
                }
                System.out.println();
            }
        }
    }
    private static boolean isDuplicated(int start1, int start2, int end1, int end2) {
        if (start1>=start2) {
            if (end2 <= start1)
                return false;
            else
                return true;
        }
        else if (end1<=end2) {
            if (start2 >= end1)
                return false;
            else
                return true;
        }
        else return true;
    }
}

