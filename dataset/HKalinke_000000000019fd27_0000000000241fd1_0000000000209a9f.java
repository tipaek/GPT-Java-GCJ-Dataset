import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
         class Data {
            String S;

            Data(String S) {
                this.S = S;
            }

            String out(int tc) {
                return "Case #" + tc + ": " + S;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        Data[] results = new Data[testCases];

        for(int i = 1; i <= testCases; i++) {
            // do stuff here
            StringBuilder Snew = new StringBuilder();
            int openCount = 0;

            // read in string
            String S = scanner.nextLine();

            // get through string
            for(int j = 0; j < S.length(); j++)
            {
                int no = Integer.parseInt(S.substring(j, j+1));

                while(openCount < no)
                {
                    Snew.append("(");
                    openCount++;
                }
                while(openCount > no)
                {
                    Snew.append(")");
                    openCount--;
                }
                Snew.append(no);
            }


            while(openCount > 0)
            {
                Snew.append(")");
                openCount--;
            }

            results[i-1] = new Data(Snew.toString());

        }

        for(int i = 1; i <= testCases; i++) {
            System.out.println(results[i-1].out(i));
        }
    }
}
