import java.io.*;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;
    public static int[] ax;
    public static int[] ay;
    public static int r;
    public static int s;
    public static int maxOp;

    public static int globalSolMoves;
    public static int[] globalSolX;
    public static int[] globalSolY;
    public static int[] swapX;
    public static int[] swapY;
    public static int[] tempX;
    public static int[] tempY;

    public static boolean checkSolution(){
        //(1, 2), (1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (4, 2), (4, 1)
        for(int index=0,j = 1; j<=r; j++){
            for(int k = 1; k<=s; k++){
                if(ax[index] != j) return false;
                index++;
            }
        }
        return true;
    }

    public static void swap(int a, int b){
        //put first A after next B in array
        for(int i = 0; i< a; i++){
            tempX[i] = ax[i];
            tempY[i] = ay[i];
        }
        for(int i = 0; i< b; i++){
            ax[i] = ax[a+i];
            ay[i] = ay[a+i];
        }
        for(int i = 0; i<a; i++){
            ax[i+b] = tempX[i];
            ay[i+b] = tempY[i];
        }
    }

    public static void back(int moves){
        if(moves >= globalSolMoves){
            return;
        }

        if(checkSolution()) {
            globalSolMoves = moves;
            for(int j = 0; j < globalSolMoves; j++) {
                globalSolX[j] = swapX[j];
                globalSolY[j] = swapY[j];
            }
            return;
        }

        //choose swap x in A and y in B
        for(int i = 1;i < maxOp; i++){
            for(int j = 1;j <= maxOp - i;j++){
                //don't undo it
                if(moves == 0 || i != swapY[moves-1] || j != swapX[moves-1]){
                    swapX[moves] = i;
                    swapY[moves] = j;
                    swap(i,j);
                    back(moves+1);
                    swap(j,i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1BPC.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1BPC.out");
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
                p = line.split("\\s+");
                r = Integer.parseInt(p[0]);
                s = Integer.parseInt(p[1]);
                //(1, 1), (2, 1), (3, 1), (r, 1), (1, 2), (2, 2), (3, 2).... (r, s).

                maxOp = r*s;
                int j,k, index;
                ax = new int[maxOp];
                ay = new int[maxOp];

                for(index=0,j = 1; j<=s; j++){
                    for(k = 1; k<=r; k++){
                        ax[index] = k;
                        ay[index] = j;
                        index++;
                    }
                }

                globalSolMoves = maxOp+1;//maxOp should be enough
                globalSolX = new int[globalSolMoves];
                globalSolY= new int[globalSolMoves];
                swapX= new int[globalSolMoves];
                swapY= new int[globalSolMoves];
                tempX= new int[globalSolMoves];
                tempY= new int[globalSolMoves];
                back(0);

                //output
                if(globalSolMoves <= maxOp){
                    bw.write("Case #"+(i+1)+": "+globalSolMoves+"\n");
                    bw.flush();

                    for(j = 0; j < globalSolMoves; j++) {
                        bw.write(""+globalSolX[j]+" "+globalSolY[j]+"\n");
                        bw.flush();
                    }
                } else {
                    throw new RuntimeException("XXX");
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
