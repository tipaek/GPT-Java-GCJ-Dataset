import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int trial = 1; trial <= t; trial++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> time = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> rank = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> torank = new HashMap<Integer,Integer>();
            ArrayList<Integer> times = new ArrayList<Integer>();
            ArrayList<Integer> ranks = new ArrayList<Integer>();
            HashMap<Integer,Integer> ranktotime = new HashMap<Integer,Integer>();
            st = new StringTokenizer(br.readLine());
            rank.put(0,1);
            torank.put(1,0);
            ranktotime.put(0,0);
            for(int i = 0; i < C-1; i++){
                int d = Integer.parseInt(st.nextToken());
                if(d < 0){
                    rank.put(-d,i+2);
                    torank.put(i+2,-d);
                    ranks.add(-d);
                }
                else{
                    time.put(d,i+2);
                    times.add(d);
                }
            }
            Collections.sort(times);
            Collections.sort(ranks);
            int j = 0;
            int maxrank = ranks.get(ranks.size()-1);
            for(int i = 0; i < times.size(); i++){
                while(j < ranks.size() && ranks.get(j) < j + i + 1){
                    j++;
                }
                rank.put(j+i+1,time.get(times.get(i)));
                torank.put(time.get(times.get(i)),j+i+1);
                ranktotime.put(j+i+1,times.get(i));
                maxrank = Math.max(j+i+1,maxrank);
            }
            int next = 1;
            for(int i = 1; i <= maxrank; i++){
                if(rank.keySet().contains(i)){
                    if(ranktotime.keySet().contains(i)){
                        next = ranktotime.get(i) + 1;
                    }
                    else{
                        ranktotime.put(i,next);
                        next++;
                    }
                }
            }
            System.out.print("Case #" + trial + ": ");
            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int u1 = torank.get(u);
                int v1 = torank.get(v);
                int diff = Math.abs(ranktotime.get(u1) - ranktotime.get(v1));
                System.out.print(Math.max(diff,1) + " ");
            }
            System.out.println();
        }
    }
}