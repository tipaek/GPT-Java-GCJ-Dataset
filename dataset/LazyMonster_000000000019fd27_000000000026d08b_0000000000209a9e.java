import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ducbm
 */
public class Solution {

    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");

                int T = Integer.valueOf(tokens[0]);
                int B = Integer.valueOf(tokens[1]);

                for (int i = 0; i < T; i++) {

                    StringBuilder builder = new StringBuilder();
                    for (int j = 1; j <= B; j++) {
                        System.out.println(j);

                        line = reader.readLine();
                        builder.append(line);
                    }

                    System.out.println(builder.toString());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}