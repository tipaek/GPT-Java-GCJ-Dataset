import java.util.*;
import java.lang.*;
public class code{
	private static Scanner scan;
	static int mn=1;
	public static void main(String args[])
	{
		
		scan=new Scanner(System.in);
		int t=scan.nextInt();
		scan.nextLine();
		while(t-- > 0)
		
		{
			solve();
		}
		 
	}
	private static void solve() {
		int n=scan.nextInt();
		int[][] mat=new int[n][2];
		
	    int[][] matSorted=mat.clone();
	    char man='J';
	    char[] chars=new char[n];
	  
		Stack<int[]> JStack=new Stack<>();
		Stack<int[]> CStack=new Stack<>();
		boolean nothing=false;
		Map<int[],Integer>map=new HashMap<>();
		for (int i=0;i<mat.length;i++)
		{
		  for(int j=0;j<mat[i].length;j++)	
		
		{
			mat[i][j]=scan.nextInt();
			
			
		}
		  map.put(mat[i],i);
		}
		Arrays.sort(matSorted,new Comparator<int[]>() {
			@Override
			public int compare(int[] a,int[] b)
			{
				return a[0]-b[0];
			}
		});
		for(int i=0;i<matSorted.length;i++)
		{
			chars[map.get(matSorted[i])]=man;
			if(i<matSorted.length-1 && doesOverlap(matSorted[i],matSorted[i+1])) {
				if(man=='J')
				{
					JStack.push(matSorted[i]);
					man=Person(man);
					if(!CStack.isEmpty() && doesOverlap(CStack.peek(),matSorted[i+1]))
					{
						nothing=true;
						break;
					}
				}else {
					CStack.push(matSorted[i]);
					man=Person(man);
					if(!JStack.isEmpty() && doesOverlap(JStack.peek(),matSorted[i+1]))
					{
						nothing=true;
						break;
					}
				}
			}else
			{
				if(man=='J')
				{
					JStack.push(matSorted[i]);
				}else {
					CStack.push(matSorted[i]);
				}
			}
		}
	
	System.out.println("Case #"+(mn++)+": "+(nothing? "IMPOSSIBLE":new String(chars)));

}



 private static char Person(char letter )
 {
	 return letter=='J'?'C':'J';
 }
 


private static boolean doesOverlap(int[] num1,int[] num2) {
	return num1[1]>num2[0];
}
}