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
	  //sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt"))))); 
    
     int t = sc.nextInt();
     sc.nextLine();
    for(int test = 1;test<=t;test++){
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
    	List<String> list = new ArrayList<String>();
    	int a = sc.nextInt();
    	sc.nextLine();
    	for(int i = 0; i<a ; i++) {
    		list.add(sc.nextLine());
    	}
    	
    	for (int i = 0; i<a; i++) {
    		list.set(i,list.get(i).replaceAll("[*]", "[AZ]"));
    	}
    	
    	System.out.println("Case #"+test+": ");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }

    
    
  }
}