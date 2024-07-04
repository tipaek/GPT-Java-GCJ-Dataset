import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int q = 1; q <= t; ++q) {
            int size = in.nextInt();
            int sum = in.nextInt();
            in.nextLine();

            boolean check = false;
            int val = 0;
            for(int i=1; i<=size; i++) {
                if(sum == i*size) {
                    check = true;
                    val = i;
                }
            }

            if(check) {
                System.out.println("Case #" + q + ": POSSIBLE" );
                for(int i=0; i<size; i++) {
                    int p = val-i;
                    if(p <= 0) {
                        p += size;
                    }
                    for(int j=0; j<size; j++) {
                        if(p > size) {
                            p -= size;
                        }
                        System.out.print(p++);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + q + ": IMPOSSIBLE" );
            }
        }
    }
}