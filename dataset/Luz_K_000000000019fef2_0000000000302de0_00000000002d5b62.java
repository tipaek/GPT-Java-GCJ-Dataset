import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      String output = findJump(0,0,"",1,n,m);
      System.out.println("Case #" + i + ": " + output);
    }
  }
  public static String findJump(long positionx,long positiony,String output,long jumplength,int goalx,int goaly) {
	  if(positionx == goalx && positiony == goaly) {
		  return output;
	  }
	  if(jumplength > 500) {
		  return "IMPOSSIBLE";
	  }
	  
	  int answerlength = 1000000;
	  String answer = "IMPOSSIBLE";
	  //System.out.println(jumplength);
	  String answer1= findJump(positionx + jumplength,positiony,output + "E",jumplength * 2,goalx,goaly);
	  String answer2= findJump(positionx - jumplength,positiony,output + "W",jumplength * 2,goalx,goaly);
	  String answer3= findJump(positionx ,positiony+ jumplength,output + "N",jumplength * 2,goalx,goaly);
	  String answer4= findJump(positionx ,positiony- jumplength,output + "S",jumplength * 2,goalx,goaly);
	  /*System.out.println(output);
	  System.out.println(positionx + " " + positiony);
	  System.out.println("asnwer1: " + answer1);
	  System.out.println("asnwer2: " + answer2);
	  System.out.println("asnwer3: " + answer3);
	  System.out.println("asnwer4: " + answer4);*/
	  if(answer1.length() < answerlength && !answer1.equals("IMPOSSIBLE")){
		 answer = answer1;
		 answerlength = answer1.length();
	  }
	  if(answer2.length() < answerlength && !answer2.equals("IMPOSSIBLE")){
			 answer = answer2;
			 answerlength = answer2.length();


		  }
	  if(answer3.length() < answerlength && !answer3.equals("IMPOSSIBLE")){
			 answer = answer3;
			 answerlength = answer3.length();


		  }
	  if(answer4.length() < answerlength && !answer4.equals("IMPOSSIBLE")){
			 answer = answer4;

			 answerlength = answer4.length();

		  }
	  
	  
	  return answer;
  }
}