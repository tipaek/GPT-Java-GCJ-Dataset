import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Harry on 4/3/20.
 */
public class Solution {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int t=1; t<=T; t++){
            int N = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            int c = 0;
            int j = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
            for(int i=0; i<N; i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pq.offer(new int[]{start, end});

            }
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int start = cur[0];
                int end = cur[1];
                if(c<=start){
                    c = end;
                    sb.append('C');
                }
                else if(j<=start){
                    j = end;
                    sb.append('J');
                }
                else{
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #"+t+": "+sb.toString());
        }
    }
}
