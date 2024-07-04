import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    public static int flagWrongSet(int[] row, int n){
        Arrays.sort(row);
        for(int i = 0; i < n; i++){
            if(row[i] != (i+1)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("QR20202.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("QR20202.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;
            int tests = Integer.parseInt(line);//100

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                int n = line.length();

                StringBuilder s = new StringBuilder();
                int depth = 0;
                String BEG = "(";
                String END = ")";

                for(int j=0;j<n;j++){
                    int d = line.charAt(j)-'0';

                    if(d>depth){
                        //insert "("
                        //damn computer does not have java11 to use repeat :(
                        for(int k=0;k<d-depth;k++) {
                            s.append(BEG);
                        }
                    } else if (d < depth){
                        //insert ")" to decrease depth
                        for(int k=0;k<depth-d;k++) {
                            s.append(END);
                        }
                    } //else carry on depth is ok

                    depth = d;
                    s.append(d);
                }

                //insert ")" to decrease depth at the end
                for(int k=0;k<depth;k++) {
                    s.append(END);
                }

                String answer = s.toString();
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
