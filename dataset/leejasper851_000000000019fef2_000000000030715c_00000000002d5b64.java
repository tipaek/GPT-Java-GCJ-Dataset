import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int numRanks = Integer.parseInt(st.nextToken());
            int numSuits = Integer.parseInt(st.nextToken());
            
            ArrayList<String> moves = new ArrayList<>();
            for (int j = numRanks; j >= 2; j--) {
                for (int i = numSuits - 1; i >= 0; i--) {
                    moves.add(j * i + " " + (j - 1));
                }
            }
            writer.println("Case #" + caseN + ": " + moves.size());
            for (String move : moves) {
                writer.println(move);
            }
        }
        reader.close();
        writer.close();
    }
    
    private static void swap(ArrayList<Integer> arr, int ind, int num) {
        for (int i = 0; i < num; i++) {
            int val = arr.remove(ind);
            arr.add(0, val);
        }
    }
}