import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 1; i<= t; i++){
            int n = 0;
            String res = "";
            String s = in.next();
            
            char[] sToArray = s.toCharArray();
            for(int k = 0; k< s.length(); k++){

                    int a = Integer.parseInt(String.valueOf(sToArray[k]));
                    if(n<a){

                        for(int j = 0; j < a -n; j++) {
                            res += "(";
                        }
                        n = a;
                        res += sToArray[k];

                    }
                    else if(n == a){
                        res += sToArray[k];
                    }
                    else if(n > a){

                        for(int j = 0; j < n-a; j++){
                            res += ")";
                        }
                        n=a;
                        res += sToArray[k];

                    }
                    if(k == s.length()-1){
                        for(int j = 0; j < n; j++){
                            res += ")";
                        }
                    }
            }

            System.out.println("Case #"+ i+ ": " + res);



        }
    }

}
