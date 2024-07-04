import java.util.*;
class Solution{
   
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;++k){
            long r=sc.nextInt();
            long s=sc.nextInt();
            long count=(r-1)*(s-1);
            System.out.println("Case #"+k+": "+count);
            
            long ans=(r)*(s-1);
            ans--;
            for(long i=r;i>1;--i){
                for(long j=1;j<s;++j){
                    System.out.println(i+" "+ans);
                    ans--;
                }
                
            }
        }
    
    }
}