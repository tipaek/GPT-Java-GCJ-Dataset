import java.util.*;
class Sample{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int  n,sum=0;
        System.out.println("Enter the number of rows");
        n = sc.nextInt();
        System.out.println("Enter the number of colums");
        n = sc.nextInt();
        int[][] mat = new int[n][n];
        System.out.println("Enter the elements of the matrix");
        for(int i=0;i<n;i++)
        {
         for(int j=0;j<n;j++)
         {
             mat[i][j]=sc.nextInt();
         }
        }
       System.out.println("The element of the matrix");
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               System.out.print(mat[i][j]+"\t");
           }  
             System.out.println("");
       }   
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<n;j++)
            {
        if(i==j)
        {
        sum = sum +mat[i][j];
        }
        }
            }
        System.out.println(sum);    
         
         int count=0;
       for(int i=0;i<n;i++)
       {
           if(mat[i][i]==mat[i][i])
           count++;
         for(int j=0;j<n;j++)
         {
             if(mat[j][j]==mat[j][j])
             count++;
         }
       }
        System.out.println(count);       
         
       
    }
    
}