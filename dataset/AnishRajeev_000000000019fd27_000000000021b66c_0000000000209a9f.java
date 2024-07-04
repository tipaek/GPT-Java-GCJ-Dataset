import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcases = 1; testcases <= T; testcases++) {
            String s = scanner.next();
            String[] split = s.split("");
            int[] nums = new int[split.length];
            ArrayList<String> answers = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            int startingint = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    startingint = i;
                    break;
                }
            }
            if (startingint != -1) {
                int open = 0;
                for (int i = startingint; i < nums.length; i++) {
                    int closenumber = 0;
                    int opennumber = 0;
                    String opennum = "";
                    int num = nums[i];
                    if (num < open) closenumber = open - num;
                    if (num > open) opennumber = num - open;
                    open += opennumber;
                    open -= closenumber;
                    for (int c = 0; c < opennumber; c++) answers.add("(");
                    if(closenumber==0)answers.add(String.valueOf(num));
                    if (i == nums.length - 1) for (int c = 0; c < closenumber; c++) answers.add(")");
                    else for (int c = 0; c < closenumber; c++) answers.add(")");
                    if(closenumber>0)answers.add(String.valueOf(num));
                }
                for(int i = 0; i < open; i++){
                    answers.add(")");
                }
            }
            System.out.print("Case #" + testcases + ": " + " ");
            if(answers.size()!=0) for (int i = 0; i < answers.size(); i++) System.out.print(answers.get(i));
            else for(int i = 0; i < split.length; i++)System.out.print(split[i]);
            System.out.println();
        }
    }
}
