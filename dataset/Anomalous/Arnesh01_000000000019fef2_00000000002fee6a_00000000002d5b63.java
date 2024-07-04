import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        
        for (int testCase = 1; testCase <= T; testCase++) {
            boolean found = false;
            for (int i = -5; !found && i <= 5; i++) {
                for (int j = -5; !found && j <= 5; j++) {
                    System.out.println(i + " " + j);
                    System.out.flush();
                    String response = br.readLine();
                    if (response != null && response.length() == 6) {
                        found = true;
                    }
                }
            }
        }
    }
}