import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int y = 1; y <= t; ++y) {
            String line = in.nextLine();
            char[]arr = line.toCharArray();
            int[]nums = new int[arr.length];
            int[]maxes = new int[arr.length];

            ArrayList<String>answer = new ArrayList<String>();
            for (int i =0; i<arr.length; i++)
            {
                int temp = Character.getNumericValue(arr[i]);
                nums[i] = temp;
                maxes[i] = temp;
                answer.add(""+temp);
            }
            Arrays.sort(maxes);
            int num, index, left, right;
            for(int i = maxes.length-1; i>=0; i--)
            {
                 num = maxes[i];
                 index = Arrays.binarySearch(nums, num);
                for (int j = 1; j<=num; j++) {
                    left = 0;
                    right = 0;
                    //find left limit
                    for(int l = index-1; l>=0; l--)
                    {
                      if(nums[l]==j)
                      {
                          left = l;
                          break;
                      }
                    }

                    //find right limit
                    for(int r = index+1; r<nums.length; r++)
                    {
                        if(nums[r]==j)
                        {
                            right = r;
                            break;
                        }
                    }

                    //get rid of that maxes[i] from nums
                    nums[index] = -1;
                    answer.add(left-1, "(");
                    answer.add(right+1, ")");
                }

            }
            String theanswer = answer.toString();

            System.out.println("Case #" + y + ": " + theanswer);
        }
    }
}
