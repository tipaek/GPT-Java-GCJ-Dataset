class Solution{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		in.nextLine();
		for(int t=1;t<=T;t++){
			String input[]=in.nextLine().split("");
			StringBuffer st=new StringBuffer();
			int d=0;
			
			for(int i=0;i<input.length;i++){
				int n=Integer.parseInt(input[i]);
				
				if(n>d){
					int def=n-d;
					for(int j=0;j<def;j++){
						st.append("(");
					}
					st.append(n);
					d=n;
				}
				else if(n<d){
					int def=d-n;
					for(int j=0;j<def;j++)
						st.append(")");
					st.append(n);
					d=n;
				}
				else
					st.append(n);
			}
			if(d!=0){
				for(int i=0;i<d;i++){
					st.append(")");
				}
			}
			System.out.println("Case #"+t+": "+st.toString());
		}
	}
}