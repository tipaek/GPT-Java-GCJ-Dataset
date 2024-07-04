import java.lang.System;
import java.util.Scanner;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num,diff,prev;
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            String res=""; 
            prev=0; num=0; diff=0;
            //sc.skip(2);
            String S=sc.next();
            for(int i = 0; i < S.length(); i++) {
                num = Character.getNumericValue(S.charAt(i));
                diff = num-prev;
                if(diff ==0 ){
                    res += S.charAt(i);
                }
                else if(diff > 0){
                    for(int j=0;j<diff;j++)
                            res += '(';
                        res+=S.charAt(i);
                }
                else{
                        for(int j=0;j<(-diff);j++)
                            res += ')';
                        res+=S.charAt(i);
                }  
                prev=num; 
            }
            if(prev>0){
                for(int j=0;j<prev;j++)
                    res += ')';
            }
           System.out.println("Case #"+t+": "+res);
        }
    }
}