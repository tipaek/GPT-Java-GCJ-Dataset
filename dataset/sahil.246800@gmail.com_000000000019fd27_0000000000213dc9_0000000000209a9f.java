import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++){
            StringBuffer finalStr = new StringBuffer();
            String str = sc.next();
            StringBuffer s = new StringBuffer(); 
            for(int j =0; j<str.length()-1;j++)
            {
                s.append(str.charAt(j));
                if(str.charAt(j)!=str.charAt(j+1)){
                    int a = Integer.parseInt(""+str.charAt(j));
                    StringBuffer stra = new StringBuffer();
                    StringBuffer strb = new StringBuffer();
                    for(int h=0; h<a; h++){
                        stra.append("(");
                        strb.append(")");
                    }
                    finalStr.append(stra).append(s).append(strb);
                    s = new StringBuffer();
                }
            }
            if(str.length()>=2){
                if(str.charAt(str.length()-1)==str.charAt(str.length()-2)){
                    s.append(str.charAt(str.length()-1));
                    int a = Integer.parseInt(""+str.charAt(str.length()-1));
                    StringBuffer stra = new StringBuffer();
                    StringBuffer strb = new StringBuffer();
                    for(int h=0; h<a; h++){
                        stra.append("(");
                        strb.append(")");
                    }
                    finalStr.append(stra).append(s).append(strb);
                }
                else{
                    s = new StringBuffer();
                    s.append(str.charAt(str.length()-1));
                    int a = Integer.parseInt(""+str.charAt(str.length()-1));
                    StringBuffer stra = new StringBuffer();
                    StringBuffer strb = new StringBuffer();
                    for(int h=0; h<a; h++){
                        stra.append("(");
                        strb.append(")");
                    }
                    finalStr.append(stra).append(s).append(strb);
                    
                }
            }
            else{
                s = new StringBuffer();
                s.append(str.charAt(str.length()-1));
                int a = Integer.parseInt(""+str.charAt(str.length()-1));
                StringBuffer stra = new StringBuffer();
                StringBuffer strb = new StringBuffer();
                for(int h=0; h<a; h++){
                    stra.append("(");
                    strb.append(")");
                }
                finalStr.append(stra).append(s).append(strb);
            }
            System.out.println("Case #"+i+": "+finalStr);
        }
    }
}