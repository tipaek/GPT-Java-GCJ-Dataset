import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int X=sc.nextInt();
            int Y=sc.nextInt();
            String M=sc.next();
            
            int n=M.length();
            int c=0;
            int a=0,b=0;
            /*int s=0,n=0,w=0,e=0;
            for(int i=0;i<n;i++){
                if(M.charAt(i)=='S'){
                    s++;
                }
                else if(M.charAt(i)=='N'){
                    n++;
                }
                else if(M.charAt(i)=='W'){
                    w++;
                }
                else if(M.charAt(i)=='E'){
                    e++;
                }
            }*/
            boolean flag=false;
            for(int i=0;i<n;i++){
                c++;
                if(M.charAt(i)=='S'){
                    Y--;
                }
                else if(M.charAt(i)=='N'){
                    Y++;
                }
                else if(M.charAt(i)=='W'){
                    X--;
                }
                else if(M.charAt(i)=='E'){
                    X++;
                }
                
                if(X>1 && (X-a)>(Y-b)){
                    a++;
                }
                else if(Y>1 && (X-a)<(Y-b)){
                    b++;
                }
                else if((X-a)==1 && X>b){
                    b++;
                }
                else if((X-a)==1 && X>b){
                    b--;
                }
                if(X==a && Y==b){
                    flag=true;
                    break;
                }
            }
            //int m=Math.abs(X)+Math.abs(Y);
            if(flag){
                System.out.println("Case #"+t+": "+c);
            }
            //else if(n>m){
            //    System.out.println("Case #"+t+": "+(n-m));
            //}
            else{
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}