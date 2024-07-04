import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[][] a;
    private static int[][] row;
    private static int[][] col;
    private static int[] elem;
    private static boolean doneFilling;

    public static void fillPermutationMatrix(int z, int n) {
        a = new int[n][n];//default zeroes
        int j,k;
        //first row has z on first position
        for (j = 0; j < n; j++) {
            a[0][j] = (z - 1 + j) % n + 1;
        }

        //next rows are row above shifted to the right 1 position
        for (k = 1; k < n; k++) {
            for (j = 0; j < n; j++) {
                a[k][j] = a[k - 1][j - 1 >= 0 ? j - 1 : n - 1];
            }
        }
    }

    public static void fillMatrix(int[]trans, int n){
        a = new int[n][n];
        row = new int[n][n];
        col = new int[n][n];
        elem = new int[n];

        for(int j=0;j<n;j++){
            a[j][j] = trans[j];// 1-indexed
            row[j][trans[j]-1]=1;
            col[j][trans[j]-1]=1;
            elem[trans[j]-1]++;
        }

        //jump to filling rest
        doneFilling = false;
        recursiveFill(n, n);
    }

    public static int findClosestElement(int[] e, int n){
        int max = -1;
        int index = -1;
        for(int i=0;i<n;i++){
            //closest to filling, not filled yet
            if(e[i] < n && e[i]>=max){
                max = e[i];
                index = i;
            }
        }
        return index;
    }

    public static void recursiveFill(int soFar, int n){
        if(soFar == n*n){
            doneFilling = true;
            return;
        }

        //try first row not done
        int i=0;
        //find row that does not have elem[i]
        if(!doneFilling){
            i = findClosestElement(elem,n);
        }

        for(int j = 0;j < n && !doneFilling;j++){
            if(row[j][i] != 1){
                //try to put i on row j
                for(int k = 0;k < n && !doneFilling; k++){
                    //try to put i on col k if position is empty
                    if(a[j][k] == 0 && col[k][i] != 1) {
                        col[k][i] = 1;
                        row[j][i] = 1;
                        a[j][k]=i+1;// this is 1-indexed!
                        elem[i]++;

                        recursiveFill(soFar+1, n);
                        // delete back
                        if(!doneFilling){
                            a[j][k]=0;
                            col[k][i] = 0;
                            row[j][i] = 0;
                            elem[i]--;
                        }
                    }
                }
            }
        }
    }

    public static int flagWrongSet(int[] row, int n){
        Arrays.sort(row);
        for(int i = 0; i < n; i++){
            if(row[i] != (i+1)) return 1;
        }
        return 0;
    }

    public static boolean checkMatrix(int[][] c, int n){
        for(int i = 0; i < n; i++) {
            if (flagWrongSet(c[i].clone(), n) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(int n) throws IOException{
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                bw.write(a[i][j]+" ");
            }
            bw.write(a[i][n-1]+"\n");
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

                boolean impossible = (y == n+1) || (y ==n*n-1);

                if(n<=3){// override
                    impossible = y%n != 0;
                }

                if(impossible){
                    //output
                    bw.write("Case #"+(i+1)+": "+NO);
                    bw.flush();
                    continue;
                }

                boolean done;
                int j;
                int z = y/n;
                int rest = y%n;

                if(rest == 0){
                    //can construct fast simple latin with diagonal equal to z = y/n
                    fillPermutationMatrix(z, n);
                    done = true;
                } else {
                    //Step #1: decompose y fast
                    int[] trans = new int[n];
                    if(rest != 1 && rest != n-1){
                        // corner cases need special attention
                        // fast decompose adding 1 to rest elements
                        // (z+1)*rest + z*(n-rest) = z*n + rest = y
                        for(j=0;j<rest;trans[j]=z+1, j++);
                        for(j=rest;j<n;trans[j]=z, j++);
                    } else if(rest == 1) {
                        // z=1 means impossible and was rejected
                        // n <=3 above
                        // z*(n-1)+z+1 = z*n+1=z*n+rest=y
                        trans[0]=z-1;
                        trans[1]=z+1;
                        trans[2]=z+1;
                        for(j=3;j<n;trans[j]=z, j++);
                    } else {
                        // rest = n-1
                        // z = n-1 means impossible and was rejected
                        // n <=3 above
                        // (z+1)*(n-1)+z = z*n+n-z-1+z=z*n+n-1=z*n+rest=y
                        trans[0]=z+2;
                        trans[1]=z;
                        trans[2]=z;
                        for(j=3;j<n;trans[j]=z+1, j++);
                    }

                    //Step #2: fill remaining Matrix
                    fillMatrix(trans, n);

                    done = true;
                    //done = checkMatrix(a, n);// redundant pre-flight check for testing purposes only
                }

                if(done){
                    //output
                    bw.write("Case #"+(i+1)+": "+YES);
                    bw.flush();
                    printMatrix(n);
                }//else failed miserably
                else {
                    printMatrix(n);
                    throw new RuntimeException();
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
