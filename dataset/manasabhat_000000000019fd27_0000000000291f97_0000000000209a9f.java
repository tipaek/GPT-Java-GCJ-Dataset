import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    static void printMinParanthesis(String s) {
        int opnCnt = 0;
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val = (int) s.charAt(i) - (int) '0';
            if (val > opnCnt) {
                while (opnCnt != val) {
                    System.out.print("(");
                    opnCnt++;
                }
                System.out.print(s.charAt(i));
            } else if (val < opnCnt) {
                while (opnCnt != val) {
                    System.out.print(")");
                    opnCnt--;
                }
                System.out.print(s.charAt(i));
            } else {
                System.out.print(s.charAt(i));
            }
        }
        while (opnCnt > 0) {
            System.out.print(")");
            opnCnt--;
        }
      
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < T; i++) {


            String s = bufferedReader.readLine().trim();
             System.out.print("\nCase #"+(i+1)+": ");
            printMinParanthesis(s);

        }


        bufferedReader.close();
    }

}
