import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            StringBuilder RESULT = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < N; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }

            RESULT.append('C');
            int countK = 0;
            for (int i = 1; i < N; i++) {

                boolean triggerC = false;
                boolean triggerJ = false;
                for (int j = 0; j < i; j ++) {
                    if (RESULT.charAt(j) == 'C') {
                        if (isDuplicated(start[i], start[j], end[i], end[j]))
                        {
                            triggerC = true;
                            break;
                        }
                    }
                }
                for (int j = 0; j < i; j ++) {
                    if (RESULT.charAt(j) == 'J') {
                        if (isDuplicated(start[i], start[j], end[i], end[j]))
                        {
                            triggerJ = true;
                            break;
                        }
                    }
                }
                if (triggerC && !triggerJ) {
                    RESULT.append('J'); continue;
                }
                if (!triggerC && triggerJ) {
                    RESULT.append('C'); continue;
                }
                if (!triggerC && !triggerJ) {
                    RESULT.append('K'); countK++; continue;
                }
                if (triggerC == true && triggerJ == true){
                    isPossible = false;
                    break;
                }
            }

            while (countK>1){
                for (int i = 1; i < N; i++) {
                    boolean triggerC = false;
                    boolean triggerJ = false;
                    if (RESULT.charAt(i) != 'K') continue;


                    for (int j = 0; j < N; j ++) {
                        if (RESULT.charAt(j) == 'C') {
                            triggerC = isDuplicated(start[i], start[j], end[i], end[j]);
                            break;
                        }
                    }
                    for (int j = 0; j < N; j ++) {
                        if (RESULT.charAt(j) == 'J') {
                            triggerJ = isDuplicated(start[i], start[j], end[i], end[j]);
                            break;
                        }
                    }
                    if (triggerC && !triggerJ) {
                        RESULT.setCharAt(i, 'J');
                        countK--;
                        continue;
                    }
                    if (!triggerC && triggerJ) {
                        RESULT.setCharAt(i, 'C');
                        countK--;
                        continue;
                    }
                    if (!triggerC && !triggerJ) {
                        countK++;
                        continue;
                    }
                    if (triggerC == true && triggerJ == true){
                        isPossible = false;
                        break;
                    }
                }
                countK--;
            }

            for (int i = 1; i < N; i++) {
                boolean triggerC = false;
                boolean triggerJ = false;
                for (int j = 0; j < N; j ++) {
                    if (RESULT.charAt(j) == 'C') {
                        if (isDuplicated(start[i], start[j], end[i], end[j])){
                            triggerC = true;
                            break;
                        }
                    }
                }
                for (int j = 0; j < N; j ++) {
                    if (RESULT.charAt(j) == 'J') {
                        if (isDuplicated(start[i], start[j], end[i], end[j])){
                            triggerJ = true;
                            break;
                        }
                    }
                }
                if (triggerC && !triggerJ) {
                    RESULT.setCharAt(i, 'J');
                }
                else if (!triggerC && triggerJ) {
                    RESULT.setCharAt(i, 'C');
                }
            }



            if (RESULT.charAt(RESULT.length()-1)=='K' && countK == 1){
                RESULT.setCharAt(RESULT.length()-1, 'C');
            }


            if (!isPossible) RESULT = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #"+testCase+": "+RESULT.toString());
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

