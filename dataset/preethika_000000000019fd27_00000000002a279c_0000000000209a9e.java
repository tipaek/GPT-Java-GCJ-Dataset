import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder(); 
        int digit = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        for (int j = 0; j < T; j++) {
            result=new StringBuilder();
            digit=1;
            for (int i = 1; i <= 150; i++) {
                if (digit > B) {
                    // guess the final output
                   // StringBuilder sb = result.reverse();
                   // String str=sb.toString();
                    System.out.println(result);
                    System.out.flush();
                    String judgeinputYesOrNo = br.readLine();
                    if (judgeinputYesOrNo.equalsIgnoreCase("Y"))
                        break;
                    if (judgeinputYesOrNo.equalsIgnoreCase("N"))
                        System.exit(0);

                } else {
                    if ((((i % 40) >= 31) || ((i%40)==0))) {
                        System.out.println(digit);
                        System.out.flush();
                        String judgeinputtmp = br.readLine();
                        int judgeinput = Integer.parseInt(judgeinputtmp);
                        result.append(judgeinput);
                        digit++;
                    } else {
                        System.out.println(10);
                        System.out.flush();
                        String judgeinputtmp1 = br.readLine();
                        int a= Integer.parseInt(judgeinputtmp1);
                    }
                }
            }
        }
    }
}
