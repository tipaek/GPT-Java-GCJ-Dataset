import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static int flagWrongSet(int[] row, int n){
        Arrays.sort(row);
        for(int i = 0; i < n; i++){
            if(row[i] != (i+1)) return 1;
        }
        return 0;
    }

    public static void printMatrix(int[][] b, int n) throws IOException{
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                bw.write(b[i][j]+" ");
            }
            bw.write(b[i][n-1]+"\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException{

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("QR20205.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("QR20205.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;
            String NO = "IMPOSSIBLE\n";
            String YES = "POSSIBLE\n";
            int tests = Integer.parseInt(line);//44, 100

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                p = line.split("\\s+");

                int n = Integer.parseInt(p[0]);// N 2-5, 2-50
                int y = Integer.parseInt(p[1]);// trace

                int latin = n*(n+1)/2;// sum for normal latin square of size n

                boolean done = false;

                int[][]col = new int[n][n];

                if(y % n == 0){
                    //can construct simple latin with diagonal equal to z = y/n
                    //TODO
                    int z = y/n;
                    //first row has z on first position
                    for(int j=0;j<n;j++){
                        col[0][j] = (z-1+j)%n+1;
                    }

                    //next rows are row above shifted to the right 1 position
                    for(int k=1;k<n;k++){
                        for(int j=0;j<n;j++){
                            col[k][j] = col[k-1][j-1 >= 0 ? j-1 : n-1];
                        }
                    }

                    done = true;
                } else {
                    //TODO
                }

                if(done){
                    //output
                    bw.write("Case #"+(i+1)+": "+YES);
                    bw.flush();
                } else {
                    //output
                    bw.write("Case #"+(i+1)+": "+NO);
                    bw.flush();
                }

                if(done){
                    printMatrix(col,n);
                }
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
