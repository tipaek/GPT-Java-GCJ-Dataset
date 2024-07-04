import java.util.*;
import java.io.*;
class Vestigium
{
public static void main(String as[])
{
     Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int mat[][];
    int result[][];
    int cases=0;
    int size=0;
    
    cases=scan.nextInt();
    result=new int[cases][3];
    for(int p=0;p<cases;p++)
    {
        int sum=0;
        int repC=0;
        int repR=0;
        boolean rowS=false,colS=false;
        // int sum=0;
        size=scan.nextInt();
        mat=new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                mat[i][j]=scan.nextInt();
                if(i==j)
                    sum=sum+mat[i][j];
                
            }
            
        }
    for(int x=0;x<size;x++)
    {
        
        for(int i=0;i<size;i++)
        {
            
            for(int j=i+1;j<size;j++)
            {
            
                if(mat[x][i]==mat[x][j])
                {
            
                    rowS=true;
                   
                }
                if(mat[i][x]==mat[j][x])
                {
                  
                    colS=true;
                
                }
                
            }
           
        }
         if(rowS==true)
            {
              
                rowS=false;
                repR++;

            }
             if(colS==true)
            {
               
                colS=false;
                repC++;

            }
    }
    result[p][0]=sum;
    result[p][1]=repR;
    result[p][2]=repC;
        
    }
    int cn=1;
    for(int[] z:result)
    {
        System.out.print("Case #"+cn+": ");
        for(int q:z)
        {
            System.out.print(q+" ");
        }
        System.out.println();
        cn++;
    }

    
}
}