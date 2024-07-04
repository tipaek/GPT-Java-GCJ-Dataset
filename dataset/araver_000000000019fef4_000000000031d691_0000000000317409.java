import java.io.*;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1CPA.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1CPA.out");
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
            int tests = Integer.parseInt(line);//100

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                p = line.split("\\s+");
                int x = Integer.parseInt(p[0]);//< 1000
                int y = Integer.parseInt(p[1]);//
                int xc = 0;
                int yc = 0;

                String m = p[2];
                int n = m.length();
                int j,moves = 0;
                boolean found=false;

                for(j = 0; j<n;j++){
                    if(xc == x && y == yc){
                        //here stay here
                        found = true;
                        break;
                    }

                    //compute nextMove
                    if(m.charAt(j) == 'S'){
                        y--;
                    } else if(m.charAt(j) == 'N'){
                        y++;
                    } else if(m.charAt(j) == 'E'){
                        x++;
                    } else {
                        x--;
                    }
                    if(Math.abs(x-xc) > Math.abs(y-yc)){
                        if(x>xc){
                            xc++;//moveE
                            //bw.write("E");
                        } else if(xc>x){
                            xc--;
                            //bw.write("W");
                        }
                    } else if(Math.abs(x-xc) < Math.abs(y-yc)){
                        if(y>yc){
                            yc++;//moveN
                            //bw.write("N");
                        } else if(y<yc){
                            yc--;
                            //bw.write("S");
                        }
                    } else {//equal distance
                        //peekahead one more move to decide
                        int xp = x, yp=y;
                        if(j+1<n){
                            if(m.charAt(j+1) == 'S'){
                                yp--;
                            } else if(m.charAt(j+1) == 'N'){
                                yp++;
                            } else if(m.charAt(j+1) == 'E'){
                                xp++;
                            } else {
                                xp--;
                            }
                        }//else no more moves impossible either way, stay here

                        if(xp == x && yp == yc){
                            //he comes here stay here
                        } else if(Math.abs(xp-xc) > Math.abs(yp-yc)){
                            if(xp>xc){
                                xc++;//moveE
                                //bw.write("E");
                            } else if(xc>xp){
                                xc--;
                                //bw.write("W");
                            }
                        } else if(Math.abs(xp-xc) < Math.abs(yp-yc)) {
                            if (yp > yc) {
                                yc++;//moveN
                                //bw.write("N");
                            } else if (yp < yc) {
                                yc--;
                                //bw.write("S");
                            }
                        }
                    }

                    moves++;
                }

                if(xc == x && y == yc){
                    //here stay here
                    found = true;
                }

                if(!found){
                        answer = "IMPOSSIBLE";
                } else{
                    answer = "" + moves;
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
