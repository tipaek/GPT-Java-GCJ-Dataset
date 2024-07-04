import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.Math;
class Solution{
    public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=1;i<=t;i++){
        String s=sc.next(); int n=s.length();
        int openP=0;
        StringBuilder str = new StringBuilder();
        for(int j=0;j<n;j++){
            int tmp=Character.getNumericValue(s.charAt(j));
            if(tmp>openP){
                for(int k=openP;k<tmp;k++){
                    str.append('(');
                }
            }
            else if(openP>tmp){
                for(int k=tmp;k<openP;k++){
                    str.append(')');
                }
            }
            openP=tmp;
            str.append(tmp);            
        }
        if(openP>0){
            for(int k=0;k<openP;k++){
                str.append(')');
            }
        }
        System.out.println("Case #"+i+": " + str.toString());
    }
    }
}