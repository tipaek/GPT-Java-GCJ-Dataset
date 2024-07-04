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
            
            int N=0,S=0,E=0,W=0;
            for(int i=0;i<n;i++){
                if(M.charAt(i)=='S') {
                    S++;
                }
                else if(M.charAt(i)=='N'){
                    N++;
                }
                else if(M.charAt(i)=='W'){
                    W++;
                }
                else if(M.charAt(i)=='E'){
                    E++;
                }
            }
            
            for(int i=0;i<n;i++){
                c++;
                //System.out.println(X+" "+Y);
                if(M.charAt(i)=='S' && X==0 && Y>1) {
                    Y-=2;
                }
                else if(M.charAt(i)=='S' && X==0 && Y==1) {
                    Y--;
                }
                else if(M.charAt(i)=='S' && X>0 && E<Y){
                    Y--;
                    X--;
                }
                else if(M.charAt(i)=='S' && X>0 && E>Y && Y>1){
                    Y-=2;
                }
                else if(M.charAt(i)=='S' && X>0 && E>Y && Y==1){
                    Y--;
                }
                if(M.charAt(i)=='W'){
                    X--;
                }
                if(M.charAt(i)=='E'){
                    X++;
                }
                if(X==0 && Y==0){
                    break;
                }
            }
            int m=Math.abs(X)+Math.abs(Y);
            if(n==m){
                System.out.println("Case #"+t+": "+c);
            }
            else if(n>m){
                System.out.println("Case #"+t+": "+(c));
            }
            else{
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}