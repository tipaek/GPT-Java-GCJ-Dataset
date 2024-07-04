import java.util.Scanner;
import java.util.regex.*;

public class Solution {


    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String [] input = new String[t];
        for(int i=0;i<t;i++){

            input[i]=sc.next();

        }
        //String []input= {"*CONUTS","*COCONUTS","*OCONUTS","*CONUTS","*S"};

        for(int i=0;i<input.length;i++){
              char ch[]= input[i].toCharArray();
              for(int j=0;j<ch.length;j++){

                  if(ch[j]=='*')
                  {
                      ch[j]='_';

                  }
              }
            input[i]=new String(ch);
        }


        System.out.println(nameAnswer(input));




    }



    public static String nameAnswer(String []patterns){

        for(int i=0;i<patterns.length;i++){
            patterns[i]=patterns[i].replaceAll("_",".*");
        }
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