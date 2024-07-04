import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scr.nextInt();
        String[] out = new String[t];
        for(int i = 0 ; i < t ; i++ ){
            String in = scr.next();
            out[i] = getBalancedString(in);

            System.out.println("Case #"+(i+1)+": "+out[i]);

        }
    }

    public static String getBalancedString(String initial){
        char[] init = initial.toCharArray();
        String toRet="";
        int balance = 0;
        int i; //indice para el original
        int j = 0;//indice para el output
        for( i = 0 ; i < initial.length() ; i++){

            if( i == 0 ){
                for(int k = '0' ; k < init[i] ; k ++){
                    toRet = toRet.concat("(");
                    balance++;
                }
            }

            if(i != initial.length()-1){

                toRet = toRet.concat(String.valueOf(init[i]));

                if(init[i] < init[i+1]){
                    for(int k = init[i] ; k < init[i+1] ; k++){
                        toRet = toRet.concat("(");
                        balance++;
                    }
                }else{
                    if(init[i] > init[i+1]){
                        for(int k = init[i+1] ; k < init[i] ; k++){
                            toRet = toRet.concat(")");
                            balance--;
                        }
                    }
                }
            }
            if( i == init.length-1 ){
                toRet = toRet.concat(String.valueOf(init[i]));
                while(balance != 0){
                    toRet = toRet.concat(")");
                    balance--;
                }
            }

        }


        return toRet;
    }
}
