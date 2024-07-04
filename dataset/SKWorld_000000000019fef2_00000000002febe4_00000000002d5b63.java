	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	class Blindfolded_Bullseye{
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         String s=br.readLine();
	         String s1[]=s.split(" ");
	         int t = Integer.parseInt(s1[0]);
	         int a=Integer.parseInt(s1[1]);
	         int b=Integer.parseInt(s1[2]);
	         	for(int i=0;i<t;i++) {
	         		boolean flag=false;
	         		for(int j=-5;j<=5;j++) {
	         			for(int k=-5;k<=5;k++) {
	         				System.out.println(k +" "+j);
	         				String answer=br.readLine();
	         				if(answer.equalsIgnoreCase("CENTER")) {
	         					flag=true;
	         					break;
					}
				}
				if(flag)
					break;
			}
		}
		}
	}
