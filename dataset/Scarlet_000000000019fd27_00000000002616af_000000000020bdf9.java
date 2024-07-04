import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int testcount=scan.nextInt();
		int N=0,temps=0,tempe=0;
		String output="",str="";
		String[] finalout = new String[testcount];
		for(int i=1;i<=testcount;i++) {
			int jcount=0,ccount=0;
			str="";output="";
			N=scan.nextInt();
			int[] Jam = new int[N*2];
			int[] Cam = new int[N*2];
			Jam[0] = scan.nextInt();
			Jam[1] = scan.nextInt();
			jcount=2;output="J";
			if(N>1) {
				for(int j=0;j<N-1;j++) {
					temps = scan.nextInt();
					tempe = scan.nextInt();
					str=parenting(temps,tempe,Jam,Cam,jcount,ccount);
					output=output+str;
					if(str=="J") {
						Jam[jcount]=temps;
						Jam[jcount+1]=tempe;
						jcount=jcount+2;
					}
					else if(str=="C") {
						Cam[ccount]=temps;
						Cam[ccount+1]=tempe;
						ccount=ccount+2;
					}
					else {
						output="IMPOSSIBLE";
						break;
					}
				}
			}
			finalout[i-1]="Case #"+i+": "+output;
		}
		for(int i=0;i<testcount;i++)
			System.out.println(finalout[i]);
		scan.close();
	}	
	public static String parenting(int temps,int tempe,int[] Jam,int[] Cam,int jcount,int ccount) {
		String str = "";
		int flag=0;
		for(int i=0;i<jcount;i=i+2) {
			if((temps>Jam[i] && temps<Jam[i+1])||(tempe>Jam[i] && tempe<Jam[i+1])||(tempe>Jam[i+1] && temps<Jam[i])) {
				if(ccount!=0) {
					for(int j=0;j<ccount;j=j+2) {
						if((temps>Cam[j] && temps<Cam[j+1])||(tempe>Cam[j] && tempe<Cam[j+1])||(tempe>Cam[j+1] && temps<Cam[j])) {
							flag=1;
							break;
						}
					}
					if(flag==0)
						str="C";
				}
				else
					str="C";
			}
		}
		if(flag==0 && str=="") {
			str="J";
		}
		return str;
	}
}