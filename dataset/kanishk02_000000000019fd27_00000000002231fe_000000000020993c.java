import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {   
            int n=sc.nextInt();
            int[][] mat=new int[n][n];
            for(int i=0;i<n;i++) for(int j=0;j<n;j++) mat[i][j]=sc.nextInt();
            
            int rcount=0,ccount=0,trace=0;
            boolean flagr=true,flagc=true;
            for(int i=0;i<n;i++){
                flagr=true;flagc=true;
                for(int j=0;j<n-1;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(mat[i][j]==mat[i][k] && flagr){ rcount++; flagr=false;}
                        if(mat[j][i]==mat[k][i] && flagc){ ccount++; flagc=false;}
                    }
                }
                trace+=mat[i][i];
            }
            
            System.out.println("Case #"+t+": "+trace+" "+rcount+" "+ccount);
            
        }
    }
}
