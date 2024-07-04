

import java.util.Scanner;

public class Solution {//Vestigium

    public static void main(String[] arr) {
        try {

            Scanner s = new Scanner(System.in);
            int testlines = s.nextInt(), count = 1;
            long dsum = 0, rxor = 0, rsum = 0, csum = 0, rcount = 0, ccount = 0;
            int size = 0, num;
            while (testlines > 0) {
                testlines--;
                size = s.nextInt();
                dsum = 0;
                rcount = 0;
                ccount = 0;
                long arCSum[] = new long[size];
                long arRSum[] = new long[size];

                for (int i = 0; i < size; i++) {

                    for (int j = 0; j < size; j++) {
                        num = s.nextInt();
                        arRSum[i] += num;
                        arCSum[j] += num;

                        if (i == j)
                            dsum += num;

                    }

                }
                int sum = size * (size - 1) ;
                for (int j = 0; j < size; j++) {
                    if (arCSum[j] != sum)
                        ccount++;

                    if (arRSum[j] != sum)
                        rcount++;
                }


            }


            System.out.print("Case #" + count++ + " " + dsum + " " + rcount + " " + ccount);

    } catch(
    Exception ex)

    {
        ex.printStackTrace();
    }

}


}

