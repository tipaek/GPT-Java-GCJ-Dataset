import java.util.*;
import java.io.*;

class Solution{
   public static void main(String args[])throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int counter = 1;
            boolean [] flag;
            int row = 0, col = 0;
            while(counter <= T){
                row = 0;
                col = 0;
                int trace = 0;
                HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                flag = new boolean [N*2];
                
                for(int i = 0; i < N; i++){
                     st = new StringTokenizer(br.readLine());
                     for(int j = 0; j < N; j++){
                        int n  = Integer.parseInt(st.nextToken());
                        map.putIfAbsent(i, new HashSet());
                        map.putIfAbsent(N+j, new HashSet());
                        if(map.get(i).contains(n) && !flag[i]){
                           row++;
                           flag[i] = true;
                        }
                 
                        if(map.get(j+N).contains(n) && !flag[j+N]){
                           col++;
                           flag[j+N] = true;
                        }
                         map.get(i).add(n);
                         map.get(j+N).add(n);
                        if(i == j)
                           trace+=n;
                     }
                }
               
               bw.write("Case #"+counter+": "+trace+" "+row+" "+col+"\n");
               bw.flush();
               counter++;
            }
            
            bw.close();
            br.close();
    }
  }
      
