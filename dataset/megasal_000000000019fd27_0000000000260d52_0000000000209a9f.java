import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //int trace=0;
        int t=in.nextInt();
        String s;
        s=in.nextLine();
        for(int k=0;k<t;k++) {
            s=in.nextLine();
            ArrayList<String> str=new ArrayList<>();
            for(int i=0;i<s.length();i++){
                if(i==0){
                    //System.out.println((int)s.charAt(i)-48);
                    for(int x=0;x<(int)s.charAt(i)-48;x++)
                        str.add("(");
                    str.add(s.charAt(i)+"");
                    if(i==s.length()-1){
                        for(int x=0;x<(int)s.charAt(i)-48;x++)
                            str.add(")");
                    }

                }
                else{
                    if((int)s.charAt(i)<(int)s.charAt(i-1)){
                        for(int x=0;x<(int)s.charAt(i-1)-(int)s.charAt(i);x++)
                            str.add(")");
                        str.add(s.charAt(i)+"");

                    }
                    else if((int)s.charAt(i)>(int)s.charAt(i-1)){
                        for(int x=0;x<(int)s.charAt(i)-(int)s.charAt(i-1);x++)
                            str.add("(");
                        str.add(s.charAt(i)+"");
                    }
                    else{
                        str.add(s.charAt(i)+"");
                    }
                    if(i==s.length()-1){
                        for(int x=0;x<(int)s.charAt(i)-48;x++)
                            str.add(")");
                    }
                }

            }
            StringBuilder out= new StringBuilder();
            for (String value : str) {
                out.append(value);
            }
            System.out.println("Case #"+(k+1)+": "+ out);
        }
    }
}

