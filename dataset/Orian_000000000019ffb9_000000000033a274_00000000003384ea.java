
import java.util.*;
import java.io.*;

public class Solution {

    static void runTest (int L, int R){

        int i = 1;
        for (i = 1; L >= 0 && R >= 0; i++){

            if (L >= R){
                L-=i;
            }
            else{
                R-=i;
            }

        }

        int numCustomers = i-2;
        L = (L < 0) ? (L+i-1):L;
        R = (R < 0) ? (R+i-1):R;

        System.out.println (numCustomers + " " + L + " " + R);

        return;

    }

    public static void main(String args[]){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int L = in.nextInt();
            int R = in.nextInt();

            System.out.print("Case #" + i + ": ");

            runTest(L, R);

        }

        in.close();

    }

}