import java.io.*;
import java.util.*;

public class Solution {
    public static int find(int i,int j,int x,int y,String path,int k){
        if(i==x&&j==y) return 0;
        if(k==path.length()) return 100000;
        
        int count=100000;
        char c=path.charAt(k);
        if(c=='N'){
            y++;
        }
        else if(c=='S') y--;
        else if(c=='E') x++;
        else x--;
        
        count=Math.min(count,1+find(i,j,x,y,path,k+1));
        count=Math.min(count,1+find(i+1,j,x,y,path,k+1));
        count=Math.min(count,1+find(i,j+1,x,y,path,k+1));
        count=Math.min(count,1+find(i-1,j,x,y,path,k+1));
        count=Math.min(count,1+find(i,j-1,x,y,path,k+1));
        return count;
    }
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int t=1;t<=test;t++){
            String s[]=br.readLine().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            String path=s[2];
            int ans=find(0,0,x,y,path,0);
            if( ans!=100000)
            System.out.println("Case #"+t+": "+ans);
            else 
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
    }
}