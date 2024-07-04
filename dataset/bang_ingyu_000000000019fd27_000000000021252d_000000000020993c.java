import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st;

        int T = stoi(br.readLine());

        for(int i = 1; i <= T; i++){
            sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i);
            sb.append(": ");

            int N = stoi(br.readLine());
            int[][] input = new int[N][N];
            int trace = 0;
            int row = 0;
            int col = 0;

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    int now = stoi(st.nextToken());
                    input[j][k] = now;
                    if(j==k){
                        trace+=now;
                    }
                }
            }

            for(int j = 0; j < N; j++){
                int[] test = new int[N];
                for(int k = 0; k < N; k++){
                    int now = input[j][k];
                    if(test[now - 1] == 0){
                        test[now -1]++;
                    } else {
                        row++;
                        break;
                    }
                }
            }

            for(int j = 0; j < N; j++){
                int[] test = new int[N];
                for(int k = 0; k < N; k++){
                    int now = input[k][j];
                    if(test[now - 1] == 0){
                        test[now -1]++;
                    } else {
                        col++;
                        break;
                    }
                }
            }

            sb.append(trace);
            sb.append(" ");
            sb.append(row);
            sb.append(" ");
            sb.append(col);
            sb.append("\n");

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();

        
    }
}