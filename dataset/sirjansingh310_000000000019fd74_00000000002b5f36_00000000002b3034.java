import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String input[] = new String[n];
            String output = "*";
            String maxLenString = "";
            boolean allStartAtFirst = true;
            for(int i = 0; i < n; i++){
                input[i] = br.readLine();
                if(input[i].charAt(0) != '*')
                    allStartAtFirst = false;
                if(input[i].length() > maxLenString.length()){
                    maxLenString = input[i];
                }
            }
            if(allStartAtFirst){
                String possibleAns = maxLenString;
                boolean ansHolds = true;
                for(int i = 0; i < n; i++){
                    if(maxLenString.substring(maxLenString.length() - input[i].length() + 1).equals(input[i].substring(1)))
                        continue;
                    else {
                        ansHolds = false;
                        break;
                    }
                }
                if(ansHolds)
                    output = maxLenString.substring(1, maxLenString.length());
            }





            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}
