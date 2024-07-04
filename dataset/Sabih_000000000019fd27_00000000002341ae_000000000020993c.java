import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int mat[][] = new int[n][n];
            
            for(int j=0;j<n;j++){
                String input = br.readLine();
                String f[] = input.split(" ");
                for(int k=0;k<n;k++){
                    int num = Integer.parseInt(f[k]);
                    mat[j][k] = num;
                }
            }
            
            int trace = 0,r = 0 ,c = 0;
            //Get trace
            for(int j=0;j<n;j++){
                List<Integer> repeatedRows = new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(j==k)
                    {
                        trace+=mat[j][k];
                    }
                    
                    //Check rows
                    // System.out.println("Rows " +repeatedRows);
                    if(repeatedRows.contains(mat[j][k])){
                        r = j+1;
                    }
                    else if(!repeatedRows.contains(mat[j][k])){
                        repeatedRows.add(mat[j][k]);
                    }
                    
                    //Check columns
                    // System.out.println("Colums "+repeatedRows);
                    
                    // if(repeatedColumns.contains(mat[k][j])){
                    //     c=k+1;
                    // }
                    // else if(!repeatedColumns.contains(mat[k][j])){
                    //     repeatedColumns.add(mat[k][j]);
                    // }
                }
            }

            List<Integer> columnNo = new ArrayList<>();
            for(int k=0;k<n;k++){
                List<Integer> repeatedColumns = new ArrayList<>();
                for(int j=0;j<n;j++){
                    
                    //Check columns
                        // System.out.println("Colums "+repeatedRows);
                        
                    if(repeatedColumns.contains(mat[j][k])){
                        // System.out.println("c = "+c);
                        columnNo.add(k);
                    }
                    else if(!repeatedColumns.contains(mat[j][k])){
                        repeatedColumns.add(mat[j][k]);
                    }
                }
            }
            
            LinkedHashSet<Integer> num = new LinkedHashSet(columnNo);
            // System.out.println(num);
            c = num.size();
            
            //Print solution
            System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
            
        }
    }
}