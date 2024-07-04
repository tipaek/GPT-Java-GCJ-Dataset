import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedReader(new FileReader("c.in")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        int numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            line = in.nextLine();
            int N = Integer.parseInt(line);
            boolean[] sheduleBusyC = new boolean[1440];
            boolean[] sheduleBusyJ = new boolean[1440];
            String result = "";
            for (int j = 0; j < N; j++) {
                line = in.nextLine();
                String[] minutes = line.split(" ");
                boolean isBusyC = false;
                int minIni = Integer.parseInt(minutes[0]);
                int minEnd = Integer.parseInt(minutes[1]);
                for (int k = minIni; k < minEnd && !isBusyC; k++) {
                    isBusyC = sheduleBusyC[k];
                }
                if (!isBusyC) {
                    result += "C";
                    for (int k = minIni; k < minEnd; k++) {
                        sheduleBusyC[k] = true;
                    }
                }/* else {
                    boolean isBusyJ = false;
                    for (int k = minIni; k < minEnd && !isBusyJ; k++) {
                        isBusyJ = sheduleBusyJ[k];
                    }
                    if (!isBusyJ) {
                        result += "J";
                        for (int k = minIni; k < minEnd; k++) {
                            sheduleBusyJ[k] = true;
                        }
                    }
                    else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }*/
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
