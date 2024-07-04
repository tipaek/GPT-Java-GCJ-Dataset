//package code;
import java.util.Scanner;

 class Solution{
	static StringBuilder string = new StringBuilder();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T= scan.nextInt();
		String ans = "";
		int prevno,countbkt;
		String obkt="(";
		String cbkt=")";
		for(int i=0;i<T;i++){
			prevno = -1;
			ans="";
			String s= scan.next();
			countbkt = Integer.parseInt(Character.toString(s.charAt(0)));
			String arr[] = s.split("");
			for (int j=0;j<arr.length;j++)
			{
				int no = Integer.parseInt(arr[j]);
				if(countbkt==0)
					countbkt=no;
				if(no>prevno)
				{
					if((j==0)||(prevno==0))
						ans += same(obkt,countbkt);
					else{
						ans += same(obkt,Math.abs(countbkt-no));
						countbkt+=Math.abs(countbkt-no);
					}
						ans += no;
				}
				else if(no < prevno)
				{

					ans += same(cbkt,countbkt-no);
					countbkt=(no==0)?(0):(no);
					ans += no;
				}
				else if(no==prevno){
					ans+=Integer.toString(no);
				}
				else if (no==0)
					ans+='0';
				prevno = no;
			}
			if (countbkt>0)
				ans+=same(cbkt,countbkt);
			string.append("Case #"+(i+1)+": ");
			string.append(ans+"\n");
		}
		System.out.println(string);
		scan.close();

	}

	private static String same(String closebrac, int counter) {

		String anss ="";
		for(int i=0;i<counter;i++)
			anss+=closebrac;
		
		return anss;
	}

}