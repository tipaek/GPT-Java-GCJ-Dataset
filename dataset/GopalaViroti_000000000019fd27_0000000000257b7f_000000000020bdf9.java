import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);
        int testCount = sc.nextInt();
        for (int i = 1; i <= testCount; i++)
            solve(i, sc, w);
        w.close();
	}

	public static void solve(int testNumber, Scanner sc, PrintWriter out) {
		int N=sc.nextInt();
		ArrayList<Pair> list = new ArrayList<Pair>(N);
		ArrayList<Pair> sortList = new ArrayList<Pair>(N);
		for(int i=0;i<N;i++){
			Pair pair = new Pair(sc.nextInt(),sc.nextInt());
			list.add(pair);
			sortList.add(pair);
		}
		Collections.sort(sortList, new SortByEnd());
		boolean flag = false;
		Pair last = sortList.get(N-1);
		for(int i=0;i<N-1;i++){
			if(last.start<=sortList.get(i).start)
				flag=true;
			else{
				flag=false;
				break;
			}
		}
		sortList=null;
		StringBuilder ans = new StringBuilder();
		
		if(!flag){
			Stack<Character> stack = new Stack<Character>();
			Pair prev = list.get(0);
			stack.push('J');
			for(int i=1;i<N;i++){
				Pair current = list.get(i);				
				if(prev.end<=current.start)
					stack.push(stack.peek());
				else{
					Character ch = stack.peek();
					if(ch=='C')
						stack.push('J');
					else 
						stack.push('C');
				}
				prev=current;				
			}
			Stack<Character> backup = new Stack<Character>();
			while(!stack.isEmpty()){
				backup.push(stack.pop());
			}
			stack=null;
			while(!backup.isEmpty()){
				ans.append(backup.pop());
			}
		}
		else{
			ans.append("IMPOSSIBLE");
		}
		out.println("Case #" + testNumber + ": " + ans.toString());
	}
}

class Pair{
	Integer start;
	Integer end;
	Pair(Integer start,Integer end){
		this.start=start;
		this.end=end;
	}
}

class SortByEnd implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		return o1.end-o2.end;
	}
}