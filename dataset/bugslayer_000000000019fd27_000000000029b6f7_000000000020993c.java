import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        // Google Code From FAQ
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs,
                              // strings, chars, etc.

        // TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>();

        ArrayList<Integer> listX = new ArrayList<Integer>();
        ArrayList<Integer> listY = new ArrayList<Integer>();
        int matrix = 1;

        for (int i = 1; i <= t; ++i) {

            int size = in.nextInt();
            for (int x = 0; x < size ; x++) {
                
                String m = in.next();
                String array[] = m.split(" ");
                Arrays.stream(array).forEach(part -> list.add(Integer.parseInt(part)));
            }

            int duplicateX = 0;
            int duplicateY = 0;
            int total = 0;
            int rank = 0;

            // Value from Y
            for (int x = 0; x < size; x++) {
                listY.add(list.get(0));
                total = total + list.get(rank);

                // Values from` X
                for (int y = 0; y < size; y++) {

                    if (rank == 0) {
                        listX.add(list.get(0));
                    }

                    list.remove(0);
                }
                rank++;
            }
            duplicateX = duplicatecheck(listX);
            duplicateY = duplicatecheck(listY);
            System.out.println("Case #" + matrix + ": " + total + " " + duplicateX + " " + duplicateY);
            matrix++;
            listX.removeAll(listX);
            listY.removeAll(listY);
        }
    }

    public static int duplicatecheck(ArrayList<Integer> list) {

        int duplicates = 0;

        // TODO: Write the code to get the number of duplicates in the list

        Set<Integer> uniqueSet = new HashSet<Integer>(list);
        for (int temp : uniqueSet) {
            if (Collections.frequency(list, temp) != 1) {
                duplicates = duplicates + Collections.frequency(list, temp);
            }
        }
        return duplicates;
    }

}
