
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());
        int ii = 1;
        while (not-- != 0) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            int count = (r - 1) * (s - 1);
            System.out.println("Case #"+ii+": "+count);
            int start = r * (s - 1);
            for (int i = r - 1; i > 0; i--) {
                for (int j = s - 1; j > 0; j--) {
                    System.out.println(start + " " + i);
                    start--;
                }
            }
            ii++;
        }
    }
}