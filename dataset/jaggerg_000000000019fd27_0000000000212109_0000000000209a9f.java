import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = Integer.parseInt(sc.nextLine());

        for(int t = 1; t <= numTests; t++){
            String test = sc.nextLine();
            int[] nums = new int[test.length()];

            for(int i = 0; i < test.length(); i++){
                nums[i] = test.charAt(i) - '0';
            }

            String result = "";
            int curCount = 0;

            for(int i = 0; i < nums.length; i++){
                while(curCount < nums[i]){
                    result += "(";
                    curCount++;
                }
                while(curCount > nums[i]){
                    result += ")";
                    curCount--;
                }
                result += nums[i];
            }

            while(curCount > 0){
                result += ")";
                curCount--;
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}
