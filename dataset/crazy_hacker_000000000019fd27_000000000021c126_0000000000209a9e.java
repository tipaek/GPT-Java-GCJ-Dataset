
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int t = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        // 1010101001
        for(int h=1;h<=t;h++)
        {
            StringBuilder s = new StringBuilder();
            int q  = 1;
            while(s.length()<b){
                System.out.println(s.length()+1);
                int k = Integer.parseInt(br.readLine());
                if(q%10!=1){
                    s.append(k+"");
                }
                q++;

            }
            System.out.println(s);
            String l = br.readLine();
        }
    }
}
