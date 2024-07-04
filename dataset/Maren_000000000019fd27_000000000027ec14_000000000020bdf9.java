import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static List<Activity> list;
    static boolean[] boolList;
    static int N;

    public static void main(String[] args) {
        Scanner io = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = io.nextInt();
        for (int i = 1; i <= testcases; i++) {
            N = io.nextInt();
            list = new ArrayList<>();
            boolList = new boolean[N];
            for (int j = 0; j < N; j++) {
                int start = io.nextInt();
                int end = io.nextInt();
                list.add(new Activity(start, end));
            }
            String answer = "Case #" + i + ": ";
            System.out.print(answer);
            if (findRight(0)) {
                for (int j = 0; j < boolList.length; j++) {
                    if (boolList[j]) {
                        System.out.print("J");
                    } else
                        System.out.print("C");
                }

                System.out.println();


            } else {
                System.out.println("IMPOSSIBLE");
            }


        }
    }

    private static boolean findRight(int i) {
        if (i == N) {
            for (int j = 0; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if(!boolList[j]&& !boolList[k]){
                        if(overlaps(list.get(j),list.get(k)))
                            return false;
                    }
                }
            }
            return true;
        }
        Activity act = list.get(i);
        for (int j = 0; j < i; j++) {
            if (boolList[j]) {
                Activity nextAct = list.get(j);
                if (overlaps(act, nextAct)) {
                    boolList[i]=false;
                    return findRight(i+1);
                }
            }
        }

        boolList[i]=true;
        boolean canBetrue = findRight(i+1);
        if(canBetrue){
            return true;
        }else{
            boolList[i]=false;
            return findRight(i+1);
        }

    }

    private static boolean overlaps(Activity act, Activity nextAct) {
        return (act.end > nextAct.start && nextAct.end > act.start);
    }


    private static class Activity {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
