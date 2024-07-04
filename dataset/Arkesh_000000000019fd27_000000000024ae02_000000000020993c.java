import java.util.*;

class Solution{
    
    public static void main(String args[]){
    Scanner scr = new Scanner(System.in);
    
        int T = scr.nextInt();
        if(T<1 || T>100)
            return;
        
        for(int i=0;i<T;i++)
        {
            int N = scr.nextInt();
            if(N<2 || N>100)
                return;
            int sum = 0,row_count=0,col_count=0;
            Integer M[][] = new Integer[N][N];
               
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                     M[j][k] = scr.nextInt();
                    if(M[j][k]<1 || M[j][k]>N)
                        return;
                        
                    if(j==k)
                    {
                        sum+=M[j][k];
                    }
                }
            }

            int prev_row_count = row_count;
            //for common in row
            for(int p=0;p<N;p++)
            {
 
                for(int q=0;q<N-1;q++)
                {
                	prev_row_count = row_count;
                    for(int r=q+1;r<N;r++)
                    {
                        if(M[p][q]==M[p][r])
                        {
                            row_count++;
                            break;
                        }
                    }

                    if(prev_row_count != row_count)
                    	break;
                }
            }
            
       		
       		int prev_col_count = col_count;
            //for common in col
            for(int p=0;p<N;p++)
            {             
                for(int q=0;q<N-1;q++)
                {
                	prev_col_count = col_count;
                    for(int r=q+1;r<N;r++)
                    {
                        if(M[q][p]==M[r][p])
                        {
                            col_count++;
                            break;
                        }
                    }
                    if(prev_col_count!=col_count)
                    	break;
                 }
            }
            
        
        //printing the output
        System.out.println("Case #"+(i+1)+": "+sum+" "+row_count+" "+col_count);
            
        }
        
    }
    
}
