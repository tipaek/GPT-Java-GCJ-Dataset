import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String arg = scanner.nextLine();
        String[] tb = arg.split(" ");

        int[] array;



        int t = Integer.parseInt(arg);


        for (int i = 0; i < t; i++) { //for each test case
            String nextLine = scanner.nextLine();
            String[] lineParsed = nextLine.split(" ");
            array = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
            int r = array[0];
            int s = array[1];
            int q = r-1;
            String[] out = new String[(s-1) * (r-1)];
            int counter = 0;

            int rConv = r * (s - 1);
            for (int k = r-1; k>0; k-- ){

                for (int p = s - 1; p>0; p--){

                    String line = rConv + " " + (r-1);
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