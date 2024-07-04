import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        for(int x=0;x<size;x++) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            int mats = in.nextInt();
            in.nextLine();
            int r = 0;
            int c = 0;
            int k = 0;
            for (int i = 0; i < mats; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                boolean flag = true;
                for (int j = 0; j < mats; j++) {
                    int temp = in.nextInt();
                    row.add(temp);
                    flag &= set.add(temp);
                }
                if (!flag) {
                    r++;
                }
                matrix.add(row);
            }
            for (int i = 0; i < mats; i++) {
                for (int j = 0; j < mats; j++) {
                    if (i == j) {
                        k += matrix.get(j).get(i);
                    }
                }
            }
            for (int i = 0; i < mats; i++) {
                boolean flag = true;
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < mats; j++) {
                    flag &= set.add(matrix.get(j).get(i));
                }
                if (!flag) {
                    c++;
                }
            }
            if(x<size-1)
                in.nextLine();
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
    }
}
