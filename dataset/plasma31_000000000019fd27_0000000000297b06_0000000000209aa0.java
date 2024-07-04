import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> subsets = new ArrayList<String>();
	static void permute(int[] a, int k, int sum) {
		if (k == a.length) {
			int size = a.length;
			int p[] = new int[size];
			String temp = "";
			for (int i = 0; i < a.length; i++) {
				// System.out.print( a[i] + " ");
				temp = temp + Integer.toString(a[i]);
			}
			// System.out.println();
			subsets.add(temp);

		} else {
			for (int i = k; i < a.length; i++) {
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;

				permute(a, k + 1, sum);

				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
	}
	
	static boolean findsets(String p[],int sum) {
		int k = 0;
		boolean check = false;
		boolean Possible=false;
		k++;
		int i = p.length;
		for (String s2 : subsets) {
			boolean b = true;//very useful dont delete this
			for (int mool = 0; mool < k; mool++) {
				for (i = 0; i < s2.length(); i++) {
					if (s2.charAt(i) == p[mool].charAt(i)) {
						b = false;
						break;
					}
				}
			}
			if (b) {
				p[k] = s2;
				k++;
				if (k == p.length) {
					k = 0;
					int i2=0;
					int sum2=0;
					for (int rahul = 0; rahul < p.length; rahul++) {
						//System.out.println(p[rahul]);
						if(i2==rahul) {
							sum2=sum2+Character.getNumericValue(p[rahul].charAt(rahul));
							i2++;
						}

					}
					//System.out.println(" mai rahul hu");
					if (!check&&sum2==sum) {
						check=true;
						Possible=true;
						System.out.println("POSSIBLE");

						for (int rahul = 0; rahul < p.length; rahul++) {
							for (int ktr=0;ktr<p[rahul].length();ktr++) {
								System.out.print(p[rahul].charAt(ktr)+" ");
							}
							System.out.println();
							

						}
						//System.out.println(" Sum is "+sum2);

						return Possible;

					}
					check = true;
					k = 1;
					
					sum2=0;
				}
			}

		}
		return Possible;


	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int nofarr=sc.nextInt();
		for(int i=0;i<nofarr;i++) {
        

		int N = sc.nextInt();
		int sum = sc.nextInt();
		System.out.print("Case #"+(i+1)+": ");

		solution(sum,N);
		subsets = new ArrayList<String>();
		

		}
		sc.close();

	}

	private static void solution(int sum, int N) {
		int[] sequence = new int[N];
		for (int i = 0; i < N; i++)
			sequence[i] = i + 1;
		permute(sequence, 0, sum);
		// printarray2(sequence,sequence.length);
		checsolution(sum);
		
	}

	private static void checsolution(int sum) {
		// TODO Auto-generated method stub
		int k = 0;
		boolean b=false;
		for (String s : subsets) {
			String p[] = new String[s.length()];
			p[k] = s;
			
			b=findsets(p,sum);
			
			if(b) {
				break;
			}
			
			//System.out.println("---------------");
		}
		if(!b) {
			System.out.println("IMPOSSIBLE");
		}
	}
	
}