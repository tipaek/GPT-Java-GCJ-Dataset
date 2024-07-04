import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	   @SuppressWarnings("resource")
       Scanner s = new Scanner(System.in);
	   int t;
       t=s.nextInt();
       //s.nextLine();
		for(int z=0;z<t;z++) {
		int n;
		n=s.nextInt();
		boolean f=false;
		int array[][]=new  int [n][2];
		for(int i=0;i<n;i++) {
			for(int j =0;j<2;j++) {
				array[i][j]=s.nextInt();
			}
		}
		int max=array[0][1];
		for(int i=0;i<n;i++) {
			if(array[i][1] > max) {
				max=array[i][1];
			}
		}
		//System.out.println(max);
		boolean jBusy []=new boolean[n];
		boolean cBusy []=new boolean[n];
		boolean j []=new boolean[max+1];
		boolean c []=new boolean[max+1];
		for(int i=0;i<n;i++) {
			int begin=array[i][0];
			int end = array[i][1];
			//System.out.println((begin));
			for(int a=begin;a < end;a++) {
				if (j[a]==true) {
					jBusy[i]=true;
					break;
				}
			}
			if (jBusy[i]==true) {
				for(int a=begin;a < end;a++) {
					if (c[a]==true) {
						cBusy[i]=true;
						break;
					}
			}
			if (jBusy[i]==true && cBusy[i]==true) {
				System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
				f=true;
				break;
				}else 
					{for(int r=begin;r < end;r++) {
						c[r]=true;
					}}
			
			}else {
				for(int a=begin;a < end;a++) {
					j[a]=true;
				}
			}
		}
		String word="";
		for(int b=0;b<n;b++) {
			if (jBusy[b]==false) {
				word=word+"J";
			}else
				word=word+"C";
		}
		if(f==false)
			System.out.println("Case #"+(z+1)+": "+word);
		}
}}
