import java.util.*;
class Solution{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++){
            int n=sc.nextInt();
            int b=sc.nextInt();
            if(n*(n-1)>=b){
                System.out.println("Case #"+i+": POSSIBLE");
            }
            else
            System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}