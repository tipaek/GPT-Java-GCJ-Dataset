import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] powers = new long[31];

        powers[0] = 1;

        for(int i = 1; i<powers.length; i++){
            powers[i] = powers[i-1] * 2;
        }

        for(int t =1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int maxPower = 0;
            for(int i= powers.length-1; i>=0; i--) {
                if(powers[i] < N) {
                    maxPower = i;
                    break;
                }
            }
//            //TODO
//            System.out.println("Max power " + maxPower);


            if(powers[maxPower] + maxPower > N) {
                maxPower --;
            }

            boolean[] on = new boolean[100];
            on[maxPower + 1] = true;
            int fullRows = 1;

            long total = maxPower + powers[maxPower];
            int pos = powers.length -1;
            while( N - total > 35) {
                while(total + powers[pos] > N) {
                    pos --;
                }
                total += powers[pos];
                on[pos] = true;
                fullRows ++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #"+t+":\n");

            boolean start = true;

//            //TODO
//            System.out.println("total " + total);

            for(int i=1; i<=maxPower + 1 + ( N - total ); i++) {
               if(on[i])  {
                   if(start) {
                       for(int j=1; j<=i; j++) {
                           sb.append(i + " " + j + "\n");

                       }
                   } else {
                       for(int j=i; j>0; j--) {
                           sb.append(i + " " + j + "\n");
                       }
                   }
                   start = !start;
               } else {
                   if(start) sb.append(i + " 1\n");
                   else sb.append(i + " " + i + "\n");
               }
            }
            System.out.print(new String(sb));

        }
    }
}
