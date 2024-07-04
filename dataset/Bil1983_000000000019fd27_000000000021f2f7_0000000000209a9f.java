import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	static Scanner sc;
  public static void main(String[] args)throws Exception{
	  sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  //sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt"))))); 
    
     int t = sc.nextInt();
     sc.nextLine();
    for(int test = 1;test<=t;test++){
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
    	String s = sc.nextLine();
    	List<String> list = cut(s);
    	String result = "";
    	for (String st: list) {
    		if (st.charAt(0)=='0')
    			 result = result + st;
    		else result = result+"("+st+")";
    	}
    	System.out.println("Case #"+test+": "+result);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }

    
    
  }
  static List<String> cut(String s){
      List<String> result = new ArrayList<>();
      StringBuilder buf = new StringBuilder(); 
      for (int i = 0; i < s.length(); i++){
      	buf.append(s.charAt(i)); 
          if (i == s.length() - 1|| buf.charAt(0) != s.charAt(i + 1)) {
              result.add(buf.toString());
              buf = new StringBuilder();
          }
      }
      return result;
  }
}