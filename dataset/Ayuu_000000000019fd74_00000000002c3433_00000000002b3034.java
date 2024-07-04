import java.util.*;
import java.util.regex.*;
import java.lang.*;
//class Solution {
//    public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
// 		int t = sc.nextInt();
//         String result = "";
//         for(int k = 1; k <= t; k++) {
//             int n = sc.nextInt();
//             for(int i = 0; i < n/2; i++) {
//                 String str1 = sc.next();
//                 str1=str1.replace('*','.');
//                 String str2 = sc.next();
//                 str2=str2.replace('*','.');
//                 boolean b3 = Pattern.matches(str1,str2);
//                 if(b3==true)
//                     result=str2;
//             }
//             if(result=="") {
//                 System.out.println("Case #"+k+": "+"*");
//             }
//             else {
//                 String s = result.substring(1,result.length());
//                 System.out.println("Case #"+k+": "+s);
//             }
//             result="";
//         }
//         import java.util.regex.*;

public class Solution {


    public static void main(String[]args){
        
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        String result = "";
        for(int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            String []input= new String[n];
            for(int j = 0; j < input.length;j++) {
                input[j] = "*"+sc.next();
            }
            System.out.println("Case #"+k+": "+nameAnswer(input));
        }




    }



    public static String nameAnswer(String []patterns){

        boolean result = false;
        String answer=patterns[0];
        for(int i=1;i<patterns.length;i++){
            if(answer.length()<patterns[i].length()){
                result=Pattern.matches(answer,patterns[i]);

            }
            else{
                result=Pattern.matches(patterns[i],answer);

            }
            if(result==true){
                if(patterns[i].length()>answer.length()){
                answer=patterns[i];}
            }
            else
                answer=new String("*");

        }

        if (answer.equalsIgnoreCase("*"))
            return answer;
        else if (answer.contains("*"))
        {        char ch[] =answer.toCharArray();
            for (int i=0;i<ch.length;i++){
                if(ch[i]=='*'){
                    ch[i]=' ';
                }


            }
          return new String(ch).replaceAll(". ","");
        }


        return "*";
    }
}