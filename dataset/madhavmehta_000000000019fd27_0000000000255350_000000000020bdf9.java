import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int ii = 1 ; ii <= t; ii ++) {
            int n = sc.nextInt();
            int arr[][] = new int[n][2];
            int time[] = new int[1441];
            int num[] = new int[1441];
            int jarr[] = new int[1441];
            StringBuilder schedule = new StringBuilder();
            for(int i = 0; i < n; i ++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                time[arr[i][0]] ++;
                time[arr[i][1]] --;
            }
            int tot = 0;
            boolean flag = false;
            for(int i = 0; i < time.length; i ++) {
                tot += time[i];
//                System.out.print(tot + " ");
                if(tot > 2) {
                    flag = true;
                    System.out.println("Case #" + ii + ": IMPOSSIBLE");
                    break;
                }
                num[i] = tot;
//                if(tot > 1) {
//                    set.add(i);
//                }
            }

//            System.out.println();
            for(int i = 0; i < n; i ++) {
                if(check(jarr, arr[i][0], arr[i][1])) {
                    jarr[arr[i][0]] ++;
                    jarr[arr[i][1]] --;
                    schedule.append("J");
                }
                else {
                    schedule.append("C");
                }
//                if(set.ceiling(arr[i][0]) != null && set.ceiling(arr[i][0]) > arr[i][1]) {
//                    schedule.append("J");
//                }
//                else {
//                    schedule.append("C");
//                }
            }
            if(!flag){
                System.out.println("Case #" + ii + ": " + schedule.toString());
            }
        }
    }

    private static boolean check(int[] jarr, int i, int i1) {
        int tot = 0;
        for(int ii = 0; ii <= i1; ii ++) {
            tot += jarr[ii];
            if(ii >= i && ii <= i1 &&  tot == 1) return false;
        }
        return true;
    }
}