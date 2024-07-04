
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        main(reader);

    }

    public static void main(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }

    }



    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        String[] xyS= reader.readLine().split(" ");

        int xEast = Integer.parseInt(xyS[0]);
        int yNorth = Integer.parseInt(xyS[1]);
        String path = xyS[2];

        int dist = Math.abs(xEast) + Math.abs(yNorth);
        int step = 0;

        int EfectiveDist = dist-step;

        while(EfectiveDist>0 && step < path.length()){
            step++;
            char n = path.charAt(step-1);
            switch(n){
                case 'N':
                    yNorth+=1;
                    break;
                case 'S':
                    yNorth -=1;
                    break;
                case 'E':
                    xEast+=1;
                    break;
                case 'W':
                    xEast-=1;
                    break;
            }
            dist = Math.abs(xEast) + Math.abs(yNorth);
            EfectiveDist = dist-step;

        }
        String solution = "IMPOSSIBLE";
        if(EfectiveDist<=0){
            solution=""+step;
        }
        System.out.println("Case #"+caseN+": "+solution);

    }

}
