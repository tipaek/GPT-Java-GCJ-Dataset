import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String... args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = input.nextInt();
        
        
        for (int i = 1; i <= cases; i++) {
            int size = input.nextInt();
            int target = input.nextInt();
            
            if (target % size == 0) {
                System.out.println("Case #" + i + ": POSSIBLE");
                int diagV = target / size;
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        int value = diagV - j + k;
                        if (value > size + 1)
                            value -= size;
                        else if (value < 1) {
                            value += size;
                        }
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        input.close();
    }
}