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
			
			int flag=0;
			for(int j=0; j<samarr.length; j++) {
				int item = arr[j];
				if(item == 0 && flag==0) {
					System.out.print(item);
				}
				else if(item==1 && flag==0) {
					System.out.print("(");
					System.out.print(item);
					flag=1;
				}
				else if(item==1 && flag==1) {
					System.out.print(item);
				}
				else if(item==0 && flag ==1) {
					System.out.print(")");
					System.out.print(item);
					flag=0;
				}
			}
			if(flag==1) {
				System.out.print(")");
			}
			System.out.println();
		}

	}

}
