import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;




public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int numAct;
        char C[] = new char[1441];
        char J[] = new char[1441];
        int start;
        int end;
        boolean impos;
        for (int i = 1; i <= T; i++) {
            numAct = Integer.parseInt(br.readLine().trim());
            Arrays.fill(C, '0');
            Arrays.fill(J,  '0');
            impos=false;
            char[] activities = new char[numAct];
            for (int j = 0; j < numAct; j++) {
                                String[] split = (br.readLine().trim()).split("\\ ");
                start = Integer.parseInt(split[0]);
                end = Integer.parseInt(split[1]);
                activities[j] = schedule(C, J, start, end);
                if(activities[j] == 'N'){
                    System.out.println("Case #" + i + ": IMPOSSIBLE" );
                    impos=true;
                    break;
                } else if (activities[j] == 'C'){
                    Arrays.fill(C, start, end, '1');

                } else {
                    Arrays.fill(J, start, end, '1');

                }

            }
            if(!impos)
                System.out.println("Case #" + i + ": " + new String(activities));
        }
    }

    public static char schedule(char[] C, char[] J, int start, int end){
        if(new String(Arrays.copyOfRange(C, start, end)).indexOf('1') != -1)  {
            if(new String(Arrays.copyOfRange(J, start, end)).indexOf('1') != -1)  {
                return 'N';
            } else
                return 'J';
        }
        else return 'C';
    }
}
