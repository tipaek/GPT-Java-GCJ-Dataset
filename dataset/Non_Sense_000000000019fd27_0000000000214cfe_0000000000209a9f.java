import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCases; i++){
            String s = br.readLine();
            String solution = "";
            int[] digits = s.chars().map(c -> c-'0').toArray();
            int depth = 0;

            for(int j = 0; j < digits.length; j++){
                int jumps = digits[j]-depth;
                depth = digits[j];
                int jumpsLen = Math.abs(jumps);

                for(int k = 0; k < jumpsLen; k++){
                    if(jumps > 0){
                        solution+='(';
                    }else if(jumps < 0){
                        solution+=')';
                    }
                }
                solution+=digits[j];
            }
            for(int k=depth ; k>0; k--){
                solution+=')';
            }

            System.out.println("Case #" + (i+1) + ": " + solution);
            

        }
    }
}