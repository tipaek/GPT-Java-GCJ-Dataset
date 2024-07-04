
import java.util.*;
import java.io.*;

public class Solution {

    static void runTest (int n, int d, long[] degs){

        if (d == 2){

            for (int ra = 0; ra < n; ra++){
                for (int rb = 0; rb < n; rb++){
                    if (ra == rb){continue;}
                    if (degs[ra] == degs[rb]){
                        System.out.println(0);
                        return;
                    }
                }
            }

            System.out.println(1);
            return;

        }
        else if (d == 3){

            Arrays.sort(degs);

            // if there are 3 of equal size, then return 0
            for (int ra = 0; ra < n; ra++){
                for (int rb = 0; rb < n; rb++){
                    for (int rc = 0; rc < n; rc++){
                        if (ra == rb || rb == rc || ra == rc){continue;}
                        if (degs[ra] == degs[rb] && degs[ra] == degs[rc]){
                            System.out.println(0);
                            return;
                        }
                    }
                }
            }

            // if there are two of equal size that are not of maximum size
            for (int ra = 0; ra < n-1; ra++){
                if (degs[ra] == degs[ra+1]){
                    if (degs[ra] < degs[n-1]){
                        System.out.println(1);
                        return;
                    }
                }

            }

            // if there is one such that double that angle is in the list
            for (int ra = 0; ra < n; ra++){

                long db = degs[ra] * 2;
                for (int rb = 0; rb < n; rb++){
                    if (degs[rb] == db){
                        System.out.println(1);
                        return;
                    }
                }

            }

            System.out.println(2);
            return;

        }

        return;

    }

    public static void main(String args[]){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int n = in.nextInt();
            int d = in.nextInt();

            long[] arr = new long[n];

            for (int ia = 0; ia < n; ia++){
                arr[ia] = in.nextLong();
            }

            System.out.print("Case #" + i + ": ");

            runTest(n, d, arr);

        }

        in.close();

    }

}