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
            String y = "C";
            List<Integer> a = new ArrayList<>();
            int N = Integer.parseInt(in.readLine());
            String[] add = { "C", "J" };
            int[][] arr = new int[N][2];
            int k = 0;
            for(int i = 0; i < 1441; i++) { a.add(0); }
            for(int j = 0; j < N; j++){
                input = new StringTokenizer(in.readLine());
                arr[j][0] = Integer.parseInt(input.nextToken());
                arr[j][1] = Integer.parseInt(input.nextToken());
                for(int i = arr[j][0]; i < arr[j][1]; i++){
                    a.set(i, a.get(i)+1);
                }
            }
            sortbyColumn(arr, 0);
            
            boolean toggle = false;
            for(int i = 1; i < N; i++){
                if(a.get(arr[i][0]) > a.get(arr[i-1][1])){
                    k++;
                }
                y+=add[k%2];
            }
            for(int q : a){
                if(q >= 3) {
                    y = "IMPOSSIBLE";
                    break;
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