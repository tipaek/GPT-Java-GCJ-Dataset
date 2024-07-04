import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class InterfaceProg {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        test: for(int tt=1 ; tt<=t ; tt++) {
            int n = Integer.parseInt(br.readLine());

            int[][] schedule = new int[n][4];

            for(int i=0 ; i<n ; i++) {
                String[] input = br.readLine().split(" ");
                schedule[i][0] = Integer.parseInt(input[0]);
                schedule[i][1] = Integer.parseInt(input[1]);
                schedule[i][2] = i;
            }

            Arrays.sort(schedule, Comparator.comparingInt(o -> o[0]));

            int cameron = 0;
            int jamie = 0;
            StringBuilder sb = new StringBuilder();

            for(int i=0 ; i<n ; i++) {
                int from = schedule[i][0];
                int to = schedule[i][1];

                if(cameron<=from) {
                    schedule[i][3] = 0;
                    cameron = to;
                }
                else {
                    if(jamie<=from) {
                        schedule[i][3] = 1;
                        jamie = to;
                    }
                    else {
                        bw.write("Case #"+tt+": "+"IMPOSSIBLE"+"\n");
                        continue test;
                    }
                }
            }

            Arrays.sort(schedule, Comparator.comparingInt(o -> o[2]));

            for (int[] ints : schedule) {
                if (ints[3] == 0) sb.append('C');
                else sb.append('J');
            }

            bw.write("Case #"+tt+": "+sb.toString()+"\n");
        }

        bw.flush();
    }
}