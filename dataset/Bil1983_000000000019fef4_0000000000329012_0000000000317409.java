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
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
	static Scanner sc;
	static StringBuffer s;
	
  public static void main(String[] args)throws Exception{
	  //sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt"))))); 
    
     int t = sc.nextInt();
     
	 for(int test = 1;test<=t;test++){ 	   	 	
	 	solve(test);
	 }   
	 
  }
  
  static void solve (int test) {
	  int X = sc.nextInt();
	  int Y = sc.nextInt();
  
	  String path = sc.next();

	  if(X == 0 && Y == 0) {
		  System.out.println("Case #"+test+": "+0);
		  return;
	  }
	  
	  int t = (X+Y) %2;
	  
	  if (t ==1) {
		  switch(path.charAt(0)) {
		  	case 'N':
		  		Y++;
		  		break;
		  	case 'S':
		  		Y--;
		  		break;
		  	case 'E':
		  		X++;
		  		break;
		  	case 'W':
		  		X--;
		  		break;
		  	default:
		  		break;
		  }
		  if (X == 0 && Y==0) {
			  System.out.println("Case #"+test+": "+1); return;
		  }
		  
		  for (int i = 1; i<path.length(); i++) {
			  
			  switch(path.charAt(i)) {			  		
			  	case 'S':
			  		if(X==0)
			  			Y-=2;
			  		else {
				  		Y--;
				  		X--;
			  		}
			  		break;
			  	case 'W':
			  		if(Y==0) {
			  			X-=2;
			  		}else {
				  		X--;
				  		Y--;
			  		}
			  		break;
			  	default:
			  		break;
			  } 
			  if (X == 0 && Y==0) {
				  System.out.println("Case #"+test+": "+(i+1)); return;
			  }
		  }
	  }else {
		  for (int i = 0; i<path.length(); i++) {
			  switch(path.charAt(i)) {			  		
			  	case 'S':
			  		if(X==0)
			  			Y-=2;
			  		else {
				  		Y--;
				  		X--;
			  		}
			  		break;
			  	case 'W':
			  		if(Y==0) {
			  			X-=2;
			  		}else {
				  		X--;
				  		Y--;
			  		}
			  		break;
			  	default:
			  		break;
			  } 
			  if (X == 0 && Y==0) {
				  System.out.println("Case #"+test+": "+(i+1)); return;
			  }
		  }
	  }

	  //
	  System.out.println("Case #"+test+": "+"IMPOSSIBLE");
  }
  
  }