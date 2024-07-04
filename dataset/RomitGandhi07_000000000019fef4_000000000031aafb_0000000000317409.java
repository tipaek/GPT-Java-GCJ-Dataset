import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;++z){
            int x=sc.nextInt();
            int y=sc.nextInt();
            String s=sc.next();
            String ans="a";
            int l=s.length();
            int temp=0;
            boolean flag=false;
            if(x==0 && y==0){
                flag=true;
                ans="0";
            }
            if(!flag){
            for(int i=0;i<l;++i){
                if(s.charAt(i)=='S'){
                    --y;
                }
                else if(s.charAt(i)=='N'){
                    ++y;
                }
                else if(s.charAt(i)=='E'){
                    ++x;
                }
                else{
                    --x;
                }
                temp=Math.abs(x)+Math.abs(y);
                if(temp<=(i+1)){
                        ans=String.valueOf(i+1);
                        flag=true;
                        break;
                }
            }}
            if(!flag){
                ans="IMPOSSIBLE";
            }
            System.out.println("Case #"+z+": "+ans);
        }
    }
}