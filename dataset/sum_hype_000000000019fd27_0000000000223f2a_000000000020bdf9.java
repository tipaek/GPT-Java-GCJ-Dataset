import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] ans = new String[N];
        for(int p = 0; p < N; p++){
            int M = Integer.parseInt(scan.nextLine());
            int[][] times = new int[M][2];
            int[][] times1 = new int[M][2];
            for(int i = 0; i < M; i++){
                StringTokenizer st = new StringTokenizer(scan.nextLine());
                times[i][0] = Integer.parseInt(st.nextToken());
                times[i][1] = Integer.parseInt(st.nextToken());
                times1[i][0] = times[i][0];
                times1[i][1] = times[i][1];
            }

            Arrays.sort(times, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] > o2[0])
                        return 1;
                    else if(o1[0] < o2[0])
                        return -1;
                    return 0;
                }
            });


            int jEnd = -1;
            int cEnd = -1;
            char[] arr = new char[M];
            String output = "";

            for(int i = 0; i < M; i++){
                if(times[i][0]>=jEnd){
                    jEnd = times[i][1];
                    arr[i] = 'J';
                } else if (times[i][0]>=cEnd){
                    cEnd = times[i][1];
                    arr[i] = 'C';
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }

            char[] arrAdj = new char[M];
            if(output.equals("IMPOSSIBLE")){
                ans[p] = "Case #" + (p+1) + ": " + output;
            } else {
                for(int i = 0; i < M; i ++){
                    for(int k = 0; k < M; k ++){
                        if(times[i][0] == times1[k][0] && times[i][1] == times1[k][1]){
                            arrAdj[i] = arr[k];
                            if(i % 2 == 0)
                               break;
                            //JCCJC
                        }
                    }
                }

                for(char i: arrAdj)
                    output += i;
                ans[p] = "Case #" + (p+1) + ": " + output;
            }


        }

        for(String i: ans)
            System.out.println(i);
    }
}