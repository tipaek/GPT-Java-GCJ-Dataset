import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x <= T; x++){
            StringBuilder output = new StringBuilder();
            int left = 0;
            String line = sc.next();
            for(int i = 0; i < line.length(); i ++){
                int num = line.charAt(i) - 48;
                if(num < left){
                    int addRight = left - num;
                    for(int index = 0; index < addRight; index++){
                        output.append(")");
                    }
                }else if(num > left){
                    int addLeft = num - left;
                    for(int index = 0; index < addLeft; index++){
                        output.append("(");
                    }
                }
                output.append(num);
                left = num;
            }
            for(int i = 0; i < left; i++){
                output.append(")");
            }
            String y = output.toString();
            System.out.println("case #" + x + ": " + y);
        }
    }
}