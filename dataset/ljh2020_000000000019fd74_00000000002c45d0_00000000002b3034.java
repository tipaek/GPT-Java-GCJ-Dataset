
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
    	System.out.print("Case #" + i + ": ");
      	solve(in);
    }
  }
  public static void solve(Scanner in){	 
	  int n = in.nextInt();
	  ArrayList<String> arr = new ArrayList<String>();
	  String ret = "";
	  boolean allFirst = true;
	  boolean onlyOne = true;
	  for(int i = 0; i < n; i++) {
		  String str = in.next();
		  arr.add(str);
		  if(str.indexOf("*") != 0) allFirst = false;
		  //if(str.substring(str.indexOf("*")+1).indexOf("*") != -1) onlyOne = false;
		  
	  }
	  if(allFirst) {
		  ret = caseOne(arr);
		  System.out.println(ret);
		  return;
	  }
	  if(onlyOne) {
		  ArrayList<String> toBack = new ArrayList<String>();
		  ret = caseTwo(arr, toBack);
		  /*System.out.println(toBack.size());
		  Iterator<String> i = toBack.iterator();
		  while(i.hasNext()) {
			  String str = i.next();
			  System.out.println(str);
		  }*/
		  ret = ret + caseOne(toBack);
		  if(ret.contains("*")) {
			  System.out.println("*");
			  return;
		  }
		  System.out.println(ret);
		  return;
	  }
	  
	  
  }
  public static String caseOne(ArrayList<String> arr) {
	  int countFromBack = 1;
	  String ret = "";
	  while(arr.size() != 0) {
		  char common = ' ';
		  Iterator<String> i = arr.iterator();
		  while(i.hasNext()) {
			  String str = i.next();
			  if(str.charAt(str.length()-countFromBack) == '*') {
				  i.remove();
				  continue;
			  }
			  if(common == ' ') {
				  common = str.charAt(str.length()-countFromBack);
				  continue;
			  }
			  if(str.charAt(str.length()-countFromBack) != common) {
				  return "*";
			  }
		  }
		  countFromBack++;
		  if(common != ' ')
			  ret = common + ret;
	  }
	  return ret;
  }
  public static String caseTwo(ArrayList<String> arr, ArrayList<String> toBack) {
	  int countFromFront = 0;
	  String ret = "";
	  while(arr.size() != 0) {
		  char common = ' ';
		  Iterator<String> i = arr.iterator();
		  while(i.hasNext()) {
			  String str = i.next();
			  if(str.charAt(countFromFront) == '*') {
				  toBack.add(str.substring(countFromFront));
				  i.remove();
				  continue;
			  }
			  if(common == ' ') {
				  common = str.charAt(countFromFront);
				  continue;
			  }
			  if(str.charAt(countFromFront) != common) {
				  return "*";
			  }
		  }
		  countFromFront++;
		  if(common != ' ')
			  ret += common;
	  }
	  return ret;

  }

}