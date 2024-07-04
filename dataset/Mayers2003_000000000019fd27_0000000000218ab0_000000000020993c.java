import java.util.*;
public class Solution{
    public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in).useDelimiter("\\n");;
		int nC = stdin.nextInt();
	    
	    char[][] temp;
	    boolean[] t;
		for (int x=1; x<=nC; x++) {
		    int r = 0;
	        int c = 0;
	        int ans = 0;
			int n = stdin.nextInt();
			//System.out.println(n);
			t = new boolean[n];
			temp = new char[n][n];
			for(int i = 0; i < n; i++){
			    String s = stdin.next();
			    s = s.replaceAll("\\s",""); 
			    if(!uniqueCharacters(s)){
			        r++;
			    }
			    
			    temp[i] = s.toCharArray();
			    
			    ans += Character.getNumericValue(s.charAt(i));
			}
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(t, false);
				for(int j = 0; j < n; j++) {
					if(t[ Character.getNumericValue(temp[j][i] - 1)]) {
						c++;
						break;
					}else {
						t[ Character.getNumericValue(temp[j][i] - 1)] = true;
					}
				}
			}
			
			System.out.println("Case #"+ x + ": "+ ans + " " + r + " " + c);
		}
		
		stdin.close();
	}
	
	static boolean uniqueCharacters(String s) 
    { 
		int checker = 0; 
		  
        for (int i = 0; i < s.length(); i++) { 
            int bitAtIndex = s.charAt(i) - 'a'; 
            
            if ((checker & (1 << bitAtIndex)) > 0) 
                return false; 
  
            checker = checker | (1 << bitAtIndex); 
        } 
  
        return true; 
    } 
}