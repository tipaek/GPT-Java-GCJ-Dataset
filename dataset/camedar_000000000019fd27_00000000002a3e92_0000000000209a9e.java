import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int B = in.nextInt();

        for (int i = 0; i < t; i++) {
            int j = 1;
            int idx = 1;
            String[] response = new String[B];
            while (j <= B) {
                System.out.println(j);
                response[j-1] = String.valueOf(in.nextInt());
                j++;
            }
            System.out.println(1);
            in.nextInt();
            j = 1;
            while (j < B) {
                System.out.println(j);
                response[j-1] = String.valueOf(in.nextInt());
                j+=10;
            }
            System.out.printf("Case #%d: %s", t, String.join("",response));
        }

    }
}