import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;
        while(x<=test){
            ArrayList<String> strings=new ArrayList<String>();
            int n=sc.nextInt();
            sc.nextLine();
            int max=Integer.MIN_VALUE;
            String in;
            String maxS="";
            for(int i=0;i<n;i++){
                in=sc.nextLine();
                strings.add(in);
                if(in.length()>max){
                    max=in.length();
                    maxS=in;
                }
            }
            Solution obj=new Solution();
                
                for(int j=0;j<n;j++){
                    
                    if(!obj.match(maxS,strings.get(j))){
                        System.out.println("Case #"+x+": *");
                        return;
                    }
                    
                }
                System.out.println("Case #"+x+":"+ maxS.substring(1));

            x++;
        }
    }
    

    boolean match(String s1,String s2){
        
        if((s1.indexOf("*")==s1.length()-1 && s2.indexOf("*")==0) || (s1.indexOf("*")==0 && s2.indexOf("*")==s2.length()-1)){
            return true;
        }
        else if(s1.indexOf("*")==0 && s2.indexOf("*")==0){
            if(s1.substring(1).indexOf(s2.substring(1))>=0 && s1.substring(1).indexOf(s2.substring(1))==s1.length()-s2.length()){
                
                return true;
            }
            return false;
        }
        else if(s1.indexOf("*")==s1.length()-1 && s2.indexOf("*")==s2.length()-1){
            if(s1.substring(0,s1.length()-1).contains(s2.substring(0,s2.length()-1))){
                return true;
            }
            return false;
        }
        return false;
    }
}

