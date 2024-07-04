

import java.util.HashMap;
import java.util.Scanner;

public class Solution {//Vestigium

    public static void main(String[] arr) {
        try {

            Scanner s = new Scanner(System.in);
            int testlines = s.nextInt(), count = 1;
            long dsum = 0, rcount = 0, ccount = 0;
            int size = 0, num;
            while (testlines > 0) {
                testlines--;
                size = s.nextInt();
                dsum = 0;
                rcount = 0;
                ccount = 0;
                long arCSum[] = new long[size];
                long arRSum[] = new long[size];

                HashMap<Integer, Integer> cmap[] = new HashMap[size];
                HashMap<Integer, Integer> rmap[] = new HashMap[size];

                for (int i = 0; i < size; i++) {
                    rmap[i] = new HashMap<>();

                    for (int j = 0; j < size; j++) {
                        if (i == 0)
                            cmap[j] = new HashMap<>();
                        num = s.nextInt();
                        rmap[i].put(num, 1);
                        cmap[j].put(num, 1);

                        if (i == j)
                            dsum += num;
                    }
                }
                for (int j = 0; j < size; j++) {

                    if (cmap[j].size() != size)
                        ccount++;

                    if (rmap[j].size() != size)
                        rcount++;
                }
                System.out.println("Case #" + count++ + " " + dsum + " " + rcount + " " + ccount);

            }


        } catch (
                Exception ex) {
            ex.printStackTrace();
        }

    }


}

