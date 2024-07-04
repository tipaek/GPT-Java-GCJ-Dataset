import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tst=sc.nextInt();
        for(int t=1;t<=tst;t++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            String s=sc.next();
            if(x==0&&y==0){
                System.out.println("Case #"+t+": 0");
                continue;
            }
            int tpass=0;
            int flag=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='N'){
                    y=y+1;
                }else if(s.charAt(i)=='S'){
                    y=y-1;
                }else if(s.charAt(i)=='E'){
                    x=x+1;
                }else{
                    x=x-1;
                }
                tpass=tpass+1;
                int d=Math.abs(x)+Math.abs(y);
                if(d<=tpass){
                    flag=1;
                    System.out.println("Case #"+t+": "+tpass);
                    break;
                }
            }
            if(flag==0){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}