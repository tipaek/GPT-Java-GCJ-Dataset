
/**
 *
 * @author User
 */
import java.util.*;
public class Solution {
    
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        
        int testcases=scan.nextInt();
        ArrayList<String> resultCase=new ArrayList<>();
        for(int k=0;k<testcases;k++)
        {
            int length=scan.nextInt();
            int[][] matrix=new int[length][length];
            for(int i=0;i<length;i++)
            {
                for(int j=0;j<length;j++)
                {
                    matrix[i][j]=scan.nextInt();
                }
            }
            int tracesum=0;
            int rowsum=0;
            int colsum=0;
 
            for(int i=0;i<length;i++)
            {
               
                ArrayList<Integer> rowarr=new ArrayList<>();
                ArrayList<Integer> colarr=new ArrayList<>();
                for(int j=0;j<length;j++)
                {
                    if(i==j)
                    {
                        tracesum=tracesum+matrix[i][j];
                    }
                    rowarr.add(matrix[i][j]);
                    colarr.add(matrix[j][i]);
                }
                HashSet rowSet = new HashSet(rowarr);
                HashSet colSet=new HashSet (colarr);
                if(rowSet.size()!=length)
                {
                    rowsum+=1;
                }
                if(colSet.size()!=length)
                {
                    colsum+=1;
                }
                
            }
            String result="Case"+" "+"#"+Integer.toString(k+1)+":"+" "+Integer.toString(tracesum)+" "+Integer.toString(rowsum)+" "+Integer.toString(colsum);
            resultCase.add(result);
        }
            for(String ele:resultCase)
            {
                System.out.println(ele);
            }
           
            
        
        
    }
    
}
