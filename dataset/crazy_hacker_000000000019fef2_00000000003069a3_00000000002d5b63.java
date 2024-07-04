
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int t = Integer.parseInt(in[0]);
        int a = Integer.parseInt(in[1]);
        int b = Integer.parseInt(in[2]);
        for(int h=1;h<=t;h++)
        {
            for(int p=-50;p<=50;p++){
                for(int l=-50;l<=50;l++){
                    System.out.println((1000000000-p) +" "+(1000000000-l));
                    if(br.readLine().equalsIgnoreCase("HIT")){
                        System.out.println(p+" "+l);
                    } else {
                        continue;
                    }
                }
            }
            String s = br.readLine();
        }
    }
}

