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
            br = new BufferedReader(new FileReader("QR20201.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("QR20201.out");
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

                int n = Integer.parseInt(line);//N 100
                int latin = n*(n+1)/2;//should be equal to

                int traceSum = 0;
                int wrongRows = 0;
                int wrongCols = 0;

                int[][]col = new int[n][n];
                int[] row = new int[n];
                int sumRow;

                for(int j = 0;j < n;j++){
                    line = br.readLine();
                    p = line.split("\\s+");

                    sumRow = 0;
                    for(int k = 0;k < n;k++){
                        row[k] = Integer.parseInt(p[k]);
                        if(k==j){
                            traceSum += row[k];
                        }
                        col[k][j]=row[k];
                        sumRow +=row[k];
                    }

                    //test sum quicker but with false positives
                    if(sumRow != latin){
                        wrongRows++;
                    } else {
                        wrongRows+=flagWrongSet(row, n);
                    }
                }

                for(int j = 0;j < n;j++){
                    wrongCols+=flagWrongSet(col[j], n);
                }

                //output
                bw.write("Case #"+(i+1)+": "+traceSum+" "+wrongRows+" "+wrongCols+"\n");
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
