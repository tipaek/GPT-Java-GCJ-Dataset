import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int n=sc.nextInt();
            
            int cs=0,ce=0,js=0,je=0;
            
            int[][] a=new int[n][3];
            
            String sol=""; String fsol="";
            
            for(int i=0;i<n;i++){ 
                a[i][0]=i;
                a[i][1]=sc.nextInt();
                a[i][2]=sc.nextInt();
            }
            
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(a[i][1]>a[j][1])
                    {
                        int temp=0;
                        temp=a[i][0];
                        a[i][0]=a[j][0];
                        a[j][0]=temp;
                        
                        temp=a[i][1];
                        a[i][1]=a[j][1];
                        a[j][1]=temp;
                        
                        temp=a[i][2];
                        a[i][2]=a[j][2];
                        a[j][2]=temp;
                    }
                }
            }
            
            for(int i=0;i<n;i++)
            {
                if(ce<=a[i][1] || cs>=a[i][2])
                {
                    sol+="C";
                    cs=a[i][1];ce=a[i][2];
                }
                
                
                else if(je<=a[i][1] || js>=a[i][2])
                {
                    sol+="J";
                    js=a[i][1];je=a[i][2];
                }
                
                
            }
            
            if(sol.length()==n){
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[j][0]==i)fsol+=sol.charAt(j);
                }
            }
             System.out.println("Case #"+t+": "+fsol);}
            else System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
    }
}