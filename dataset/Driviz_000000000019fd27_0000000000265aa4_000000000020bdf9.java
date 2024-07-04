import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int test=0;
		a: while(++test<=T)
		{
			int N=Integer.parseInt(br.readLine());
			ArrayList<Pair> arr=new ArrayList<>();
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine());
				arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),i));
			}
			
			Collections.sort(arr,(a,b)->a.start-b.start);
			
			arr.get(0).assignee='C';
			Pair prevC=arr.get(0);
			Pair prevJ=new Pair(0, 0, -1);
			for(int i=1;i<N;i++)
			{
				int timeDiffC=arr.get(i).start-prevC.end;
				if(timeDiffC>=0)
				{
					arr.get(i).assignee='C';
					prevC=arr.get(i);
				}
				else
				{
					int timeDiffJ=arr.get(i).start-prevJ.end;
					if(timeDiffJ>=0)
					{
						arr.get(i).assignee='J';
						prevJ=arr.get(i);
					}
					else
					{
						System.out.println("Case #"+test+": IMPOSSIBLE");
						continue a;
					}
				}
			}
			
			Collections.sort(arr,(a,b)->a.position-b.position);
			System.out.print("Case #"+test+": ");
			for (Pair pair : arr) {
				System.out.print(pair.assignee);
			}
			System.out.println();
			
		}
	}
	
	static class Pair
	{
		int start;
		int end;
		int position;
		char assignee='x';
		Pair(int start, int end, int position)
		{
			this.start=start;
			this.end=end;
			this.position=position;
		}
	}

}
