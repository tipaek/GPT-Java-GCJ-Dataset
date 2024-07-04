import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                br.readLine(); // Read and discard the "d" input

                ArrayList<Integer> temp = new ArrayList<>();
                int count = 1;

                for (int j = 0; j < B; j++) {
                    if (count % 10 == 1) {
                        j--; // Skip this iteration but do not increment j
                    } else {
                        bw.write(String.valueOf(j));
                        bw.flush();
                        temp.add(Integer.parseInt(br.readLine()));
                    }
                    count++;
                }

                StringBuilder result = new StringBuilder();
                for (int value : temp) {
                    result.append(value);
                }

                bw.write(result.toString());
                bw.flush();

                if ("N".equals(br.readLine())) {
                    break;
                }
            }
        }
    }
}