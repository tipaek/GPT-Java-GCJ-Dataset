import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = b(br);
            System.out.format("Case #%d: ", j);
            System.out.println(str);
        }
    }

    public static String b(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        long R = Long.parseLong(line[0]);
        long S = Long.parseLong(line[1]);

        long ranks = R;
        long temp = R*S-R-1;

        String res = "";
        int steps = 0;
        for(int i=0; temp>=1; temp--) {
            long af = ranks - (i/(S-1));
            long ag = temp;

            if(af == 1)
                break;
            res+="\n" + af + " " + ag;
            i++;
            steps++;
        }
        return steps + res;
    }



}