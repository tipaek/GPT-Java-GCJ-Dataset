import java.util.*;
import java.io.*;
public class Solution {

    static String ans(String str){
        String ss = "";
        if(str.length()==1){
            int n= (int)str.charAt(0) - 48;
            for(int k=0;k<n;k++){
                //System.out.print("(");
                ss += "(";
            }
            System.out.print(n);
            for(int k=0;k<n;k++){
               // System.out.print(")");
               ss += ")";
            }
            return ss;
        }
        boolean v[] = new boolean[str.length()];
        for(int i=0;i<str.length()-1;i++){
            if(v[i]){
                continue;
            }
            else{
                v[i] = true;
                if(((int) str.charAt(i))==48){
                    System.out.print(0);
                    continue;
                }
                int n = (int)str.charAt(i) - 48;
                int till = 0,h;

                for(h=i+1;h<str.length();h++){
                    if(((int)str.charAt(h) - 48)!=n){
                        till = h-1;
                        break;
                    }
                    else
                    v[h] = true;
                }
                
                if(till==0 && h==str.length()){
                    for(int k=0;k<n;k++){
                        //System.out.print("(");
                        ss += "(";
                    }
                    //System.out.print(n);
                    ss += ""+n;
                    for(int k=0;k<n;k++){
                        //System.out.print(")");
                        ss += ")";
                    }
                    return ss;
                }
                
                if(i==0 || n>((int)str.charAt(i-1) - 48)){
                    for(int j=0;j<n;j++){
                       // System.out.print("(");
                       ss += "(";
                    }
                }
                /*if(till == 0)
                    System.out.print(n);
                else{*/
                    for(int j=0;j<=till-i;j++){
                        //System.out.print(n);
                        ss += ""+n;
                    }
                //}

                int next = (int)str.charAt(till+1) - 48;
                if(next<n){
                    int diff = Math.abs(next-n);
                    for(int j=0;j<diff;j++){
                        //System.out.print(")");
                        ss += ")";
                    }
                }

            }
        }
        int x=0;
        if(v[str.length()-1]){

        }
        else{
            v[str.length()-1] = true;
            if(((int) str.charAt(str.length()-1))==48){
                x=1;
                //System.out.print(0);
                ss += ""+0;
            }
            if(x==0){
                int n = (int)str.charAt(str.length()-1) - 48;
                if(n>((int)str.charAt(str.length()-2) - 48)){
                    for(int j=0;j<n;j++){
                        //System.out.print("(");
                        ss += "(";
                    }
                }
                System.out.print(n);
                int q=0,z;
                for(z=str.length()-1;z>-1;z--){
                    if(((int)str.charAt(z) - 48) >n){
                       q = (int)str.charAt(z) - 48;
                       break;
                    }
                }
                if(q==0){
                    for(int k=0;k<n;k++){
                       // System.out.print(")");
                       ss += ")";
                    }
                }
                else{
                    for(int k=0;k<n;k++){
                        //System.out.print(")");
                        ss += ")";
                    }
                    if(!(Math.abs(n - ((int)str.charAt(z) - 48)) == n)){
                        for(int k=0;k<Math.abs(n - ((int)str.charAt(z) - 48));k++){
                            //System.out.print(")");
                            ss += ")";
                        }
                    }
                }
            }

        }
        return ss;
    }

    public static void main(String args[]){
        Scanner s= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            String str = s.next();
            String ss = ans(str);
            System.out.println("Case #"+(i+1)+": "+ss);
        }
    }
}
