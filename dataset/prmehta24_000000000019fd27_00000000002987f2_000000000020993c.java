import java.util.*; 
class Solution{
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        int testcases=Sc.nextInt();
        for(int i=0;i<testcases;i++)
        {
            int matrixsize=Sc.nextInt();
            int matrix[][]=new int[matrixsize][matrixsize];
            int samerows=0;
            int samecols=0;
            int trace=0;
            //add elements, calc trace
            for(int j=0;j<matrixsize;j++)
            {
                for(int k=0;k<matrixsize;k++)
                {
                    matrix[j][k]=Sc.nextInt();
                    if(j==k)
                    {
                        trace+=matrix[j][k];
                    }
                }
            }
            //count same rows
            for(int j=0;j<matrixsize;j++)
            {
                Set<Integer> rowvals = new HashSet<Integer>();
                for(int k=0;k<matrixsize;k++)
                {
                    int currentval=matrix[j][k];
                   if(rowvals.contains(currentval))
                   {
                       samerows++;
                       break;
                   }
                   else
                   {
                      rowvals.add(currentval); 
                   }
                }
            }
            //count same cols
            for(int j=0;j<matrixsize;j++)
            {
                Set<Integer> colvals = new HashSet<Integer>();
                for(int k=0;k<matrixsize;k++)
                {
                    int currentval=matrix[k][j];
                   if(colvals.contains(currentval))
                   {
                       samecols++;
                       break;
                   }
                   else
                   {
                      colvals.add(currentval); 
                   }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+samerows+" "+samecols);
            
        }
    }
}