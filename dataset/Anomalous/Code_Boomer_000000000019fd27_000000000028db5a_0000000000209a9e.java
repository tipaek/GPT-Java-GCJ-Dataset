import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
             
            int T = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < T; i++) {
                br.readLine();  // Read and ignore this line
                
                ArrayList<Integer> temp = new ArrayList<>();
                int count = 1;
                
                for (int j = 0; j < B; j++) {
                    if (count % 10 == 1) {
                        j--;
                    } else {
                        bw.write(String.valueOf(j));
                        bw.flush();
                        temp.add(Integer.parseInt(br.readLine()));
                    }
                    count++;
                }
                
                StringBuilder r = new StringBuilder();
                for (int num : temp) {
                    r.append(num);
                }
                
                bw.write(r.toString());
                bw.flush();
                
                String check = br.readLine();
                if ("N".equals(check)) {
                    break;
                }
            }
        }
    }
}