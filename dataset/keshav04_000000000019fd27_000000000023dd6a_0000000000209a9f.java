

import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.Instant;

class Solution
{

    


    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t =sc.nextInt();


        for(int k=0;k<t;k++){

            String number = sc.next();
            // System.out.println(number);

            String output = "";

            int openBracketCount =0;

            for(int i=0;i<number.length();i++){
                char c = number.charAt(i);
                int num = (int)c -'0';

                if ( num > openBracketCount ) {

                    for(int j=openBracketCount;j<num;j++){
                        output+="(";
                        openBracketCount++;
                    }
                }
                else {

                        while(num<openBracketCount){
                            output+=")";
                            openBracketCount--;
                        }
                     

                }
                output+=num;
            }
            while(openBracketCount>0){
                            output+=")";
                            openBracketCount--;
                        }

            System.out.println("Case #" +(k+1) +": "+output);
        }


        
        

        
    }

    

}