import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		if(in.hasNextInt()){
		    int t = in.nextInt();
		    int x = 0;
			while(t--!=0) {
				if(in.hasNextInt()){
					int n = in.nextInt();
					String a[] = new String[n];
					int min = Integer.MAX_VALUE;
					int max  = Integer.MIN_VALUE;
					int maxindex = 0;
					int minindex = 0;
					for(int i=0;i<n;i++) {
						a[i] = in.next();
						if (a[i].length() < min) {
							min = a[i].length();
							minindex = i;
						}
						if(a[i].length() > max) {
							max = a[i].length();
							maxindex = i;
						}
					}
					int j  = 1;
					int flag = 0;
				
					while(j<=min-1) {
						
						char letter = a[minindex].charAt(a[minindex].length()-j);
						for(int i=0;i<n;i++) {
							if(a[i].charAt(a[i].length()-j) != letter) {
								flag = 1;
								break;
							}
							
						}
						j = j +1;
					}
					x = x+1;
					if(flag ==1) {
						System.out.println("Case #"+x+": *");
					}
					else {
						String word = a[maxindex].substring(1);
						System.out.println("Case #"+x+": "+word);
					}
					
					
					


				}
				
			}
			
		}
	}
}
