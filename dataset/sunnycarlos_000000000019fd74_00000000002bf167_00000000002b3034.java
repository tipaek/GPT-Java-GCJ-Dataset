import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sbuilder=new StringBuilder();
        int testC=1;
        for (;testC<=t;testC++){
            int n=sc.nextInt();boolean w =true;boolean f=true; int fedu=-1;int index=-1;int str[]=new int[n];
            String s[]=new String[n];
            for (int i=0;i<n;i++){
                s[i]=sc.next();
                if (s[i].length()!=1)w=false;
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<s[i].length();j++){
                    if (s[i].charAt(j)=='*'){
                        str[i]=j;
                        if (s[i].length()-str[i]>fedu){
                            fedu=s[i].length()-str[i];
                            index=i;
                        }
                        break;
                    }
                }
            }
            for (int i=0;i<n;i++){
                int l=s[index].length()-1;
                for (int j=s[i].length()-1;j>=0;j--){
                    if (j==str[i])break;
                    if (s[i].charAt(j)!=s[index].charAt(l--)){
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
            fedu=-1;
            int ind1=-1;
            for (int i=0;i<n;i++){
                if (fedu<str[i]){
                    fedu=str[i];
                    ind1=i;
                }
            }
            f=true;
            for (int i=0;i<n;i++){
                for (int j=0;j<s[i].length();j++){
                    if (j==str[i])break;
                    if (s[i].charAt(j)!=s[ind1].charAt(j)){
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
            StringBuilder temp=new StringBuilder();
            temp.append(s[ind1].substring(0,str[ind1])+s[index].substring(str[index]+1));
            if (w)temp.append('A');
            sbuilder.append("Case #"+testC+": "+temp);
            if (testC!=t)sbuilder.append("\n");
        }
        System.out.print(sbuilder);
    }
}