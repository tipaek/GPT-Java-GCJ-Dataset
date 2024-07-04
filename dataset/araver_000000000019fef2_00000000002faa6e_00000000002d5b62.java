import java.io.*;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1BPA.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1BPA.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;
            String answer;
            int tests = Integer.parseInt(line);//80,100

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                p = line.split("\\s+");
                int x = Integer.parseInt(p[0]);//+/- 10^9
                int y = Integer.parseInt(p[1]);//

                int max = Math.abs(x)+Math.abs(y);//max line

                if (max == 0){
                    //output
                    bw.write("Case #"+(i+1)+":\n");
                    bw.flush();
                    continue;
                }

                // 1+2+ ...+2^N = 2^(N+1)-1 >= max - 1
                int minSteps;

                //max+1 is power of 2
                boolean checkDirect = ((max+1 & max) == 0);

                minSteps = Integer.SIZE - Integer.numberOfLeadingZeros(max+1);

                //current move
                StringBuilder s = new StringBuilder(minSteps+1);

                if(checkDirect) minSteps--;

                int move = 1<<(minSteps-1);
                while(move > 0){
                    //greedy
                    int maxOf = Math.max(Math.abs(x), Math.abs(y));
                    if(maxOf == Math.abs(x)){
                        //go W/E
                        if(x>0){
                            s.append("E");
                            x-=move;
                        } else {
                            s.append("W");
                            x+=move;
                        }
                    } else {
                        //y, go N/S
                        if(y>0){
                            s.append("N");
                            y-=move;
                        } else {
                            s.append("S");
                            y+=move;
                        }
                    }
                    move>>=1;
                }

                if(x==0 && y==0){
                    answer = s.reverse().toString();
                } else {
                    answer = "IMPOSSIBLE";
                }

                //output
                bw.write("Case #"+(i+1)+": "+answer+"\n");
                bw.flush();
            }

            if(FROM_FILE) {
                bw.close();
            }
        } finally {
            if(FROM_FILE) {
                br.close();
            }
        }
    }
}
