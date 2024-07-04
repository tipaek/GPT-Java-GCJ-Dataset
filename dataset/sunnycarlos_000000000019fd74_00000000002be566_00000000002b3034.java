import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sbuilder=new StringBuilder();
        int testC=1;
        while(t-->0){
            int n=sc.nextInt();
            boolean w =true;
            String c[]=new String[n];
            for (int i=0;i<n;i++){
                c[i]=sc.next();
                if (c[i].length()!=1)w=false;
            }
            int str[]=new int[n];
            int foo=-1;
            int ind=-1;
            for (int i=0;i<n;i++){
                for (int j=0;j<c[i].length();j++){
                    if (c[i].charAt(j)=='*'){
                        str[i]=j;
                        if (c[i].length()-str[i]>foo){
                            foo=c[i].length()-str[i];
                            ind=i;
                        }
                        break;
                    }
                }
            }
            boolean f=true;
            for (int i=0;i<n;i++){
                int l=c[ind].length()-1;
                for (int j=c[i].length()-1;j>=0;j--){
                    if (j==str[i])break;
                    if (c[i].charAt(j)!=c[ind].charAt(l--)){
                        f=false;
                        break;
                    }
                }
            }
            if (!f){
                sbuilder.append("Case #"+testC+": *");
                if (testC!=t)sbuilder.append("\n");
                continue;
            }
            foo=-1;
            int ind1=-1;
            for (int i=0;i<n;i++){
                if (foo<str[i]){
                    foo=str[i];
                    ind1=i;
                }
            }
            f=true;
            for (int i=0;i<n;i++){
                for (int j=0;j<c[i].length();j++){
                    if (j==str[i])break;
                    if (c[i].charAt(j)!=c[ind1].charAt(j)){
                        f=false;
                        break;
                    }
                }
            }
            StringBuilder temp=new StringBuilder();
            if (!f){
                sbuilder.append("Case #"+testC+": *");
                sbuilder.append("\n");
                continue;
            }
            temp.append(c[ind1].substring(0,str[ind1])+c[ind].substring(str[ind]+1));
            if (w)temp.append('A');
            sbuilder.append("Case #"+testC+": "+temp);
            sbuilder.append("\n");
            testC++;
        }
        System.out.print(sbuilder);
    }
}