package code_jam;
import java.util.*;
class Vestigium {
	public static int t;int n;int mat[][];
	public Vestigium() {
		Scanner sc =new Scanner(System.in);

		n=sc.nextInt();
		mat=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
	}
	public int getDiaSum(){
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					sum+=this.mat[i][j];
			}
		}
		return sum;
	}
	public boolean checkRow(int ele,int i,int j) {
		while(j<n) {
			if(ele==mat[i][j])
				return true;
			j++;
		}
		
		return false;
		
	}
	
	public int countDuplicateRow() {
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				int ele=mat[i][j];
				if(checkRow(ele,i,j+1)) {
					count++;
					break;
					
				}
			}
		}
		return count;
	}
	public boolean checkColumn(int ele,int i,int j) {
		while(i<n) {
			if(ele==mat[i][j])
				return true;
			i++;
		}
		
		return false;
		
	}
	public int countDuplicateColumn() {
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int ele=mat[j][i];
				if(checkColumn(ele,j+1,i)) {
					count++;
					break;
					}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		t=sc.nextInt();
		
		Vestigium v[]=new Vestigium[Vestigium.t];
		for(int i=0;i<t;i++) {
			v[i]=new Vestigium();
		}
		for(int i=0;i<t;i++) {
			System.out.println("Case #"+(i+1)+": "+v[i].getDiaSum()+" "+v[i].countDuplicateRow()+" "+v[i].countDuplicateColumn());
		}
		
	}
	
}
