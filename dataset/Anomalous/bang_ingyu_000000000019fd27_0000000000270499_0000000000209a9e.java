import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int T = parseStringToInt(st.nextToken());
            int B = parseStringToInt(st.nextToken());
            int attempt;

            for (int i = 1; i <= T; i++) {
                attempt = 1;
                if (B == 10) {
                    while (attempt <= 140) {
                        bw.write("1");
                        bw.flush();
                        br.readLine();
                        attempt++;
                    }

                    for (int j = 1; j <= 10; j++) {
                        bw.write(String.valueOf(j));
                        bw.flush();
                        sb.append(parseStringToInt(br.readLine()));
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    sb.setLength(0);
                } else {
                    while (attempt <= 150) {
                        bw.write("1");
                        bw.flush();
                        br.readLine();
                        attempt++;
                    }

                    for (int j = 1; j <= B; j++) {
                        sb.append(0);
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    sb.setLength(0);
                }

                if (br.readLine().equals("N")) {
                    break;
                }
            }
        }
    }
}