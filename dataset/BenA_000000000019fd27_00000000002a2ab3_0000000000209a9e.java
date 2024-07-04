import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String r;
        while (s.hasNext()) {
            r = s.nextLine();
        }
        String ans = "";
        for (int x = 1; x <= 10; x++) {
            System.out.println(x);
            ans += s.nextLine();
            System.out.flush();
        }
        System.out.println(ans);
        System.exit(1);
    }
}