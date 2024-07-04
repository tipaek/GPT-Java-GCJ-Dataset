import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<t; i++) {
			String samstr = sc.nextLine();
			String samarr[] = samstr.split("");
			int arr[] = new int[samarr.length];
			for(int j=0; j<samarr.length; j++) {
				String numstr = samarr[j];
				arr[j] = Integer.parseInt(numstr);
			}
			
			System.out.print("Case #"+(i+1)+": ");
			int open=0,close=0;
			for(int j=0; j<samarr.length; j++) {
				int item = arr[j];
				
					if(open<item) {
						int limit = item-open;
						for(int k=0;k<limit;k++) {
							System.out.print("(");
							open++;
						}
						System.out.print(item);
					}
					else if(open>item) {
						int limit= open-item;
						for(int k=0;k<limit;k++) {
							System.out.print(")");
							open--;
						}
						System.out.print(item);
					}
					else {
						System.out.print(item);
					}
				
			}
			if(open!=0) {
				for(int k=0;k<open;k++) {
					System.out.print(")");
				}
			}
			
			System.out.println();
		}

	}

}
