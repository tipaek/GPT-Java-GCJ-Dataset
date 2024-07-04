import javafx.util.Pair;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    private static BufferedReader br;
    private static long[][] memo;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        memo = new long[501][501];
        for (long[] row: memo)
            Arrays.fill(row, 0);

        //Input for number of test cases.
        int cases = Integer.parseInt(br.readLine());

        for (int test = 1; test <= cases; test++) {

            //Code Here
            long sum = Long.parseLong(br.readLine());

            //DO NOT CHANGE THE LINE IF NOT NECESSARY
            System.out.println("Case #" + test + ": ");
            prettyPrintPath(findNextPath(0,0,sum,new ArrayList<Pair<String,Integer>>(), 0));

        }
    }

    private static ArrayList findNextPath(int i, int j, long sum, ArrayList path, int size) {
        //System.out.println(sum);


        ArrayList pathMod = path;

        if(sum==0&&size<=500) {
            return path;
        }

        if(i>500||j>i||j<0||size>500||sum<0||path.contains(new Pair<Integer,Integer>(i,j))) {
            return null;
        }

        if(memo[i][j] != 0){

            if(sum - memo[i][j] >= 0) {
                pathMod.add(new Pair<Integer, Integer>(i, j));
                ArrayList ijn = findNextPath(i, j + 1, sum - memo[i][j], pathMod, size++);
                if (ijn != null)
                    return ijn;
                ArrayList inj = findNextPath(i + 1, j, sum - memo[i][j], pathMod, size++);
                if (inj != null)
                    return inj;
                ArrayList injn = findNextPath(i + 1, j + 1, sum - memo[i][j], pathMod, size++);
                if (injn != null)
                    return injn;
                ArrayList ijp = findNextPath(i, j - 1, sum - memo[i][j], pathMod, size++);
                if (ijp != null)
                    return ijp;
                ArrayList ipj = findNextPath(i - 1, j, sum - memo[i][j], pathMod, size++);
                if (ipj != null)
                    return ipj;
                ArrayList ipjp = findNextPath(i - 1, j - 1, sum - memo[i][j], pathMod, size++);
                return ipjp;
            }
            else
                return null;

        }else {
            String power11 = findpower11(i);
            int jChar  = Integer.parseInt(power11.charAt(j)+"");
            memo[i][j] = jChar;
            if(sum - jChar >= 0 ){
            pathMod.add(new Pair<Integer,Integer>(i,j));
                ArrayList ijn = findNextPath(i,j+1,sum - jChar,pathMod,size++);
                if (ijn != null) {
                    return ijn;
                }
            ArrayList inj = findNextPath(i + 1, j, sum - jChar, pathMod, size++);
            if (inj != null)
                return inj;
            ArrayList injn = findNextPath(i + 1, j + 1, sum - jChar, pathMod, size++);
            if (injn != null)
                return injn;
            ArrayList ipj = findNextPath(i-1,j,sum - jChar,pathMod,size++);
            if (ipj != null) {
                return ipj;
            }
            ArrayList ijp = findNextPath(i,j-1,sum - jChar,pathMod,size++);
            if (ijp != null) {
                return ijp;
            }
            ArrayList ipjp = findNextPath(i-1,j-1,sum - jChar,pathMod,size++);
            return ipjp;
            }
            else
                return null;
        }

        //return path;
    }

    private static void prettyPrintPath(ArrayList path){
        if(path == null)
            System.out.println("Null");;
        int size = path.size();
        for (int i = 0; i < size; i++) {
            Pair<Integer,Integer> pair = (Pair<Integer, Integer>) path.get(i);
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static String findpower11(int i){

        BigInteger b1 = new BigInteger("11");
        BigInteger result = b1.pow(i);

        String pow = result+"";
        if(pow.contains("."))
        {
            int post = pow.indexOf(".");
            pow = pow.substring(0,post);
        }

        return pow;
    }

}