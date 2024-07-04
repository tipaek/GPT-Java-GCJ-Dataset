import java.util.*;
class Test{
    public int sum(int[][] m, int n){
        int su=0;
        for(int l=0;l<n;l++){
            su=su+m[l][l]; 
        }
        return su;
    }
   
    public int row_count(int[][] m, int n){
        int count=0;
        for(int l=0;l<n;l++){
            int temp=0;
            for(int v=0;v<l;v++){
                int p=0;
                while(p<n){
                    if(m[l][v]==m[l][p]){
                    temp=1;
                    break;    
                }
                p++;
                }
                if(temp==1){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static int col_count(int[][] m, int n){
        int count=0;
        for(int l=0;l<n;l++){
            int temp=0;
            for(int v=0;v<l;v++){
                int p=0;                
                while(p<n){
                    if(m[v][l]==m[p][l]){
                    temp=1;
                    break;    
                    // p++;
                }
                p++;
                }
                if(temp==1){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    // int col_count(int [][] m, int n){
    //     int count=0;
    //     for(int l=0;l<n;l++){
    //         int p=0;
    //         int temp=0;
    //         for(int v=0;v<l;v++){
    //             while(p<n){
    //                 if(m[v][l]==m[p][l]){
    //                 temp=1;
    //                 break;    
    //                 p++;
    //                 }
    //             }
    //             if(temp==1){
    //                 count++;
    //                 break;
    //             }
    //         }
    //     }
    //     return count;
    // }
}
class Tester
{
    public static void main(String args[])
    {
       Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int n;
        Test obj=new Test();
        for(int i=1;i<=T;i++)
        {
            n=s.nextInt();
            int m[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    m[i][k]=s.nextInt();
                }
            }
            int x= i;
            int k=obj.sum(m,n);
            int p1=obj.row_count(m,n);
            int p2=obj.col_count(m,n);
             System.out.println("Case #"+x+":"+k+" "+p1+" "+p2);
            // System.out.println("Case #"+x+":"+" "+k+" "+r+" ");
            

        }
    }
     
}