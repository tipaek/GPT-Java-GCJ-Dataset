import java.util.*;

public class Solution{
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int z = 0; z <= cases; z++) {
            String nums = scan.nextLine();

            int n = 0;
            String newNums = "a";
            while (!newNums.equals(nums)) {
                newNums = insert(n, nums);
                if (newNums.equals(nums))
                    break;
                else {
                    nums = newNums;
                    n++;
                }
            }
            if (z!= 0)
                System.out.println("Case #" + (z) + ": " + newNums);
        }
        
    }

    public static String insert(int n, String nums) {
        if (nums.length() == 1)
            return "(" + nums + ")";
        for (int i = 0; i < nums.length(); i++) {
            //Insert open parentheses
            if (Character.getNumericValue(nums.charAt(i)) > n) {
                if (i == nums.length() - 1)
                    return nums.substring(0, i) + "(" + nums.substring(i) + ")";
                nums = nums.substring(0, i) + "(" + nums.substring(i);
                for (int j = i + 1; j < nums.length(); j++) {
                    //Insert close parentheses
                    if (Character.getNumericValue(nums.charAt(j)) == n) {
                        if (j == nums.length() - 1){
                            return nums + ")";
                        }
                        return (nums.substring(0, j) + ")" + insert(n, nums.substring(j)));
                    }
                }
            }

        }
        return nums;
    }
}