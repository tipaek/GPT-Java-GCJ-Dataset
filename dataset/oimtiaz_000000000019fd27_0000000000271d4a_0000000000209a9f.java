import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testCases; i++)
        {
            int nestDepth = 0;
            int offset = 0;
            String input = scan.nextLine();
            String[] inputSplit = input.split("");
            ArrayList<String> split = new ArrayList<>();
            String out;
            int[] nums = new int[inputSplit.length];
            
            for(char c : input.toCharArray())
            {
                split.add(Character.toString(c));
            }
            
            for(int j = 0; j < nums.length; j++)
            {
                nums[j] = Integer.parseInt(inputSplit[j]);
                while(nums[j] > nestDepth)
                {
                    split.add(j + offset, "(");
                    nestDepth+=1;
                    offset+=1;
                }
                while(nums[j] < nestDepth)
                {
                    split.add(j+offset, ")");
                    nestDepth-=1;
                    offset+=1;
                }
            }
            while(nestDepth > 0)
            {
                split.add(")");
                nestDepth-=1;
            }
            out = String.join("", split);
            System.out.println("Case #:" + (i+1) + " " + out);
        }
    }
}
