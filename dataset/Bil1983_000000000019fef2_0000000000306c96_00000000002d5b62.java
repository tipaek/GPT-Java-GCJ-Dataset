import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
	static Scanner sc;
	static StringBuffer s;
	static List<String> list = new ArrayList<String>();
  public static void main(String[] args)throws Exception{
	  sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  //sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt"))))); 
    
     int t = sc.nextInt();
     
	    for(int test = 1;test<=t;test++){ 	   	 	
	    		solve(test);
	    }   
  }
  
  static void solve (int test) {
	  
	  char[] te = {'N','S','E','W'};
	  int X = sc.nextInt();
	  int Y = sc.nextInt();
	  int N =(int) (Math.log( Math.max(Math.abs(X),Math.abs(Y)) )/Math.log(2))+2;
	  String s,buf;
	  long pos;
	  for(int i = N/2; i<=N;i++ ){
		 pos = (int) Math.pow(4, i);
		 for (long j =0; j< pos; j++ )  {
			 s = String.format("%0"+String.valueOf(i)+"d",Long.valueOf(Integer.toString(j,4))); 
			 s = s.replaceAll("0", "N");
			 s = s.replaceAll("1", "E");
			 s = s.replaceAll("2", "S");
			 s = s.replaceAll("3", "W");
			 if (move(s)[0] == X && move(s)[1] == Y) {
   			  System.out.println("Case #"+test+": "+s);
   			  return;
   		  }
		 }
		  
	  }  
		  

	  
	  //
	  System.out.println("Case #"+test+": "+"IMPOSSIBLE");
	  
  }
  

static void printAllKLength(char[] set, int k) 
	{ 
	    int n = set.length;  
	    printAllKLengthRec(set, "", n, k); 
	} 	
	
static void printAllKLengthRec(char[] set, String prefix, int n, int k)   { 
	  if (k == 0){ 
		list.add(prefix); 
		return; 
	   } 

	for (int i = 0; i < n; ++i)	{ 
		String newPrefix = prefix + set[i];  
		printAllKLengthRec(set, newPrefix,  n, k - 1);  
	} 
} 
  
 static int[] move( String s) {
	 
	 int[] tab = new int[2];
	 for (int i = 0; i<s.length(); i++) {
		 switch(s.charAt(i)) {
			 case 'N' :
				 tab[1]+= Math.pow(2, i);
				 break;
			 case 'S':
				 tab[1]-= Math.pow(2, i);
				 break;
			 case 'E' :
				 tab[0]+= Math.pow(2, i);
				 break;
			 case 'W':
				 tab[0]-= Math.pow(2, i);
				 break;
		 }
	 }
	 
	 
	 return tab;
	 
 }
 
}