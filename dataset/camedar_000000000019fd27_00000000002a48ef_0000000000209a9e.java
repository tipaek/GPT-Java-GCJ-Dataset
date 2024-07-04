import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int B = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            int j = 1;
            int idx = 1;
            String[] response = new String[B];
            while (j <= B) {
                System.out.println(j);
                response[j-1] = in.next();
                j++;
            }
            System.out.println(1);
            in.next();
            j = 1;
            while (j < B) {
                System.out.println(j);
                response[j-1] = in.next();
                j+=10;
            }
            System.out.println(String.join("",response));
        }

    }
}