import java.util.*;
import java.io.*;
public class Solution{
public static void main (String[]args){
    Scanner scan = new Scanner(System.in);
    int tests=Integer.parseInt(scan.nextLine());
    for(int i=0;i<tests;i++){
   
    String input=scan.nextLine();
    String result=input;
    int max=0;
    for(int j=0;j<input.length();j++){
        if(Character.getNumericValue(input.charAt(j))>max){
            max=Character.getNumericValue(input.charAt(j));
        }
    }
    for(int j=0;j<max;j++){
        StringTokenizer st=new StringTokenizer(result,j+"",true);
        result="";
        while(st.hasMoreTokens()){
            String curr=st.nextToken();
            if(!curr.contains(j+"")){
                String newstring="("+curr+")";
                result+=newstring;
            }
            else{
                result+=curr;
            }
            
        }
    }
    int curcase=i+1;
    System.out.println("Case #"+curcase+": "+result);
    }
    
    
    
    
    
    }
}

