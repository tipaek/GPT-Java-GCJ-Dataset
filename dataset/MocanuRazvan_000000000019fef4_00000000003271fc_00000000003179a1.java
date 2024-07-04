import java.util.Scanner;

public class Solution{


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();

		Integer u[] = new Integer[10];
		Integer q[] = new Integer[10000];
		String r[] = new String[10000];

		for (int i=0;i<nr;i++) {
			u[i]=scanner.nextInt();
			for (int j=0;j<10000;j++) {
				q[j]=scanner.nextInt();
				r[j]=scanner.next();
			}
		}

		scanner.close();

		
		
		
		
		
		for (int i=0;i<nr;i++) {
			char[] letters = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
			for (int j=0;j<10000;j++) {
				if(q[j]==1)letters[1]=r[j].charAt(0);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==2&&r[j].charAt(0)!=letters[1])letters[2]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==3&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2])letters[3]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==4&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3])letters[4]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==5&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]&&r[j].charAt(0)!=letters[4])letters[5]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==6&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]
						&&r[j].charAt(0)!=letters[4]&&r[j].charAt(0)!=letters[5])letters[6]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==7&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]
						&&r[j].charAt(0)!=letters[4]&&r[j].charAt(0)!=letters[5]&&r[j].charAt(0)!=letters[6])letters[7]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==8&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]
						&&r[j].charAt(0)!=letters[4]&&r[j].charAt(0)!=letters[5]&&r[j].charAt(0)!=letters[6]
								&&r[j].charAt(0)!=letters[7])letters[8]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==9&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]&&r[j].charAt(0)!=letters[4]
						&&r[j].charAt(0)!=letters[5]&&r[j].charAt(0)!=letters[6]&&r[j].charAt(0)!=letters[7]&&r[j].charAt(0)!=letters[8])letters[9]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==10&&r[j].charAt(0)==letters[1]&&r[j].length()>1)letters[0]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==12&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0])letters[2]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==12&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==13&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0])letters[3]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==13&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==14&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]&&r[j].charAt(1)!=letters[0])letters[4]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==14&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==15&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4])letters[5]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==15&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==16&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5])letters[6]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==16&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==17&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[7]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==17&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==18&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[8]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==18&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			
			for (int j=0;j<10000;j++) {
				if(q[j]==19&&r[j].charAt(0)==letters[1]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[8]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[9]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==19&&r[j].length()>1)letters[1]=r[j].charAt(0);	
			}
			
			
			
			
			
			
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]>=20&&q[j]<=29&&r[j].charAt(0)!=letters[1]&&r[j].length()>1)letters[2]=r[j].charAt(0);	
			}
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]==20&&r[j].charAt(0)==letters[2]&&r[j].length()>1)letters[0]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==21&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[0])letters[1]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==22&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0])letters[2]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==23&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0])letters[3]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==24&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]&&r[j].charAt(1)!=letters[0])letters[4]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==25&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4])letters[5]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==26&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5])letters[6]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==27&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[7]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==28&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[8]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==29&&r[j].charAt(0)==letters[2]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[8]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[9]=r[j].charAt(1);

			}
			
			
			
			
			
			
			
			
			
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]>=20&&q[j]<=29&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].length()>1)letters[3]=r[j].charAt(0);	
			}
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]==30&&r[j].charAt(0)==letters[3]&&r[j].length()>1)letters[0]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==31&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[0])letters[1]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==32&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0])letters[2]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==33&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0])letters[3]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==34&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]&&r[j].charAt(1)!=letters[0])letters[4]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==35&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4])letters[5]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==36&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5])letters[6]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==37&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[7]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==38&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[8]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==39&&r[j].charAt(0)==letters[3]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[8]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[9]=r[j].charAt(1);

			}
			
			
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]>=20&&q[j]<=29&&r[j].charAt(0)!=letters[1]&&r[j].charAt(0)!=letters[2]&&r[j].charAt(0)!=letters[3]&&r[j].length()>1)letters[4]=r[j].charAt(0);	
			}
			
			
			for (int j=0;j<10000;j++) {
				if(q[j]==40&&r[j].charAt(0)==letters[4]&&r[j].length()>1)letters[0]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==41&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[0])letters[1]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==42&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0])letters[2]=r[j].charAt(1);	
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==43&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0])letters[3]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==44&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]&&r[j].charAt(1)!=letters[0])letters[4]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==45&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4])letters[5]=r[j].charAt(1);
			}
			for (int j=0;j<10000;j++) {
				if(q[j]==46&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5])letters[6]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==47&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[7]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==48&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[8]=r[j].charAt(1);

			}
			for (int j=0;j<10000;j++) {
				if(q[j]==49&&r[j].charAt(0)==letters[4]&&r[j].length()>1)
					if(r[j].charAt(1)!=letters[1]&&r[j].charAt(1)!=letters[0]&&r[j].charAt(1)!=letters[8]&&r[j].charAt(1)!=letters[7]&&r[j].charAt(1)!=letters[2]&&r[j].charAt(1)!=letters[3]
							&&r[j].charAt(1)!=letters[4]&&r[j].charAt(1)!=letters[5]&&r[j].charAt(1)!=letters[6])letters[9]=r[j].charAt(1);

			}
			
			
			
			
			
			
			int i1=i+1;
			String str=new String(letters);
			System.out.println("Case #"+i1+": "+str);
		}

	}

	
	
}
