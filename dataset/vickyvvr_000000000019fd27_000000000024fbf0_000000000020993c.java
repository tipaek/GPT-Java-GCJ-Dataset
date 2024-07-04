import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int arr[][] = new int[N][N];
            int row = 0;
            int col = 0;
			int trace = 0;
            for(int i1 = 0;i1<N;i1++)
            {
                for(int j1=0;j1<N;j1++)
                {
                    arr[i1][j1] = in.nextInt();
					if(i1 == j1){
						trace += arr[i1][j1];
					}
                }
            }
			for(int i1=0;i1<N;i1++)
			{
				Set<Integer> mySet = new HashSet<Integer>();
				for(int j1=0;j1<N;j1++)
				{
					if((mySet.contains(arr[i1][j1]) == true) && (arr[i1][j1] >= 1 && arr[i1][j1] <= N))
					{
						row++;
						break;
					}
					mySet.add(arr[i1][j1]);
				}
			}
			
			for(int i1=0;i1<N;i1++)
			{
				Set<Integer> mySet = new HashSet<Integer>();
				for(int j1=0;j1<N;j1++)
				{
					if((mySet.contains(arr[j1][i1]) == true) && (arr[j1][i1] >= 1 && arr[j1][i1] <= N))
					{
						col++;
						break;
					}
					mySet.add(arr[j1][i1]);
				}
			}
			System.out.println("Case #" + i + " " + trace + " " + row + " "+ col);
        }
    }
}