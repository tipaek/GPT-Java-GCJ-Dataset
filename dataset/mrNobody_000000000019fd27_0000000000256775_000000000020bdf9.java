import java.util.*;
import java.io.*;
class Solution {
    
    class Pair{
        int idx;
        int start;
        int end;
        Pair(int i,int s,int e){
            idx=i;
            start=s;
            end=e;
        }
    }
     boolean isOverlap(int i,int j,Pair[] p){
        if(p[i].end>p[j].start)return true;
        return false;
    }
    String solve(BufferedReader br) throws IOException{
        int n=Integer.parseInt(br.readLine());
        Pair[] p=new Pair[n];
        char ans[]=new char[n];
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);;
            p[i]=new Pair(i,s,e);
        }
        Arrays.sort(p,(p1,p2)->{return p1.end-p2.end;});
        int c=0,j=0;
        ans[0]='C';
        boolean b=false;
        for (int i = 1; i < n; i++) {
            if(isOverlap(i-1, i, p)){
                if(ans[i-1]=='C'){
                    if(b&&isOverlap(j, i, p)){
                        return "IMPOSSIBLE";
                    }
                    ans[i]='J';
                    b=true;
                    j=i;
                }
                else{
                    if(isOverlap(c, i, p)){
                        return "IMPOSSIBLE";
                    }
                   ans[i]='C';
                    c=i; 
                }
            }
            else{
                
                if(ans[i-1]=='C'){
                    ans[i]='C';
                    c=i;
                }
                else{
                    ans[i]='J';
                    j=i;
                }
            }
        }
        char res[]=new char[n];
        for (int i = 0; i < n; i++) {
            res[p[i].idx]=ans[i];
        }
        String r=new String(res);
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Solution obj=new Solution();
        for (int q = 1; q<=t; q++) {
                String ans=obj.solve(br);
                sb.append("Case #"+q+": "+ans+"\n");
        }
        System.out.println(sb);
    }
}

