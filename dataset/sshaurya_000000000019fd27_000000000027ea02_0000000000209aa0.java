import java.util.*;

class Solution{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int a=0;a<t;a++){
            boolean flag=false;
            String result="";
            int n=sc.nextInt();
            int k=sc.nextInt();
            for(int i=1;i<=n;i++){
                int sum=i*(n-1);
                
                for(int j=1;j<=n;j++){
                    if(j==i)
                        continue;
                    if(sum+j==k){
                        flag=true;
                        
                        break;
                    }
                }
                if(flag)
                break;
            }
            if(flag)
                System.out.println("Case #"+(a+1)+": IMPOSSIBLE");
            else
                System.out.println("Case #"+(a+1)+": POSSIBLE");
            
            
        }
    }
}