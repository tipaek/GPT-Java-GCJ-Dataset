
import java.util.*;
import java.lang.*;
import java.io.*;

class Bomber {

    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        int[][] c=new int[3][3];
        int n;
        for(int k=0;k<t;k++)//Test Case
        {
    
        
        n=sc.nextInt();//Row Col
        int[][] arr= new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt(); //Input Matrix
            }
        }
        
        c[k][0]=0;
        int b=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    c[k][0]=c[k][0]+arr[i][j];//Diagonal Addition
                    
                }
            }
            
        }
        
        //Row repeat Calculation
        int d=0;
        c[k][1]=0;
        for(int i=0;i<n;i++)
        {
            int m=0;
            for(int j=0;j<n;j++)
            {
                b=arr[i][j];
                d=0;
                 for(int p=0;p<n;p++)
                 {
                     if(b==arr[i][p])
                     {
                         d++;
                        
                     }
                     
                     
                 }
                 if(d>1 && m==0)
                 {
                     m=1;
                     c[k][1]++;
                 }
            }
        }//exit for row
        
        //Col repeat cal
        d=0;
        c[k][2]=0;
        for(int i=0;i<n;i++)
        {
            int m=0;
            for(int j=0;j<n;j++)
            {
                b=arr[j][i];
                d=0;
                 for(int p=0;p<n;p++)
                 {
                     if(b==arr[p][i])
                     {
                         d++;
                      }
                     
                 }
                 if(d>1 && m==0)
                 {
                     m=1;
                     c[k][2]++;
                 }
            }
        }//exit for col 
     System.out.print("Case #"+(k+1)+": ");
    for(int q=0;q<3;q++){
        //
        System.out.print(c[k][q]+" ");
        
    }
    System.out.println();
        
  }//k Loop   
 }//main
}//class
