import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static Scanner sc=null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B= sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] data = new int[B]; 
			for (int j = 0; j < B; j++) {
				data[j]=-1;
			}
			int jj=0;
			for (int j = 0; j < B; j++) {
				if(jj%10==0) {
					jj +=fixData(data);
				}  
				 
				int k = j%2==0? j/2 : B-1-j/2;
				data[k]=read(k); 
				jj++; 
			}
			String ret = "";
			for (int j = 0; j < B; j++) {
				ret+=data[j];
			}
			System.out.println(ret);
			String response= sc.next();
			if(response.equals("N")) {
				return ;
			}
			  
		}
		
	}
	private static int fixData(int[] data) {
		int B=data.length;
		int di = -1;
		int si = -1;
		for (int j = 0; j < B/2; j++) { 
			if(data[j]==-1)
				break;
			if(data[j]==data[B-1-j] && si==-1) {
				si=j;
			}
			if(data[j]!=data[B-1-j] && di==-1) {
				di=j;
			}
			 
		} 
		int rn=0;
		boolean c = si!=-1 && data[si]!=read(si);
		if(si!=-1)
			rn++;
		if(c) {
			for (int j = 0; j < B; j++) {
				if(data[j]==-1) {
					continue;
				}
				data[j]=1-data[j];
			}
		}
		boolean d =   di!=-1 && data[di]!=read(di)  ;
		if(di!=-1)
			rn++;
		if(d) {
			for (int j = 0; j < B/2; j++) {
				int tmp = data[j];
				data[j]= data[B-1-j];
				data[B-1-j]=tmp;
			}
			
		} 
		if(rn%2==1) {
			read(0);
			rn++;
		}
		 
		return rn;
		
		 
		  
		
	}
	private static int read(int k) {
		System.out.println(""+(k+1));
		System.out.flush();
		int x = sc.nextInt();
		return x;
	}



}
