import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);
        int cases = myObj.nextInt();
        myObj.nextLine();

        for(int i = 0; i < cases; i++){
            String result = "";
            String s = myObj.nextLine();

            for(int j = 0;  j < s.length(); ){
                if(s.charAt(j) == '1'){
                   result += "(";
                    while(s.charAt(j) == '1') {
                        j++;
                        result += "1";
                        if(j >= s.length())
                            break;
                    }
                    result += ")";
                }else{
                    result += "0";
                    j++;
                }
            }

            System.out.println("Case #" + (i+1) +": " + result);

        }

    }
}
