import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String arg = scanner.nextLine();
        String[] tb = arg.split(" ");

        int[] array;


        int t = Integer.parseInt(arg);
        //int b = array[1];

        int[][]inputCollector = new int[t][2];
        for (int i = 0; i < t; i++) { //for each test case
            String nextLine = scanner.nextLine();
            String[] lineParsed = nextLine.split(" ");
            array = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
            inputCollector[i] = array.clone();
        }

        for (int i = 0; i < t; i++) { //for each test case
            int r = inputCollector[i][0];
            int s = inputCollector[i][1];
            int a= r-1;
            int b = s-1;

            int q = r-1;
            String[] out = new String[(s-1) * (r-1)];
            int counter = 0;

            int rConv = r * (s - 1) - 1;
            for (int k = a; k>0; k-- ){

                for (int p = b; p>0; p--){

                    String line = r + " " + rConv;
                    out[counter] = line;
                    rConv --;
                    counter ++;
                }

                r--;
            }

            int caseNum = i+1;
            System.out.println("Case #" + (caseNum) + ": " + counter);
            for (String str: out){
                System.out.println(str);
            }
        }
    }




}