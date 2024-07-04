import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair>{
	int start,end,id;
	public Pair(int start, int end, int id){
		this.start=start;
		this.end=end;
		this.id=id;
	}
	@Override
	public int compareTo(Pair p) {
		if(this.start==p.start)
			return 0;
		else if (this.start>p.start)
			return 1;
		else 
			return -1;
	}
	public String toString(){
		return start+" "+end;
	}
	
}

public class Solution {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			StringBuilder result  = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			Pair [] arr = new Pair[N];
			for(int i=0;i<N;i++){
				String s[] = br.readLine().split(" ");
				arr[i]=new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1]),(i));
			}
			Arrays.sort(arr);
//			for(int i=0;i<N;i++)
//				System.out.print(arr[i]+ " , " );
//			System.out.println();
			
			int c=0;
			int j=0;
			char[]res = new char[N];
			for(int i=0;i<N;i++){
				Pair cur =arr[i];
				if(cur.start<c){
					if(cur.start<j){
						result=new StringBuilder("IMPOSSIBLE");
						break;
					}
					else
					{
						j=cur.end;
						res[cur.id]='J';
					}
				}
				else{
					c=cur.end;
					res[cur.id]='C';
				}
			}
			
			for(int i=0;i<N&&!result.toString().equals("IMPOSSIBLE");i++){
				result.append(res[i]);
			}
			
			if(t==T-1){
				out.print("Case #"+(t+1)+": "+result);
			}
			else
				out.println("Case #"+(t+1)+": "+result);
			
		}
		out.flush();
		out.close();
	}
}
