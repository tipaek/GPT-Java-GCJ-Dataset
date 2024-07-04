import java.utit.*;

class Solution{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int k=0;k<t;k++){
            boolean flag=false;
            String result="";
            int n=sc.nextInt();
            int k=sc.nextInt();
            for(int i=1;i<=n;i++){
                int sum=0;
                sum*=i;
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
                System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
            else
                System.out.println("Case #"+(k+1)+": POSSIBLE");
            
            
        }
    }
}