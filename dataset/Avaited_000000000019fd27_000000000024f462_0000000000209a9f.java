import java.util.Scanner;

public class Solution {

    public static void processString(String input, int caseNo) {
        String localString = input;
        String pattern = "db";
        String nullValue = "";
        //System.out.println("Local : "+localString+" : "+pattern);
        while(true){
            if(localString.contains(pattern)){
                String newStr = localString.replaceAll(pattern,nullValue);
                //System.out.println("Orig : "+localString+" : "+newStr);
                localString = newStr;
            } else {
                //System.out.println("Pattern "+pattern+" is not found in "+localString);
                break;
            }
        }
        localString = localString.replaceAll("b","(");
        localString = localString.replaceAll("d",")");
        System.out.println("Case #"+caseNo+": "+localString);
    }
    public static void main(String[] args) {
        Scanner in = null;
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i =1 ; i <= T; i++) {
            String N = in.next();
            String input = "";
            for(int ii =0; ii < N.length(); ii++){
                int num = Integer.parseInt(String.valueOf(N.charAt(ii)));
                for(int jj =0; jj < num; jj++){
                    input += "b"; //(
                }
                input +=  num;
                for(int jj = 0; jj < num; jj++){
                    input += "d"; //)
                }
            }
            processString(input,i);
        }
    }
}
