import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int testCases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testCases; i++)
        {
            String[] in = scan.nextLine().split(" ");
            int size = Integer.parseInt(in[0]);;
            int targetTrace = Integer.parseInt(in[1]);
            System.out.println(size + " " + targetTrace);
            int[][] matrix = new int[size][size];
            boolean solved = false;
            String out;
            ArrayList<Integer> nums = new ArrayList<>();
            for(int j = 0; j < size; j++)
            {
                nums.add(new Integer(j));
            }
            
            for(int j = 0; j < size ; j++)
            {
                for(int k = 0; k < size; k++)
                {
                    matrix[j][k] = (j + k ) % size + 1;
                }
            }
            
            for(int j = 0; j < size && !solved; j++)
            {
                int trace = 0;

                Collections.shuffle(nums);
                for(int k = 0; k < size; k++)
                {
                    trace += matrix[nums.get(k)][k];
                }
                if (trace == targetTrace) {
                    solved = true;
                    System.out.println("Case #" + (i+1) + ": POSSIBLE");
                    for(int k = 0; k < size; k++)
                    {
                        for(int a = 0; a < size; a++)
                        {
                            System.out.print(" " + matrix[nums.get(k)][a]);
                        }
                        System.out.print("\n");
                    }
                }
            }
            
            if(!solved)
            {
                System.out.println("Case #" + (i+1)+  ": IMPOSSIBLE");
            }
        }
    }
}
