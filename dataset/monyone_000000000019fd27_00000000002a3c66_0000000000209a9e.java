import java.util.Scanner;

class D {

	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			final int B = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				int[] arr = new int[B];
				for(int i = 0; i < B; i++) {
					System.out.println((i % B) + 1);
					System.out.flush();
					arr[i % B] = sc.nextInt();
				}
				
				for(int i = 0; i < B; i++) { System.out.print(arr[i]); }
				System.out.println();
				System.out.flush();
			}
		}
	}
}
