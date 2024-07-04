import java.lang.*;
import java.util.*;
class Solution
{
    public static void main(String args[]){
        int i,j,k;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(i=0;i<t;i++){
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            for(j=0;j<n;i++){
                for(k=0;k<n;k++){
                    mat[i][j]=Integer.parseInt(sc.next());
                }
            }
           // HashMap<Integer,Integer> hm1=new HashMap<Integer,Integer>();
            int sum=0,ctr1=0,ctr2=0,max1=0,max2=0;
            for(j=0;j<n;j++){
                        sum=sum+mat[j][j];
            }
            for(j=0;j<n;j++){
                for(k=0;k<n-1;k++){
                    if(mat[j][k]==mat[j][k+1])
                        ctr1++;
                    if(mat[k][j]==mat[k+1][j])
                        ctr2++;
                }
                if(max1<ctr1)
                    {
                        max1=ctr1;
                        ctr1=0;
                    }
                if(max2<ctr2)
                    {
                        max2=ctr2;
                        ctr2=0;
                    }
            }
            System.out.println(sum+" "+max1+" "+max2);
            
        }
    }
}