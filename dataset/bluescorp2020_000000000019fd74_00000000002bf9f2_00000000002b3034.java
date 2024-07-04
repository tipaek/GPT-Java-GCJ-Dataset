import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	private static void solve(Scanner scanner){
		int n=scanner.nextInt();
		scanner.nextLine();
		String[] patterns = new String[n];
		String lr[][]=new String[n][2];
		int left=0, right=0, lidx=0, ridx=0;
		for(int i=0;i<n;i++){
			patterns[i]=scanner.nextLine();
			lr[i]=patterns[i].split("\\*", 2);
			if(lr[i][0].length()>left){
				left=lr[i][0].length();
				lidx=i;
			}
			if(lr[i][1].length()>right){
				right=lr[i][1].length();
				ridx=i;
			}
		}
		String ans=lr[lidx][0]+lr[ridx][1];
		Arrays.sort(lr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				int s1=o1[0].length();
				int s2=o2[0].length();
				if(s1<s2)
					return -1;
				else if(s1==s2)
					return 0;
				else
					return 1;
			}
		});
		for(int i=0;i<n;i++){
			if(lr[i][0].length()>0){
				for(int j=i+1;j<n;j++){
					if(!lr[j][0].startsWith(lr[i][0])){
						System.out.println("*");
						return;
					}
				}
			}
		}
		Arrays.sort(lr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				int s1=o1[1].length();
				int s2=o2[1].length();
				if(s1<s2)
					return -1;
				else if(s1==s2)
					return 0;
				else
					return 1;
			}
		});
		for(int i=0;i<n;i++){
			if(lr[i][1].length()>0){
				for(int j=i+1;j<n;j++){
					if(!lr[j][1].endsWith(lr[i][1])){
						System.out.println("*");
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		for(int k=1;k<=t;k++){
			System.out.print("Case #"+k+": ");
			solve(scanner);
		}
		scanner.close();
	}
}
