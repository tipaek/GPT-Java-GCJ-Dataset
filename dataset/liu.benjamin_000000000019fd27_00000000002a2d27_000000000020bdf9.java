import java.io.*;
import java.util.*;

public class Solution {
    static String name = "p";
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //BufferedReader in = new BufferedReader(new FileReader(name + ".in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name + ".out")));

        StringTokenizer input;

        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String y = "";
            List<Integer> a = new ArrayList<>();
            int N = Integer.parseInt(in.readLine());
            String[] add = { "C", "J" };
            int[][] arr = new int[N][2];
            int k = 0;
            List<String> L = new ArrayList<>();
            for(int i = 0; i < 1441; i++) { a.add(0); }
            for(int j = 0; j < N; j++){
                input = new StringTokenizer(in.readLine());
                arr[j][0] = Integer.parseInt(input.nextToken());
                L.add("" + arr[j][0]);
                arr[j][1] = Integer.parseInt(input.nextToken());
                for(int i = arr[j][0]; i < arr[j][1]; i++){
                    a.set(i, a.get(i)+1);
                }
            }
            sortbyColumn(arr, 0);
            boolean possible = true;
            int cEnd = 0;
            int jEnd = 0;
            for(int q : a){
                if(q >= 3) {
                    y = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }
            for(int i = 0; i < N; i++){
                if(arr[i][0] >= cEnd && possible){
                    L.set(L.indexOf("" + arr[i][0]), "C");
                    //y += "C";
                    cEnd = arr[i][1];
                }
                else if(arr[i][0] >= jEnd && possible){
                    L.set(L.indexOf("" + arr[i][0]), "J");
                    //y += "J";
                    jEnd = arr[i][1];
                }
            }
            //out.println(Arrays.toString(L.toArray()));
            if(possible){y = "";
                for(int i = 0; i < L.size(); i++){
                    y += L.get(i);
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