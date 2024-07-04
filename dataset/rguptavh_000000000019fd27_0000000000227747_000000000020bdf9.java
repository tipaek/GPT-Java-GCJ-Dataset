import java.util.*;
class Solution {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int x = scan.nextInt();
      for (int y=0; y<x;y++) {
    	  int z= scan.nextInt();
    	  int[][] arr = new int[z][3];
    	  for (int a=0; a<z; a++) {
    		  for (int b=0 ; b<2; b++) {
    			  arr[a][b] = scan.nextInt();
    		  }
   			  arr[a][2] = a;
    	  }
    	  ArrayList<String> perms = new ArrayList<String>();
    	  for (int a=0; a<=z/2;a++) {
    		  String repeated = new String(new char[a]).replace("\0", "c");
    		  String repeated1 = new String(new char[z-a]).replace("\0", "j");
    	  printDistinctPermutn(repeated+repeated1,"", perms);
    	  }
    	  Arrays.sort(arr,(int[] a, int[] b)->a[1]-b[1]);
    	  String ans = "";
    	  for (int b=0; b<perms.size();b++) {
    		  boolean im = false;
    		  int s1=-1;
			  int s2=-1;
    		  for (int c=0; c<z;c++) {
    			  String s = perms.get(b);
    			  
    	    		if (s.charAt(c)=='c') {
    	    			  if (s1==-1) {
    	    				  s1 = arr[c][1];
    	    			  }
    	    			  else if (arr[c][0]<s1) {
    	    				  im = true;
    	    				  break;
    	    			  }
    	    			  else {
    	  	    				s1 = arr[c][1];
    	  	    			  }
    	    		  }
    	    		if (s.charAt(c)=='j') {
  	    			  if (s2==-1) {
  	    				  s2 = arr[c][1];
  	    				

  	    			  }
  	    			  else if (arr[c][0]<s2) {
  	    				  im = true;
  	    				
  	    				  break;
  	    			  }
  	    			  else {
  	    				s2 = arr[c][1];
  	    			  }
  	    		  }
    		  }
    		  if (!im) {
    			  ans = perms.get(b);
    			  break;
    		  }
    	  }
    	  String real = "";
    	  if (ans.equals("")) {
    		 real = "IMPOSSIBLE";
    	  }
    	  else {
    	  char[] fix = new char[z];
    	  for (int d=0; d<z;d++) {
    		  fix[arr[d][2]] = ans.charAt(d);
    	  }
    	  for (int d=0; d<z;d++) {
    		  real += fix[d];
    	  }
    	  }
    	 System.out.println("Case #" + (y+1) + ": " + real.toUpperCase());
  }
  }
  static void printDistinctPermutn(String str,  
          String ans, ArrayList<String> s) 
{ 

// If string is empty 
if (str.length() == 0) { 

// print ans 
s.add(ans); 
return; 
} 

// Make a boolean array of size '26' which 
// stores false by default and make true  
// at the position which alphabet is being 
// used 
boolean alpha[] = new boolean[26]; 

for (int i = 0; i < str.length(); i++) { 

// ith character of str 
char ch = str.charAt(i); 

// Rest of the string after excluding  
// the ith character 
String ros = str.substring(0, i) +  
str.substring(i + 1); 

// If the character has not been used  
// then recursive call will take place.  
// Otherwise, there will be no recursive 
// call 
if (alpha[ch - 'a'] == false) 
printDistinctPermutn(ros, ans + ch, s); 
alpha[ch - 'a'] = true; 
} 
} 
}