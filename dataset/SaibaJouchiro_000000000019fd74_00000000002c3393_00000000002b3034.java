import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 
class Pattern{      
       

    static boolean strmatch(String str, String pattern, 
                                 int n, int m) 
    { 
        if (m == 0) 
            return (n == 0); 
   
        boolean[][] lookup = new boolean[n + 1][m + 1]; 
       
        
        for(int i = 0; i < n + 1; i++) 
            Arrays.fill(lookup[i], false); 
          
       
        
        lookup[0][0] = true; 
       
        
        for (int j = 1; j <= m; j++) 
            if (pattern.charAt(j - 1) == '*') 
                lookup[0][j] = lookup[0][j - 1]; 
       
        
        for (int i = 1; i <= n; i++) 
        { 
            for (int j = 1; j <= m; j++) 
            { 
                
                if (pattern.charAt(j - 1) == '*') 
                    lookup[i][j] = lookup[i][j - 1] || 
                                   lookup[i - 1][j]; 
       
             
                else if (pattern.charAt(j - 1) == '?' || 
                    str.charAt(i - 1) == pattern.charAt(j - 1)) 
                    lookup[i][j] = lookup[i - 1][j - 1]; 
       
              
                else lookup[i][j] = false; 
            } 
        } 
       
        return lookup[n][m]; 
    } 
       
    public static void main(String args[]) 
    { 
    	Scanner sc=new Scanner(System.in);
		ArrayList<Boolean> al=new ArrayList<Boolean>();

		int t=sc.nextInt();

    	for(int t1=0;t1<t;t1++) {
    		int n=sc.nextInt();
    		String[] s=new String[n];
    		String[] strNew=new String[n];
    		ArrayList<Boolean> al1=new ArrayList<Boolean>();
    		for(int i=0;i<n;i++) {
    			s[i]=sc.next();
    		}
    		String longestString = getLongestString(s);
    		
        String str = longestString; 
        for(int i=0;i<s.length;i++) {
        String pattern = s[i]; 
   
       boolean sank = false;
        if (strmatch(str, pattern, str.length(), 
                             pattern.length())) {
             sank = true;
             al1.add(sank);
        }
        else {
   	     String m="case #"+(t1+1) + ":" + " " + "*"  ;
System.out.println(m);
        	break;
        }
        }
		String f = longestString.replace("*", "");

if(al1.size()==n) {
	     String m="Case #"+(t1+1) + ":" + " " + f;
	     System.out.println(m);
	     sc.nextLine();
    	}
       
    	}
    	
    } 
    public static String getLongestString(String[] array) {
	      int maxLength = 0;
	      String longestString = null;
	      for (String s : array) {
	          if (s.length() > maxLength) {
	              maxLength = s.length();
	              longestString = s;
	          }
	      }
	      return longestString;
	  }
}