import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1CPC.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1CPC.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;
            int tests = Integer.parseInt(line);

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                p = line.split("\\s+");
                int n = Integer.parseInt(p[0]);
                int d = Integer.parseInt(p[1]);

                line = br.readLine();
                p = line.split("\\s+");

                Long[] sl = new Long[p.length];
                for(int k=0;k<p.length;k++) {
                    sl[k] = Long.valueOf(p[k]);
                }

                Arrays.sort(sl, Collections.reverseOrder());

                // next test
                String answer ="";
                if(d==2){
                    if(n==1){
                        answer += 1;//need to cut in half
                    } else {
                        for(int k=0;k<sl.length-1;k++){
                            if(sl[k]==sl[k+1]){
                                answer+=0;//equal pieces
                                k = sl.length;
                            }
                        }
                        if(answer.equals("")){
                            answer+=1;
                        }
                    }
                } else {//XXX only care about d==3
                    if(n==1){
                        answer += 2;//need to cut in 3
                    } else if(n==2){//need at least 1 cut
                        //sl0>sl0
                        if(sl[0]-sl[1]==sl[1]){
                            answer +=1;//need to cut first in half
                        } else {
                            answer +=2;//cut second in half, cut first to fit second
                        }
                    } else {//n>=3
                        for(int k=0;k<sl.length-2;k++){
                            if(sl[k].equals(sl[k+1])&&sl[k+1].equals(sl[k+2])){
                                answer+=0;
                                k = sl.length;
                            }
                        }//3 equal existing

                        if(answer.equals("")){
                            //find 2 equal and 1 bigger than them
                            for(int k=1;k<sl.length-1;k++){
                                if(sl[k].equals(sl[k+1])){
                                    answer+=1;
                                    k = sl.length;
                                }
                            }
                        }

                        if(answer.equals("")){
                            //find 1 double of other
                            for(int k=0;k<sl.length-1;k++){
                                for(int k2=k+1;k2<sl.length;k2++) {
                                    if (sl[k] - sl[k2] == sl[k2]) {
                                        answer += 1;
                                        k = sl.length;
                                        k2+=sl.length;
                                    }
                                }
                            }
                        }

                        /*if(answer.equals("")){
                            //find 1 sum of 2 other
                            for(int k=0;k<sl.length-2;k++){
                                for(int k2=k+1;k2<sl.length-1;k2++) {
                                    for(int k3=k2+1;k3<sl.length;k3++) {
                                        if(sl[k]==sl[k3]+sl[k2]){
                                            answer += 1;
                                            k = sl.length;
                                            k2 = k;
                                            k3 = k;
                                        }
                                    }
                                }
                            }
                        }*/

                        if(answer.equals("")){
                            answer+=2;
                        }
                    }
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
