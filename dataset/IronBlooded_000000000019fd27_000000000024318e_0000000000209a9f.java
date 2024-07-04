import java.util.Scanner;
class Solution{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		String nl=in.nextLine();
		for(int t1=0;t1<t;t1++){
			String S=in.nextLine();
			int i=0,j=0,k=0;
			String S1="";
			String S2="";
			for(i=0;i<S.length();i++){
				char c=S.charAt(i);
				String cstr="";
				cstr=""+c;
				int ci=Integer.parseInt(cstr);
				for(j=0;j<ci;j++){
					S1=S1+"(";
				}
				S1=S1+c;
				for(j=0;j<ci;j++){
					S1=S1+")";
				}
			}
			while(S1.indexOf(")(")!=-1){
				int ind = S1.indexOf(")(");
				S2=S1.substring(0,ind);
				S2=S2+S1.substring(ind+2);
				S1=S2;
			}
			System.out.println("Case #"+(t1+1)+": "+S1); 
		}
	}
}