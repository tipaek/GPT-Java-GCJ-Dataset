import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numCases = Integer.parseInt(br.readLine().trim());
            
            for (int i = 0; i < numCases; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int ranks = Integer.parseInt(st.nextToken());
                int suits = Integer.parseInt(st.nextToken());
                
                System.out.printf("Case #%d: %d%n", i + 1, (ranks - 1) * (suits - 1));
                System.out.print(generateOperations(ranks, suits));
            }
        }
    }

    private static String generateOperations(int ranks, int suits) {
        StringBuilder result = new StringBuilder();
        
        for (int i = ranks * (suits - 1); i > suits - 1; i--) {
            result.append(String.format("%d %d%n", i, (i - 1) / (suits - 1)));
        }
        
        return result.toString();
    }
}