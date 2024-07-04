import java.io.*;
import java.util.*;

public class Solution {
    static String name = "p";
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new FileReader(name + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name + ".out")));
        StringTokenizer input;

        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String y = "";
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[N][3];
            String[] ans = new String[N];
            for(int j = 0; j < N; j++){
                input = new StringTokenizer(in.readLine());
                arr[j][0] = Integer.parseInt(input.nextToken());
                arr[j][1] = Integer.parseInt(input.nextToken());
                arr[j][2] = j;
            }
            sortbyColumn(arr, 0);
            boolean possible = true;
            int cEnd = 0;
            int jEnd = 0;
            for(int i = 0; i < N; i++){
                if(arr[i][0] >= cEnd && possible){
                    ans[arr[i][2]] = "C";
                    cEnd = arr[i][1];
                }
                else if(arr[i][0] >= jEnd && possible){
                    ans[arr[i][2]] = "J";
                    jEnd = arr[i][1];
                } else{
                    y = "IMPOSSIBLE"; possible = false;
                }
            }
            //out.println("aasdf");
            //out.println(Arrays.toString(ans));
            if(possible){
                for(int i = 0; i < arr.length; i++){
                    y+=ans[i];
                }
            }
            out.println("Case #" + x + ": " + y);
            //out.println(Arrays.toString(a.toArray()));
        }
        out.close();
    }

    public static void sortbyColumn(int arr[][], int col) 
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