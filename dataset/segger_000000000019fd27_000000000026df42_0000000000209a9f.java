import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void mainTmp(String[] args) {
        /*
        Case #1: 0000
        Case #2: (1)0(1)
        Case #3: (111)000
        Case #4: (1)*/

        /*
        String data = "4\n" +
                "0000\n" +
                "101\n" +
                "111000\n" +
                "1";*/

        //String data = "0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1)";
        String data = "4\n021\n312\n4\n221\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            //System.out.println("T: " + T);
            for (int i = 1; i <= T; ++i) {
                String S = in.nextLine();
                System.out.println("Case #" + i + ": " + result(S));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        //System.out.println("T: " + T);
        for (int i = 1; i <= T; ++i) {
            String S = in.nextLine();
            System.out.println("Case #" + i + ": " + result(S));
        }
    }

    private static int[] toNbr(String S) {
        int size = S.length();
        int [] nbrs = new int [size];
        for(int i = 0; i < size; i++) {
            nbrs[i] = Integer.parseInt(S.substring(i, i+1));
        }
        return nbrs;
    }

    private static String result(String S) {
        int[] nbrs = toNbr(S);

        int nesting = 0;

        StringBuffer result = new StringBuffer();
        for(int nbr: nbrs) {
            if (nbr == nesting) {
                result.append(nbr);
            } else if (nbr > nesting){
                while (nbr > nesting) {
                    result.append("(");
                    nesting++;
                }
                result.append(nbr);
            } else if (nbr < nesting) {
                while (nbr < nesting) {
                    result.append(")");
                    nesting--;
                }
                result.append(nbr);
            }
        }
        while(nesting > 0) {
            result.append(")");
            nesting--;
        }
        return result.toString();
    }
}
