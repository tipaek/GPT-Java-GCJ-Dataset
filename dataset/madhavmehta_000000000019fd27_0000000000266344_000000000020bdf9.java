import java.util.*;
import java.util.stream.Collector;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int ii = 1 ; ii <= t; ii ++) {
            int n = sc.nextInt();
            int arr[][] = new int[n][3];
            int time[] = new int[1441];
            int jarr[] = new int[1441];
            StringBuilder schedule = new StringBuilder();
            for(int i = 0; i < n; i ++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
                time[arr[i][0]] ++;
                time[arr[i][1]] --;
            }
            Arrays.sort(arr, (i, j) -> i[0] - j[0]);
            int tot = 0;
            boolean flag = false;
            for(int i = 0; i < time.length; i ++) {
                tot += time[i];
                if(tot > 2) {
                    flag = true;
                    System.out.println("Case #" + ii + ": IMPOSSIBLE");
                    break;
                }
            }
            ArrayList<int[]> ret = new ArrayList<>();
            for(int i = 0; i < n; i ++) {
                if(check(jarr, arr[i][0], arr[i][1])) {
                    jarr[arr[i][0]] ++;
                    jarr[arr[i][1]] --;
                    ret.add(new int[]{'J' - 'A', arr[i][2]});
                }
                else {
                    ret.add(new int[]{'C' - 'A', arr[i][2]});
                }
            }
            Collections.sort(ret, (i, j) -> i[1] - j[1]);
            if(!flag){
                System.out.print("Case #" + ii + ": ");
                for(int i = 0; i < ret.size(); i ++) {
                    char c = (char)(ret.get(i)[0] + (int)'A');
                    System.out.print(c);
                }
                System.out.println();
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