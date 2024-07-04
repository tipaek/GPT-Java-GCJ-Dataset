import java.io.*;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;
    public static final int MAX = 1000000000;

    public static int center(int[] cx, int n){
        long center = 0;
        for (int i = 0; i < n;i++){
            center+=cx[i];
        }

        center = center / n;
        return (int) center;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1BPB.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1BPB.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p = line.split("\\s+");
            int tests = Integer.parseInt(p[0]);
            int a = Integer.parseInt(p[1]);
            int b = Integer.parseInt(p[2]);

            for(int i = 0; i < tests; i++){
                //split board for a matrix

                int foundPoints = 0;
                // -MAX < X < =MAX
                int x = - MAX;
                int y = - MAX;
                int density = (MAX - 5)/2;
                int [] cx = new int[1000];
                int [] cy = new int[1000];
                boolean finishedTable = false;

                for(int c = 0; c < 300; c++){
                    if(!finishedTable){
                        //next move
                        x+= density;
                        if(x>MAX){
                            //go up
                            x = - MAX + density;
                            y += density;
                        }

                        if(y>MAX){//out of table!!
                            finishedTable = true;
                            //throw new RuntimeException("Should have found them by now");
                        }
                    }

                    if(finishedTable){
                        //start centering
                        x = center(cx, foundPoints);
                        y = center(cy, foundPoints);
                    }

                    //output
                    bw.write(""+x+" "+y+"\n");
                    bw.flush();

                    line = br.readLine().toUpperCase();
                    if(line.startsWith("CENTER")){
                        c = 300;//break, done
                    } else if (line.startsWith("HIT")){
                        //TODO
                        //skip hits?
                    } else if (line.startsWith("MISS")){
                        foundPoints++;
                        cx[foundPoints] = x;
                        cx[foundPoints] = y;
                    } else if (line.startsWith("WRONG")){
                        throw new RuntimeException("Should not be!");
                    }
                }
                //next test
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
