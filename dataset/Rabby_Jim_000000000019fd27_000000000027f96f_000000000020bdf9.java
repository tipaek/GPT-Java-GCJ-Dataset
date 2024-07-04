import javax.swing.text.html.CSS;
import java.util.*;
public class Solution {
	private static Scanner sc;
	static int tn = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		while(t-- > 0)
		{
			solve();
		}

	}
	private static void solve()
	{
		int n = sc.nextInt();
		int[][] mat= new int[n][2];
		int[][] matStored = mat.clone();
		char person = 'J';
		char[] chars = new char[n];
		Stack<int[]> JStack = new Stack<>();
		Stack<int[]> CStack = new Stack<>();
		boolean impossible = false;
		
		Map<int[], Integer> map = new HashMap<>();
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
			
			map.put(mat[i], i);
		}
		
		Arrays.sort(matStored, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		for(int i=0; i<matStored.length; i++) {
			chars[map.get(matStored[i])] = person;
			
			if(i<matStored.length - 1 && doesOverlap(matStored[i], matStored[i+1])) {
				if(person == 'J') {
					JStack.push(matStored[i]);
					person = getPerson(person);
					
					if(!CStack.isEmpty() && doesOverlap(CStack.peek(), matStored[i+1])) {
						impossible = true;
						break;
					}
				
				} else {
					CStack.push(matStored[i]);
					person = getPerson(person);
					
					if(!JStack.isEmpty() && doesOverlap(JStack.peek(), matStored[i+1])) {
						impossible = true;
						break;
					}
				}
			}else {
				if(person == 'J') {
					JStack.push(matStored[i]);
				}else {
					CStack.push(matStored[i]);
				}
			}
		}
		
		System.out.println("Case #"+(tn++)+": "+(impossible ? "IMPOSSIBLE" : new String(chars)));
	}
	
	private static char getPerson(char p) {
		return p == 'J' ? 'C' : 'J';
	}
	
	private static boolean doesOverlap(int[] a, int[] b) {
		return a[1] > b[0];
	}

}
