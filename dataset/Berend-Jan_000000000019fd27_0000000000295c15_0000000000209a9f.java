import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("/Users/berendjanlange/GitDrive/Hashcode/CodeJamQualification/src/scratch.txt");
        //Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            String ret = "";
            String str = in.next();
            String[] items = str.split("");
            int nextInt = 0;
            int prevInt = 0;
            int diff;
            for (int i = 0; i < items.length; i++)
            {
                nextInt = Integer.parseInt(items[i]);
                diff = nextInt - prevInt;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        ret += "(";
                    }
                } else if (diff < 0) {
                    for (int j = 0; j > diff; j--) {
                        ret += ")";
                    }
                }
                ret += items[i];
                prevInt = nextInt;
            }
            for (int i = 0; i < nextInt; i++) {
                ret += ")";
            }

            int Case = test + 1;
            System.out.println("Case #" + Case + ": " + ret);
        }

    }
}