import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numCases; i++) {
            int arraySize = Integer.parseInt(reader.readLine());
            int[][] vestArray = new int[arraySize][arraySize];
            int trace = 0;
            
            // Read array and calculate trace
            for (int x = 0; x < arraySize; x++) {
                String[] row = reader.readLine().split(" ");
                for (int y = 0; y < arraySize; y++) {
                    vestArray[x][y] = Integer.parseInt(row[y]);
                    if (x == y) {
                        trace += vestArray[x][y];
                    }
                }
            }
            
            int dupeCount = 0;
            int[] dupeChecker = new int[arraySize];
            
            // Additional functionality can be added here if needed
        }
    }
}