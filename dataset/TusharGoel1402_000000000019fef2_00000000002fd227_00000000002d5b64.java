import java.util.*;
class Solution{
   
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;++k){
            int r=sc.nextInt();
            int s=sc.nextInt();
            System.out.println("Case #"+k+": "+(r-1)*(s-1));
            long count=(r-1)*(s-1);
            long ans=(r)*(s-1);
            ans--;
            for(int i=r;i>1;--i){
                for(int j=1;j<s;++j){
                    System.out.println(i+" "+ans);
                    ans--;
                }
                
            }
        }
    
    }
}