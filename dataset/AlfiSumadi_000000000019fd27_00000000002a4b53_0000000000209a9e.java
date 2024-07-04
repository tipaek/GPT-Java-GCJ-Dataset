import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for(int x = 0; x < t; x++) {
            String sol = "";
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                sol += in.next().charAt(0);
            }
            System.out.println(sol);
            System.out.flush();
            char ok = in.next().charAt(0);
            if (ok == 'N') System.exit(0);
        }
        System.exit(0);
    }
}