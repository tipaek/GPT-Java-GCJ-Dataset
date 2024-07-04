import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int testCases = Integer.parseInt(str.nextToken());
        int no = 1;
        while(testCases > 0) {
            
            int x = br.readLine();
            
            int arr[][] = new int[x][x];
            
            for(int i=0; i<x; i++) {
                str = new StringTokenizer(br.readLine());
                
                for(int j=0; j<x;j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());    
                }
                
            }
            
            int trace = 0;
            int colRepeated = 0;
            int rowRepeated = 0;
            
            for(int i = 0; i<x; i++){
              trace =+ arr[i][i];
              int rows[] = new int[101];
              int cols[] = new int[101];
              for(int j=0;j<x;j++) {
                
                if(rows[arr[x][j]]>0) {
                    rowRepeated++;
                    break;
                }          
                   rows[arr[x][j]] ++; 
              }
              for(int j=0;j<x;j++) {
                
                if(cols[arr[x][j]]>0) {
                    colRepeated++;
                    break;
                }          
                   cols[arr[x][j]] ++; 
              }
            }
            
            System.out.println("Case #"+no+": "+trace+" "+rowRepeated+" "+colRepeated);
            no++;
            
            
        }
    
    }

}