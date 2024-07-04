import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int X=sc.nextInt();
            int Y=sc.nextInt();
            String M=sc.next();
            
            int n=M.length();
            int c=0;
            for(int i=0;i<n;i++){
                c++;
                if(M.charAt(i)=='S'){
                    Y--;
                }
                if(M.charAt(i)=='N'){
                    Y++;
                }
                if(M.charAt(i)=='W'){
                    X--;
                }
                if(M.charAt(i)=='E'){
                    X++;
                }
            }
            int m=Math.abs(X)+Math.abs(Y);
            if(n==m){
                System.out.println("Case #"+t+": "+n);
            }
            else if(n>m){
                System.out.println("Case #"+t+": "+(n-m));
            }
            else{
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}