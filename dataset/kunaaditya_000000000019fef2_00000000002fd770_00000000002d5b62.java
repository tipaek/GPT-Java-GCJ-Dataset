import java.io.*;
import java.util.*;

public class Solution {
    static String sol="";
    public static void solve(int x,int y,int p,int cx,int cy,String ans){
        if(Math.abs(x)<Math.abs(cx)||Math.abs(y)<Math.abs(cy))
            return;
        if(cx==x&&cy==y){
            if(sol==""){
                sol=ans;
                return;
            }
            else{
                if(sol.length()>ans.length()){
                    sol=ans;
                }
                return;
            }
        }
        solve(x,y,p+1,cx+(int)Math.pow(2,p),cy,ans+'E');
        solve(x,y,p+1,cx-(int)Math.pow(2,p),cy,ans+'W');
        solve(x,y,p+1,cx,cy+(int)Math.pow(2,p),ans+'N');
        solve(x,y,p+1,cx,cy-(int)Math.pow(2,p),ans+'S');
    } 
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        int c=1;
        while(T-->0){
            String[] str=br.readLine().split(" ");
            int x=Integer.parseInt(str[0]);
            int y=Integer.parseInt(str[1]);
            solve(x,y,0,0,0,"");
            if(sol!="")
            bw.write("Case #"+(c++)+": "+sol+"\n");
            else
            bw.write("Case #"+(c++)+": IMPOSSIBLE\n");
            sol="";
        }
        bw.flush();
    }
}