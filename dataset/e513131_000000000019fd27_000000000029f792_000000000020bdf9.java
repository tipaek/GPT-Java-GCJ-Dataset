import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int merp = s.nextInt();

        for(int i=0; i<merp; i++) {
            boolean isImp = false;
            int N = s.nextInt();
            String ans = "";
            List<Integer> ct = new ArrayList<Integer>();
            List<Integer> jt = new ArrayList<Integer>();

            int[][] time = new int[N][4];
            for(int j=0; j<N; j++) {
                time[j][0] = s.nextInt();
                time[j][1] = s.nextInt();
                time[j][2] = j;
            }

            sortByStart(time, 0);
            // System.out.println(Arrays.deepToString(time));
            
            for(int j=0; j<N; j++) {
                if(isImp)
                isImp = false;
                int start = time[j][0];
                int end = time[j][1];
    
                if(isBusy(start, end, ct) && isBusy(start, end, jt)) {   //both are busy
                    isImp = true;
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    break;
                } 
                else if(!isBusy(start, end, ct) && !isBusy(start, end, jt) && !isImp) { //both are free
                    fillIn(start, end, jt);
                    time[j][3] = 2;
                }
                else if(isBusy(start, end, ct) && !isImp) {   //c is busy
                    fillIn(start, end, jt);
                    time[j][3] = 2;
                }
                else if(isBusy(start, end, jt) && !isImp) {   //j is busy
                    fillIn(start, end, ct);
                    time[j][3] = 1;
                }
            }

            sortByStart(time, 2);
            for(int j=0; j<N; j++) {
                if(time[j][3] == 1) {
                    ans+="C";
                } 
                else if(time[j][3] == 2) {
                    ans+="J";
                }
            }

            if(!isImp) {
                System.out.println("Case #" + (i+1) + ": " + ans);
            }
            
        }

        s.close();
    }

    static void fillIn(int start, int end, List<Integer> times) {
        for(int i=start; i<=end; i++) {
            times.add(i);
        }
    }

    static boolean isBusy(int start, int end, List<Integer> times) {
        if(times.contains(start) && times.contains(end)) {
            return true;
        }
        for(int i=start+1; i<end; i++) {
            if(times.contains(i)) {
                return true;
            }
        }
        return false;
    }

    static void sortByStart(int[][] arr, int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if(entry1[col] > entry2[col]) return 1;
                else return -1;
            }
        });
    }
}

/*
1
3
1 2 
2 3
1 5

*/
