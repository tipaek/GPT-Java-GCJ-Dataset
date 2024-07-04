import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[][] answer = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int temp[][] = new int[n][n];

            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);

                for (int k = 0; k < n; k++) {
                    temp[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < n; j++) {
                answer[i][0] = answer[i][0] + temp[j][j];
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[j][k] - 1] == true) {
                        answer[i][1]++;
                        break;
                    }
                    check[temp[j][k] - 1] = true;
                }
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[k][j] - 1] == true) {
                        answer[i][2]++;
                        break;
                    }
                    check[temp[k][j] - 1] = true;
                }
            }
        }

        br.close();

        for (int i = 0; i < t; i++) {
            bw.write("Case #" + (i+1) + ": " + String.valueOf(answer[i][0]) + " " + answer[i][1] + " " + answer[i][2] + " " + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}