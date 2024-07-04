import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        
        for (int t = 1; t <= T; t++) {
            int[] arr = new int[B];
            int index = 1;

            for (int count = 1; index <= B; count++) {
                if (count % 10 == 1) {
                    System.out.println("1");
                    System.out.flush();
                    br.readLine(); // Read and discard the response
                } else {
                    System.out.println(index);
                    System.out.flush();
                    int value = br.readLine().charAt(0) - '0';
                    arr[index - 1] = value;
                    index++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < B; i++) {
                result.append(arr[i]);
            }
            System.out.println(result);
            System.out.flush();
            
            char response = br.readLine().charAt(0);
            if (response == 'N') {
                break;
            }
        }
    }
}