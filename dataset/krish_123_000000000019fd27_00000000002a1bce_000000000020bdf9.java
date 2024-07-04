package gfg;


import java.util.*;

class Google{
	static int tn=1;
	private static Scanner sc;
   public static void main(String[] args)
   {		
   	// your code goes here
		 sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0) {
	    	
			solve();
			
		}
   }
   
   private static void solve()
   {
       int n=sc.nextInt();
   	int [][]mat=new int [n][2];
   	int [][]matsorted=mat.clone();
   	
   	
   	char person='J';
   	char[] chars=new char[n];
   	Stack<int[]>jstack=new Stack<>();
   	Stack<int[]>cstack=new Stack<>();
   	boolean impossible=false;
   	
   	Map<int[],Integer> map=new HashMap<>();
   	for(int i=0;i<mat.length;i++)
   	{
   		for(int j=0;j<mat[i].length;j++)
   		{
   			mat[i][j]=sc.nextInt();
   		}
   		map.put(mat[i], i);
   	} 
   	Arrays.sort(matsorted,new Comparator<int[]>()
   			{
   		@Override
   		public int compare(int [] a,int []b)
   		{
   			return a[0]-b[0];
   		}
   			});
   	for(int i=0;i<matsorted.length;i++)
   	{	chars[map.get(matsorted[i])]=person;
   	if(i<matsorted.length-1 && doesOverlap(matsorted[i],matsorted[i+1]))
   		
   	{
   		
   		if(person=='J')
   		{
   			jstack.push(matsorted[i]);
   			person=getPerson(person);
   			if(!cstack.isEmpty()&&doesOverlap(cstack.peek(),matsorted[i+1]))
   			{
   				impossible=true;
   				break;
   			}
   		}else
   		{
   			cstack.push(matsorted[i]);
   			person=getPerson(person);
   			if(!jstack.isEmpty()&&doesOverlap(jstack.peek(),matsorted[i+1]))
   			{
   				impossible=true;
   				break;
   			}
   		}
   		
   	}else {
   		if(person=='J')
   		{
   			jstack.push(matsorted[i]);
   		}else {
   			cstack.push(matsorted[i]);
   		}
   	}
   	
   	
   	}
   	System.out.println("Case #"+ (tn++)+": "+(impossible?"IMPOSSIBLE":new String(chars)));
   }
   private static char getPerson(char p)
   {
   	return p=='J'?'C':'J';
   }
   private static boolean doesOverlap(int a[],int [] b)
   {
   	return a[1]>b[0]; 
   }
    
}