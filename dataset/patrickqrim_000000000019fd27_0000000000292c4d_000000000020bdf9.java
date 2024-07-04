import java.io.*;
import java.util.*;
/**
 * Write a description of class Snail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Solution
{
    static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nn = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int n = 1; n <= nn; n++){
            int N = Integer.parseInt(br.readLine());
            String result = "";
            int cEndTime = 0;
            int jEndTime = 0;
            boolean bool = true;
            
            int[][] arr = new int[N][2];
            
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            
            sortbyColumn(arr, 0);

            for(int i = 0; i < N; i++){
                if(arr[i][0] >= cEndTime && !result.equals("IMPOSSIBLE")){
                    result += "C";
                    cEndTime = arr[i][1];
                }
                else if(arr[i][0] >= jEndTime && !result.equals("IMPOSSIBLE")){
                    result += "J";
                    jEndTime = arr[i][1];
                }
                else{
                    result = "IMPOSSIBLE";
                }
            }
            out.println("Case #" + n + ": " + result);
        }
        out.close();
    }
    
    static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
}
