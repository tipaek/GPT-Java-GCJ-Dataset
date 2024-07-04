import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
	 int t =0; // Number of test cases
        String s; // read the line of String
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        String[] ans=new String[t];
        String news="";
        boolean onefound=false;
        for(int i=0;i<t;i++){
            onefound=false;
            s=reader.nextLine();
            for(int j=0;j<s.length();j++){
                if(Integer.parseInt(s.substring(j,j+1))==1 && onefound==false){
                    news+="(";
                    onefound=true;
                }else if(Integer.parseInt(s.substring(j,j+1))==0){
                    if(onefound==true) {
                        news += ")";
                    }
                    onefound=false;
                }
                news+=s.substring(j,j+1);
                if(j==s.length()-1 && Integer.parseInt(s.substring(j,j+1))==1){
                    news+=")";
                }
            }
        ans[i]= "Case #"+(i+1) +": " + news;
        news="";
        }
        for(int l=0;l<t;l++){
            System.out.println(ans[l]);
        }
    }
}