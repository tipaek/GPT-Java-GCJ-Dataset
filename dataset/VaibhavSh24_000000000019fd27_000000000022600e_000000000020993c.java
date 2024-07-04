import java.util.*;

class Codejam
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        
        for (int t=0;t<testcase;t++)
        {
            int row=in.nextInt();
            int col=row;
            int arr[][]=new int[row][col];
            for (int i=0;i<row;i++)
            {
                for (int j=0;j<col;j++)
                {
                    arr[i][j]=in.nextInt();
                }
            }
            
            int sum=0;
            int r=0;
            int c=0;
        
            for (int i=0;i<row;i++)
            {
                int rowcount=0;
                
        
                for (int j=0;j<col;j++)
                {   
                    if(i==j)
                    {
                       sum=sum+arr[i][j];
                       
                    }
                    
                    int colcount=0;
                    
                    int temp=arr[i][j];
                    
                    if(rowcount==0)
                    {
                        for (int k=j+1;k<col;k++)
                        {
                            if(temp==arr[i][k])
                            {
                                row=row+1;
                                rowcount=1;
                                break;
                                
                            }
                        
                        }
                    }
                    if(colcount==0)
                    {
                        for (int k=i+1;k<row;k++)
                        {
                            if(temp==arr[i][k])
                            {
                                col=col+1;
                                colcount=1;
                                break;
                                
                            }
                        
                        }
                        
                    }
                    
                    
                    
                }
            }
            
            System.out.println("#"+(testcase+1)+" "+sum+" "+r+" "+c);
            
            
        }
        
    }
    
    
}