import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x <= T; x++){
            //init for this test case
            StringBuilder output = new StringBuilder();
            int left = 0;
            //input
            String line = sc.next();
            //process
            for(int i = 0; i < line.length(); i ++){
                int num = line.charAt(i) - 48;
                if(num < left){
                    int addright = left - num;
                    for(int index = 0; index < addright; index++){
                        output.append(")");
                    }
                }else if(num > left){
                    int addleft = num - left;
                    for(int index = 0; index < addleft; index++){
                        output.append("(");
                    }
                }
                output.append(num);
                left = num;
            }
            for(int index = 0; index < left; index++){
                output.append(")");
            }
            String y = output.toString();
            //output
            System.out.println("case #" + x + ": " + y);
        }
    }
}