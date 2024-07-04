import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        int T=s.nextInt();//input number of test cases
        int testCasenumber=1;
        while(testCasenumber<=T){
            String str=s.next();
            String ans="Case #"+testCasenumber+": "+helper(str);
            System.out.println(ans);
            testCasenumber++;
        }
        s.close();
    }
    static String helper(String str1)
    {
        if(str1.length()==0)return "";// if no value found
        
        int j=1;
        while(j < str1.length() && str1.charAt(j) == str1.charAt(j-1)) j++;
        if(j==str1.length()){
            if(str1.charAt(0)=='0')return str1;
            else return "("+ str1 +")";
        }
        else{
            if(str1.charAt(0)=='0'){
                return str1.substring(0,j)+helper(str1.substring(j));
            }
            else{
                return "(" + str1.substring(0,j) + ")" + helper(str1.substring(j));
            }
        }
    }
}