import java.util.Scanner;

public class Solution {

	static String[] sortByLength(String[] stringarray) {
		for(int i=1;i<stringarray.length;i++) {
			String temp = stringarray[i];
			int j = i-1; 
	        while (j>=0&&temp.length()<stringarray[j].length()) 
	        { 
	        	stringarray[j+1] = stringarray[j]; 
	            j--; 
	        } 
	        stringarray[j+1] = temp; 
		}
		return stringarray;
	}
	
	static boolean isEndSubstring(String s1,String s2) {
		if(s2.contains(s1)&&s2.charAt(s2.length()-1)==s1.charAt(s1.length()-1)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0;c<cases;c++){
			int n = sc.nextInt();
			String[] patterns = new String[n];
			boolean impossible = false;
			for(int i=0;i<n;i++){
				patterns[i]=sc.next();
			}
			patterns = sortByLength(patterns);
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++) {
					if(!isEndSubstring(patterns[i].split("\\*")[1],patterns[j].split("\\*")[1])) {
						impossible = true;
					}
				}
			}
			if(impossible==true) {
				System.out.printf("Case #%d : *\n",c+1);
			}else {
				System.out.printf("Case #%d : %s\n",c+1,patterns[n-1].split("\\*")[1]);
			}
		}
		sc.close();
	}
	
}
