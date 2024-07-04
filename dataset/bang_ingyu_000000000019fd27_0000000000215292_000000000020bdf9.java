import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Solution {
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    
    public static class Activity implements Comparable<Activity>{
        int start;
        int end;
        int index;
        
        public Activity(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public int compareTo(Activity o) {
			if(this.end == o.end){
				return this.start - o.start;
			}
			return this.end - o.end;
		}
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = stoi(br.readLine());
        
        for(int i = 1; i <= T; i++){
            sb.append("Case #");
            sb.append(i);
            sb.append(": ");
            
            int N = stoi(br.readLine());
            
            PriorityQueue<Activity> activities = new PriorityQueue<>();
            
            for(int j = 1; j <= N; j++){
                st = new StringTokenizer(br.readLine());
                activities.add(new Activity(stoi(st.nextToken()),stoi(st.nextToken()),j));
            }
            
            String[] out = new String[N+1];
            int Cnow = 0;
            int Jnow = 0;
            boolean isPossible = true;
            
            while(!activities.isEmpty()){
                Activity now = activities.poll();
                
                if(now.start >= Cnow){
                    Cnow = now.end;
                    out[now.index] = "C";
                } else if(now.start >= Jnow){
                    Jnow = now.end;
                    out[now.index] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible){
                for(int j = 1; j <= N; j++){
                    sb.append(out[j]);
                }
                sb.append("\n");
            } else {
                sb.append("IMPOSSIBLE\n");
            }
            
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}