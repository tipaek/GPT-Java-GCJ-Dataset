import java.io.*;
import java.util.*;
class Triple{
    int x;
    int y;
    int d;
    Triple(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution{
    public static void main(String []arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            String []s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String m = s[2];
            Map<String,Integer> hm = new HashMap();
            String s2 = Integer.toString(x) + " " + Integer.toString(y);
            hm.put(s2, 0);
            for(int i=0;i<m.length();i++){
                if(m.charAt(i) == 'S'){
                    y --;
                }else if(m.charAt(i) == 'N'){
                    y ++;
                }else if(m.charAt(i) == 'W'){
                    x --;
                }else{
                    x ++;
                }
                hm.put(Integer.toString(x) + " " + Integer.toString(y), i+1);
            }
            Queue<Triple> q = new ArrayDeque();
            q.add(new Triple(0,0,0));
            int ans = Integer.MAX_VALUE;
            Set<String> hs = new HashSet();
            hs.add("0 0");
            while(!q.isEmpty()){
                Triple tr = q.poll();
                String tmp = Integer.toString(tr.x) + " " + Integer.toString(tr.y);
                if(hm.containsKey(tmp) && hm.get(tmp) >= tr.d){
                    ans = Math.min(ans, hm.get(tmp));
                }
                if(!hs.contains(Integer.toString(tr.x-1) + " " + Integer.toString(tr.y)) && tr.d < m.length()){
                    hs.add(Integer.toString(tr.x-1) + " " + Integer.toString(tr.y));
                    q.add(new Triple(tr.x - 1, tr.y , tr.d + 1));
                }
                if(!hs.contains(Integer.toString(tr.x+1) + " " + Integer.toString(tr.y)) && tr.d < m.length()){
                    hs.add(Integer.toString(tr.x+1) + " " + Integer.toString(tr.y));
                    q.add(new Triple(tr.x + 1, tr.y , tr.d + 1));
                }
                if(!hs.contains(Integer.toString(tr.x) + " " + Integer.toString(tr.y-1)) && tr.d < m.length()){
                    hs.add(Integer.toString(tr.x) + " " + Integer.toString(tr.y-1));
                    q.add(new Triple(tr.x, tr.y-1 , tr.d + 1));
                }
                if(!hs.contains(Integer.toString(tr.x) + " " + Integer.toString(tr.y+1)) && tr.d < m.length()){
                    hs.add(Integer.toString(tr.x) + " " + Integer.toString(tr.y+1));
                    q.add(new Triple(tr.x, tr.y+1 , tr.d + 1));
                }
            }
            if(ans == Integer.MAX_VALUE){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }else{
                System.out.println("Case #" + t + ": " + ans);
            }
        }
    }
}