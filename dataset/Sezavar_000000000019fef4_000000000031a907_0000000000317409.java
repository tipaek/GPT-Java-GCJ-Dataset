import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    private static boolean READ_FROM_FILE = false;
    private static boolean WRITE_TO_FILE = false;
    private static PrintWriter writer = null;

    public final static void main(String[] args) throws IOException {
        Scanner in;
        File inFile = null;
        if (READ_FROM_FILE) {
            inFile = new File(args[0]);
            in = new Scanner(new BufferedReader(new FileReader(args[0])));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }

        if (WRITE_TO_FILE) {
            String fileOut;
            if (inFile == null) {
                fileOut = "out-" + new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out";
            } else {
                fileOut = inFile.getParent() + "/" + inFile.getName().replace(".in", new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out");
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
        }

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            final Solution solution = new Solution();
            print(i, solution.solve(in));
        }

        if (writer != null) {
            writer.flush();
            writer.close();
        }

    }

    public final static void print(int caseNumber, String result) {
        final String toWrite = "Case #" + caseNumber + ": " + result;
        if (writer != null) {
            writer.println(toWrite);
        } else {
            System.out.println(toWrite);
        }
    }


    /******************************************************************************
     *  Normally you should start coding from here:
     ******************************************************************************/
    public Solution() {
    }

    public String solve(final Scanner in) {
        String res = "";
        int X = in.nextInt();
        int Y = in.nextInt();
        String path = in.next();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case 'S':
                    Y--;
                    break;
                case 'N':
                    Y++;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
            }
            int distance = Math.abs(Y)+Math.abs(X);
            if(distance<=i+1 && i+1<min){
                min = i+1;
            }
        }
        if(min==Integer.MAX_VALUE){
            res = IMPOSSIBLE;
        }else{
            res = min+"";
        }
        return res;
    }
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
