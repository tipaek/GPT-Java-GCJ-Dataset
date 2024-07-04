import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] result = new int[t][3];
        if(t<1 || t>100){}
        else
        {
            for (int i = 1; i <= t; ++i)
            {
                int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.    
                if(n<2 || n>100){}
                else
                {
                    int[][] matrix = new int[n][n];
                    int nCount=0;
                    int mCount=0;
                    int nSum =0;
                    for(int j=0;j<n;j++)
                    {
                        
                        for(int k=0;k<n;k++)
                        {
                            
                            matrix[j][k] = in.nextInt();
                           
                           
                        }
                          
                    }
                        for(int j=0;j<n;j++){
                             HashMap<Integer,Integer> mMapCount = new HashMap<>();
                            HashMap<Integer,Integer> nMapCount = new HashMap<>();
                            int tempNCount=0;
                            int tempMCount=0;
                            for(int k=0;k<n;k++){
                                 if(mMapCount.containsKey(matrix[j][k])==false)
                            {
                                mMapCount.put(matrix[j][k],1);
                            }else
                            {
                                tempMCount++;
                            }
                            if(nMapCount.containsKey(matrix[k][j])==false)
                            {
                                nMapCount.put(matrix[k][j],1);
                            }else
                                {
                                tempNCount++;
                                }
                            }
                             if(tempNCount>0){
                                nCount++;
                                
                            }
                            if(tempMCount>0){
                                mCount++;
                              
                        }
                        nSum = nSum + matrix[j][j];
                    }
                    System.out.println("Case #"+i+": " + nSum + " " + mCount + " " + nCount);
                }
                
            }
        }
      }
    }