import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] ans= new String[t];
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			boolean found=false;
			ArrayList<triplet> arr= new ArrayList<>();
			for(int j=0;j<n;j++) {
				int start= s.nextInt();
				int end= s.nextInt();
				triplet temp= new triplet(start, end, j);
				arr.add(temp);
				
			}
			Collections.sort(arr, new haha());
			int maxa=-1;
			int maxb=-1;
			ArrayList<triplet> a= new ArrayList<>();
			ArrayList<triplet> b= new ArrayList<>();
			for(int j=0;j<n;j++) {
				triplet curr= arr.get(j);
				if(curr.start>=maxa)
				{
					a.add(curr);
					curr.c='C';
					maxa=Math.max(maxa, curr.end);
				}
				else if(curr.start>=maxb) {
					b.add(curr);
					curr.c='J';
					maxb=Math.max(maxb, curr.end);
				}
				else
				{
					ans[i]="IMPOSSIBLE";
					found=true;
					break;
				}
			}
			if(!found) {
				for(triplet curr: b) {
					a.add(curr);
				}
				Collections.sort(a, new hehe());
				String answer="";
				for(triplet curr: a)
				{
					answer+=curr.c;
				}
				ans[i]=answer;
			}
			
			

		}
		for(int i=0;i<t;i++) {
			System.out.println("Case #"+(i+1)+": "+ans[i]);
		}

	

	}
}
class triplet{
	int start;
	int end;
	int index;
	Character c;
	public triplet(int a, int b, int c) {
		this.start=a;
		this.end=b;
		this.index=c;
	}
	
}
class haha implements Comparator<triplet>{
	public int compare(triplet a, triplet b) {
		return a.start-b.start;
	}
}
class hehe implements Comparator<triplet>{
	public int compare(triplet a, triplet b) {
		return a.index-b.index;
	}
}
