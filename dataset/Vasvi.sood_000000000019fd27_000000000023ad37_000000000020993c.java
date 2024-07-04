
import java.util.Scanner;
class mno{
     public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         int t=in.nextInt();
         for(int k=1;k<=t;k++)
         {
        	 int i,j,l;
           int n=in.nextInt(); 
           int diag=0,r=0,c=0;
           int[][] arr=new int[n][n];
           for( i=0;i<n;i++)
           for( j=0;j<n;j++)
          arr[i][j]=in.nextInt();
           for( l=0;l<n;l++)
           diag=diag+arr[l][l];
            for(i=0;i<n;i++){
           for(j=0;j<n;j++){
           for( l=j+1;l<n;l++){
           if(arr[i][j]==arr[i][l]){
          r++;
          j=n;
           l=n+1;
           }
           }
           
           }
           
          
         
            }
           
            
             for(j=0;j<n;j++){
           for(i=0;i<n;i++){
           for( l=i+1;l<n;l++){
           if(arr[i][j]==arr[l][j]){
          c++;
           l=n+1;
           i=n;
           }
           }
           
           }
          
          
            }
            System.out.println("Case #"+k+": "+diag+" "+
            r+" "+c);
          
         }
     }
}