import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Harry on 4/3/20.
 */
public class Solution {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int t=1; t<=T; t++){
            int N = scanner.nextInt();
            int c = 0;
            int j = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
            for(int i=0; i<N; i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pq.offer(new int[]{i, start, end});

            }
            List<char[]> resList = new ArrayList();
            boolean isPossible = true;
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int start = cur[1];
                int end = cur[2];
                if(c<=start){
                    c = end;
                    resList.add(new char[]{(char)cur[0],'C'});
                }
                else if(j<=start){
                    j = end;
                    resList.add(new char[]{(char)cur[0],'J'});
                }
                else{
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible){
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
            else{
                char[] res = new char[N];
                for(char[] cur : resList){
                    res[cur[0]] = cur[1];
                }
                System.out.println("Case #"+t+": "+new String(res));
            }
        }
    }
}
