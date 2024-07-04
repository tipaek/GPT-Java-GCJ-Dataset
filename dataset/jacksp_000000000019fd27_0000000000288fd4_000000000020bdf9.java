import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Peemau {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		

		for (int i = 0; i < t; i++) {

			Map<int[],Integer> map =new HashMap<>();
			int n = sc.nextInt();
			int[][] arrival = new int[n][2];
			for (int j = 0; j < n; j++) {
				arrival[j][0] = sc.nextInt();
				arrival[j][1] = sc.nextInt();
				map.put(arrival[j],j);
			}

			Arrays.sort(arrival, new Comparator<int[]>() {

				public int compare(int[] x, int[] y) {
					return x[0] - y[0];
				};
			});
			
			Stack<int[]> jack=new Stack<int[]>();
			
			Stack<int[]> carr=new Stack<int[]>();
			char[] chars=new char[n];
			boolean flag=false;
			char free='J';
			
			for(int j=0;j<arrival.length;j++)
			{
				chars[map.get(arrival[j])]=free;
				
				if(j<arrival.length-1 && isCover(arrival[j],arrival[j+1]))
				{
					if(free =='J')
					{
						jack.push(arrival[j]);
						free=allotFree(free);
						if(!carr.isEmpty() && isCover(carr.peek(),arrival[j+1]))
						{
							flag=true;
							break;
						}
					}
					else
					{
						carr.push(arrival[j]);
						free=allotFree(free);
						if(!jack.isEmpty() && isCover(jack.peek(),arrival[j+1]))
						{
							flag=true;
							break;
						}
					}
				}
				else
				{
					if(free=='J')
					{
						jack.push(arrival[j]);
					}
					else
					{
						carr.push(arrival[j]);
					}
				}
			}
			System.out.println(flag?"IMPOSSIBLE":new String(chars));

	}

}

	private static boolean isCover(int[] is, int[] is2) {
		return   is[1]>is2[0];
		
	}

	private static char allotFree(char person) {
		return person=='J'?'C':'J';
		
	}
}