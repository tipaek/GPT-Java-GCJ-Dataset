import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int n=sc.nextInt();
            int[][] s=new int[n][2];
            
            int cs=0,ce=0,js=0,je=0;
            
            String sol="C";
            for(int i=0;i<n;i++) for(int j=0;j<2;j++) s[i][j]=sc.nextInt();
            
            cs=s[0][0];ce=s[0][1];
            for(int i=1;i<n;i++)
            {
                if(ce<=s[i][0])
                {
                    sol+="C";
                    cs=s[i][0];ce=s[i][1];
                }
                else if(cs>=s[i][1])
                {
                    sol+="C";   
                }
                
                else if(je<=s[i][0])
                {
                    sol+="J";
                    js=s[i][0];je=s[i][1];
                }
                else if(js>=s[i][1])
                {
                    sol+="J";
                }
                
            }
            if(sol.length()==n) System.out.println("Case #"+t+": "+sol);
            else System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
    }
}