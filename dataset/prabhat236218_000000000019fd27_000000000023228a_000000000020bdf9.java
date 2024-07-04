import java.io.*;
import java.util.*;

public class Solution{
    public static class Pair{
        int x,y , index;
        Pair(int x, int y , int index){
            this.x=x;
            this.y=y;
            this.index=index;
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int T=1;T<=t;T++){
            int n=scanner.nextInt();
            LinkedList<Pair> l=new LinkedList<Pair>();
            for(int i=0;i<n;i++){
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                l.add(new Pair(x,y ,i));
            }
            l.sort((p1,p2)->{
                if(p1.x!=p2.x)return p1.x-p2.x;
                else return p1.y-p2.y;
            });
            
            char[] ans=new char[n];
            ans[l.get(0).index]='C';
            HashSet<Character> hs=new HashSet<>();
            boolean valid=true;
            for(int i=1;i<n;i++){
                Pair pi=l.get(i);
                for(int j=i-1;j>=0;j--){
                    Pair pj=l.get(j);
                    if(pj.y<=pi.x)break;
                     else hs.add(ans[pj.index]);
                }
                Pair prev=l.get(i-1);
                if(hs.size()==2){
                    valid=false;
                }
                else if(hs.size()==1){
                    if(ans[prev.index]=='C')ans[pi.index]='J';
                    else if(ans[prev.index]=='J')ans[pi.index]='C';
                }
                else ans[pi.index]=ans[prev.index];
                
                if(!valid)break;
                hs.clear();
            }
            if(valid)System.out.println("Case #"+T+": "+ (new String(ans)));
            else System.out.println("Case #"+T+": "+ "IMPOSSIBLE");
        }
    }
}