import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(new InputStreamReader(new BufferedInputStream(System.in)));
        int t = in.nextInt();
        for(int i=1;i<=t;i++) {
            int n = in.nextInt();
            List<String> inputs = new ArrayList<>(n);
            String largestStr = "";
            for (int j=0;j<n;j++){
                String currStr = in.next();
                if(currStr.length()>largestStr.length()){
                    largestStr = currStr;
                }
                 inputs.add(currStr.replace("*",""));
            }
            System.out.println("Case #" + i + ": " + getOutput(inputs,largestStr));
        }
    }

    private static String getOutput(List<String> inputs, String largestStr)
    {
        //case 1
        String biggestP = largestStr.replace("*","");
        boolean match = true;
        for(String p:inputs)
        {
            if(!biggestP.contains(p)){
                match = false;
                break;
            }
        }

        if(match){
            return biggestP;
        }

        return "*";
    }
}
