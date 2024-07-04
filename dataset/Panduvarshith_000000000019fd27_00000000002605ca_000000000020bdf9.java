import java.util.*;
class Solution
{
	public static Scanner s;
	static int turn=1;
	public static void main(String [] args)
	{
		s=new Scanner(System.in);
		int t=s.nextInt();
		s.nextLine();
		while(t!=0){
			solve();
			t-=1;
		}
	}
	
	private static void solve(){
		
		
		
		char person='J';
		int n=s.nextInt();
		int[][] mapping=new int[n][2];
		int [][] arring=mapping.clone();
		//StringBuilder sb=new StringBuilder();
		
		char[] chars=new char[n];
		Stack<int []> JStack=new Stack<>();
		Stack<int []> CStack=new Stack<>();
		
		boolean impossible=false;
		Map<int[],Integer> map=new HashMap<>();
		for(int i=0;i<mapping.length;i++)
		{
			for(int j=0;j<mapping[i].length;j++)
			{
				mapping[i][j]=s.nextInt();
			}
			map.put(mapping[i],i);
		}
		Arrays.sort(arring,new Comparator<int[]>(){
			public int compare(int a[],int []b){
				return a[0]-b[0];
			}
		});
		for(int i=0;i<arring.length;i++){
			chars[map.get(arring[i])]=person;
			if(i<arring.length-1 && doesOverlap(arring[i],arring[i+1])){
				if(person=='J'){
					JStack.push(arring[i]);
					person=getPerson(person);
			if(!CStack.isEmpty() && doesOverlap(CStack.peek(),arring[i+1])){
				impossible=true;
				break;
			}
				}
				else
				{
					CStack.push(arring[i]);
					person=getPerson(person);
					if(!JStack.isEmpty() && doesOverlap(JStack.peek(),arring[i+1])){
						impossible=true;
						break;
					}
				}
			}
			else
			{
				if(person=='J'){
					JStack.push(arring[i]);
				}
				else
				{
					CStack.push(arring[i]);
				}
			}
		}
		System.out.println("Case #"+(turn)+": "+(impossible?"IMPOSSIBLE":new String(chars)));
		turn+=1;
	}
					
	private static char getPerson(char p){
		return p=='J'?'C':'J';
	}
	private static boolean doesOverlap(int []a,int []b){
		return a[1]>b[0];
	}
}