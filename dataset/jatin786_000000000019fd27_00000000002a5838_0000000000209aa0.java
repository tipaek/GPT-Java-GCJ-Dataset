
import java.util.Scanner;

public class Solution {//Vestigium

    public static void main(String[] arr) {
        try {

            Scanner s = new Scanner(System.in);
            int testlines = s.nextInt(), count = 1;
            int size = 0, sum = 0;
            boolean result = false;
            while (testlines > 0) {
                testlines--;
                size = s.nextInt();
                sum = s.nextInt();

                for (int i = 1; i < size; i++)
                    if (sum == i * size) {
                        result = true;
                        break;
                    }
                if (sum == size) {
                    result = true;
                    break;
                }

                System.out.println("Case #" + count++ + ": " + (result == false ? "IMPOSSIBLE" : "POSSIBLE"));
                int p = 1;
                if (result)
                    for (int i = 0; i < size; i++) {


                        for (int j = 0; j < size; j++) {
                            p = p % size;
                            if (p == 0)
                                p = size;
                            System.out.print(p + " ");
                            if (p == size)
                                p = 0;
                            p++;
                        }
                        System.out.println();
                        p++;

                    }

            }


        } catch (
                Exception ex) {
            ex.printStackTrace();
        }

    }


}
