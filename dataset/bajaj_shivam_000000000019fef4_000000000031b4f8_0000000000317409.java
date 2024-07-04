import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
class Pair {
    int first;
    int second;
    Pair(int first,int second){
        this.first=first; hashCode();
        this.second=second;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int tt=1;tt<=t;tt++){
            String st[]=br.readLine().split(" ");
            int x=Integer.parseInt(st[0]);
            int y=Integer.parseInt(st[1]);
            String s=st[2];
            ArrayList<Pair> l=new ArrayList<>();
            l.add(new Pair(x,y));
            int n=s.length();
            int cost1[]=new int[n+1];
            int cost2[]=new int[n+1];
            cost1[0]=0;
            int lastX=x;
            int lastY=y;
            for(int i=0;i<n;i++){
                cost1[i+1]=i+1;
                if(s.charAt(i)=='N'){
                    lastY=lastY+1;
                    l.add(new Pair(lastX,lastY));
                }else if(s.charAt(i)=='S'){
                    lastY=lastY-1;
                    l.add(new Pair(lastX,lastY));
                }else if(s.charAt(i)=='E'){
                    lastX=lastX+1;
                    l.add(new Pair(lastX,lastY));
                }else if(s.charAt(i)=='W'){
                    lastX=lastX-1;
                    l.add(new Pair(lastX,lastY));
                }
            }
            for(int i=0;i<l.size();i++){
                int cx=l.get(i).first;
                int cy=l.get(i).second;
                int cost= Math.abs(cx)+Math.abs(cy);
                cost2[i]=cost;
            }

            int ans=Integer.MAX_VALUE;
            for(int i=0;i<=n;i++){
                if(cost2[i]<=cost1[i]){
                    ans= Math.min(ans,cost1[i]);
                }
            }
            if(ans==Integer.MAX_VALUE){
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }else{
                System.out.println("Case #"+tt+": "+ans);
            }

        }
    }
}
