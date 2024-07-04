import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){

                String str=br.readLine();
                StringBuilder ans=new StringBuilder("");

                for(int j=0;j<str.length();j++){
                    if(j==0){
                        for(int k=0;k<Integer.parseInt(String.valueOf(str.charAt(j)));k++){
                            ans.append("(");
                        }
                        ans.append(str.charAt(j));
                    }else{
                        int a=Integer.parseInt(String.valueOf(str.charAt(j-1)));
                        int b=Integer.parseInt(String.valueOf(str.charAt(j)));
                        if(a>b){
                            for(int k=0;k<a-b;k++){
                                ans.append(")");
                            }
                        }else{
                            for(int k=0;k<b-a;k++){
                                ans.append("(");
                            }
                        }
                        ans.append(str.charAt(j));
                    }
                }
                for(int k=0;k<Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));k++){
                    ans.append(")");
                }

                System.out.println("case #"+(i+1)+": "+ans);


            }
        }catch(Exception e){
            System.out.println("kkkk "+e.getMessage());
        }
    }
}
