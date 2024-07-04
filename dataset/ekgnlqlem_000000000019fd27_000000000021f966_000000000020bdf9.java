import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int i = 1; i <= T; i++){
            int N = input.nextInt();
            int[][] schedule =  new int[N][3];
            for(int j = 0; j < N; j++){
                schedule[j] = new int[]{input.nextInt(),input.nextInt(), j};
            }
			Arrays.sort(schedule, (a,b) -> a[0]-b[0]);
            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
			queue.add(new int[]{schedule[0][1], 1, schedule[0][2]});
            StringBuilder sb = new StringBuilder("C");
			char[] res = new char[N];
			res[schedule[0][2]] = 'C';
			int id = 1;
            for(int k = 1; k < N; k++){
				//System.out.println(k);
                while(!queue.isEmpty() && schedule[k][0] >= queue.peek()[0]){
                    queue.poll();
                }
				if(!queue.isEmpty()){
					System.out.println(queue.peek()[0]);
					if(queue.peek()[1] == 1) id = 0;
					else id = 1;
				}
                queue.offer(new int[]{schedule[k][1], id, schedule[k][2]});
				if(queue.size() > 2) break;
                if(id == 1){
					sb.append('C');
					res[schedule[k][2]] = 'C';
				}
                else{
					sb.append('J');
					res[schedule[k][2]] = 'J';
				}
                
				//System.out.println(sb.toString());
				//System.out.println(Arrays.toString(res));

            }
            if(sb.length() == N)
                System.out.println("Case #"+i+": "+ new String(res));
            else 
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}