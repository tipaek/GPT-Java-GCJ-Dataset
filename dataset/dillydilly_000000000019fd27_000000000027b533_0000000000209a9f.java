import java.util.*;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            String num = input.next();
            List<Integer> nums = splitter(num);
            String sol = parans(nums);
            sol = cutter(sol);
            System.out.println("Case #" + i + ": " + sol);
        }
    }
    
    public static List<Integer> splitter(String num) {
        List<Integer> nums = new LinkedList<>();
        for(int i = 0; i < num.length(); i++) {
            nums.add(Integer.parseInt(num.substring(i, i + 1)));
        }
        return nums;
    }
    
    public static String parans(List<Integer> nums) {
        String sol = "";
        for(int num : nums) {
            String innerSol = "" + num;
            for(int i = 0; i < num; i++) {
                innerSol = "(" + innerSol + ")"; 
            }
            sol += innerSol;
        }
        return sol;
    }
    
    public static String cutter(String sol) {
        while(sol.contains(")(")) {
            sol = sol.replace(")(", "");
        }
        return sol;
    }
}
