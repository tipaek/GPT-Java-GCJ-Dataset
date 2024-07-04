import java.util.*;
class Solution
{
    public void solution(int [][] matrix,int number)
    {
        int trace=0,row=0,col=0;
        int size = matrix[0].length;
        for(int i=0;i<size;++i)
        {
            trace+=matrix[i][i];
        }
        int sum = size*(size+1)/2;
        int [] rowsum= new int[size];
        int [] colsum=new int [size];
        for(int i =0;i<size;++i)
        {   
            for(int j=0;j<size;++j)
            {
                rowsum[j]=matrix[i][j];
                colsum[j]=matrix[j][i];
            }
            
            for(int k=1;k<size;++k)
            {
              if(rowsum[k]==rowsum[k-1])
                {row++;
                break;
                }
            }
          for(int k=1;k<size;++k)
            {
              if(colsum[k]==colsum[k-1])
                {col++;
                break;
                }
            }
        }
        System.out.println("Case #"+number+":"+trace+" "+row+" "+col);
    }
}
public class mainClass
{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcases = Integer.parseInt(sc.nextLine());
        int number = 1;
        while(testcases-- > 0)
        {
            int sq = Integer.parseInt(sc.nextLine());
            int [][] matrix = new int[sq][sq];
            
            for(int i =0;i<sq;++i)
            {
                String st  = sc.nextLine();
                String [] inp = st.split(" ");
                for(int j=0;j<sq;++j)
                {
                    matrix[i][j]=Integer.parseInt(inp[j]);
                }
                
            }
            
            Solution sol =  new Solution();
            sol.solution(matrix,number++);
        }
    }
}