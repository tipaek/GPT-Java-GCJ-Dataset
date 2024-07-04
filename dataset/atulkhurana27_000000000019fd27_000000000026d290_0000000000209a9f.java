import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {

            String s= sc.next();
            String result="";

           Integer prev=null;
           int totOpen=0;
           int totClose=0;

           for(int j=0;j<s.length();j++){
               int x=Integer.parseInt(s.charAt(j)+"");
               if(prev==null){
                   totOpen+=x;
                   result += getOpenParanthesis(x)+x;
               }
               else {
                   if((prev>x)) {
                       totClose+=prev-x;
                       result += getCloseParanthesis(prev-x)+x;
                   }
                   else if(prev<x) {
                       totOpen+=x-prev;
                       result += getOpenParanthesis(x-prev)+x;
                   } else {
                       result=result+x;
                   }
               }
               prev=x;

           }
           result=result+getCloseParanthesis(totOpen-totClose);



            System.out.println("Case #"+i+": "+result);
        }

    }

    private static String getOpenParanthesis(int x) {
        String result="";
        for(int i=1;i<=x;i++){
result=result+"(";
        }
        return result;
    }

    private static String getCloseParanthesis(int x) {
        String result="";
        for(int i=1;i<=x;i++){
            result=result+")";
        }
        return result;
    }
}


