import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	String[] tok=s.split(" ");
	int T=Integer.parseInt(tok[0]);
	int B=Integer.parseInt(tok[1]);
	for (int i = 1; i <= T; i++) {
	    boolean sm=false, df=false, cmp=false, inv=false;
	    int smi=1, dfi=1, k=1, j=1;
	    int vsm=0, vdf=0;
	    boolean[] arr=new boolean[B];
	    while (true) {
	        int qu=5;
	        if (sm) { System.out.println(""+smi);
	            s = scanner.nextLine();
	            cmp=(Integer.parseInt(s)!=vsm); qu=4;
	        }
	        if (df) { System.out.println(""+dfi);
	            s = scanner.nextLine();
	            inv=(Integer.parseInt(s)!=vdf ^ cmp); qu=4;
	        }
	        if (sm ^ df) { System.out.println(1);
	            s = scanner.nextLine();
	        }
	        for (j = 0; j < qu && 2*k<=B; j++) {
	            System.out.println(""+k);
		        s = scanner.nextLine();
		        int a=Integer.parseInt(s);
		        System.out.println(""+(B-k+1));
		        s = scanner.nextLine();
		        int b=Integer.parseInt(s);
		        if (!sm && a==b) {sm=true; smi=k; vsm=a;}
		        if (!df && a!=b) {df=true; dfi=k; vdf=a;}
		        arr[k]=(inv && (cmp ^ b==1)) || (!inv && (cmp ^ a==1));
		        arr[B-k+1]=(inv && (cmp ^ a==1)) || (!inv && (cmp ^ b==1));
		        k++;
	        }
	        if (j<qu) {
	            s="";
	            for (int h=0; h<B;h++) 
	                s+=(arr[(inv)?B-h+1:h] ^ cmp)?"1":"0";
	            System.out.println(s);
	             s = scanner.nextLine();
	             if (s.charAt(0)=='N') i=T+1;
	             break;
	        }
		}
	}
	scanner.close();		
}	
}