import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testcases = scn.nextInt();
        scn.nextLine();
        for(int k=0; k<testcases; ++k)
        {
            String text = scn.nextLine();
            String finaltext = "";
            for(int i=1; i<=text.length(); i++)
            {
                int temp = Integer.parseInt(text.substring(i-1, i));
                String tempstring = text.substring(i-1, i);
                for(int j=0; j<temp; j++){
                    tempstring = "(" + tempstring + ")";
                }
                finaltext = finaltext + tempstring;
            }
            while(finaltext.contains(")(")){
                finaltext = finaltext.replace(")(", "");
            }
            System.out.println("Case #"+ (k+1) + ": " + finaltext);
        }
        scn.close();
    }
}
