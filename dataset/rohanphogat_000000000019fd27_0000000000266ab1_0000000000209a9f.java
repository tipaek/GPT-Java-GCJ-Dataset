import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numcases = in.nextInt();
        for(int tc = 0; tc < numcases; tc++) {
            String inputString = in.next();
            StringBuilder resultstr = new StringBuilder();

            int curr = 0;
            int val;
            int diff = 0;
            for(int i=0; i< inputString.length(); i++){
                val = Character.getNumericValue(inputString.charAt(i));
                diff = val-curr;
                if(diff > 0){
                    for(int x = 0; x < diff; x++){
                        resultstr.append("(");
                        curr++;
                    }
                }else if(diff < 0){
                    for(int x = 0; x < Math.abs(diff); x++){
                        resultstr.append(")");
                        curr--;
                    }
                }
                resultstr.append(val);
            }
            while(curr > 0){
                resultstr.append(")");
                curr--;
            }

            System.out.println("Case #"+(tc+1)+": "+resultstr.toString());
        }
    }
}