import java.util.*;

class Solution
{
    
    
    public static void main(String args[]){
        
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        
        for(int z=1;z<=t;z++){
            int n=in.nextInt();
            boolean flag=false;
            String s="";
            
            int c_free=0,j_free=0;
            
            int ar[][]=new int[n][2];
            for(int i=0;i<n;i++){
                ar[i][0]=in.nextInt();
                ar[i][1]=in.nextInt();
            }
            
            Arrays.sort(ar, (a, b) -> Integer.compare(a[1], b[1]));
            
            
            for(int i=0;i<n;i++){
             int x=ar[i][0];
             int y=ar[i][1];
             
             if(c_free<=x){
                 s+="C";
                 c_free=y;
             }
            else if(j_free<=x){
                s+="J";
                j_free=y;
            }    
            else {
                flag=true;
            }
            }
            
            
            
            
            
            
            
            if(flag)
            s="IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n",z,s);
        }
        
    }
    
    
    
}