import java.io.*;
import java.util.Scanner;
class Main
{
    
    public static void main(String []args)throws IOException
    {
        int T,t; 
        int matrix[][]=new int[100][100];
        
        int N,i,j,search,p;
        
        //System.out.println("Enter the number of test cases T");
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        
        int trace[]=new int[T];
        int k[]=new int[T];
        int l[]=new int[T];
        
        for(t=0;t<T;t++)
        {
            //System.out.println("Enter the size of the matrix N");
            N=sc.nextInt();
            
            //System.out.println("Enter the values of matrix");
            for(i=0;i<N;i++) 
            {
                for(j=0;j<N;j++)
                {
                    matrix[i][j]=sc.nextInt();
                    
                }
                
            }//read matrix t
            
            //next find out the repeating rows count k
            k[t]=0;
            for(i=0;i<N;i++) 
            {   
                outer:
                for(p=0;p<N;p++)
                {
                    search=matrix[i][p]; //taking elements of each row
                    
                    for(j=p+1;j<N;j++)
                    {
                        if(matrix[i][j]==search) //comparing with all other elements of the same row
                        {
                            k[t]++;
                            break outer;
                        }
                    }
                }
            }
            
            //next find out the repeating coloumn count l
            l[t]=0;
            for(j=0;j<N;j++) 
            {
                outer:
                for(p=0;p<N;p++)
                {
                    search=matrix[p][j]; //taking first element of each coloumn
                    
                    for(i=p+1;i<N;i++)
                    {
                        if(matrix[i][j]==search) //comparing with all other elements of the same coloumn
                        {
                            l[t]++;
                            break outer;
                        }
                    }
                }
            }
            
            
            
            
            trace[t]=0;
            for(i=0;i<N;i++)
            {
                trace[t]+=matrix[i][i];
            }
        }
        sc.close();
        
        for(i=0;i<T;i++)
        {
            System.out.println("Case #"+(i+1)+": "+trace[i]+" "+k[i]+ " "+l[i]);

        }
        
        return;
    }
}