import java.util.*;

class It{
	private char[] c;
	private int s[],f[],fake[];
	private int n;
	It(int s[],int f[],int n,int fake[]){
		this.n=n;
		this.s=s;
		this.f=f;
		this.fake=fake;
		c=new char[n];
	}
	public String allot(){
		int j=0,k=0;boolean jAlot=false;
		c[0]='C';
		for(k=1;k<n;k++){
			if(s[k]>=f[j]){
				c[k]='C';
				j=k;
			}
		}
		for(int l=0;l<n;l++){
			if(c[l]==0){
				if(jAlot==false){
					c[l]='J';
					j=l;jAlot=true;
				}
				else if(s[l]>=f[j]){
					c[l]='J';
					j=l;
				}
				else
					return "IMPOSSIBLE";
			}
		}
		char newC[]=new char[n];
		for(int value=0;value<n;value++){
			for(int index=0;index<n;index++){
				if(fake[index]==value){
					newC[value]=c[index];
				}
			}
		}
		String string=new String(newC);
		return string;
	}
}

public class Solution{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		String output[]=new String[t];
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int fake[]=new int[n];
			int s[]=new int[n];
			int f[]=new int[n];
			for(int j=0;j<n;j++){
				s[j]=sc.nextInt();
				f[j]=sc.nextInt();
				fake[j]=j;
			}
			for(int j=0;j<n;j++){
				for(int k=j+1;k<n;k++){
					if(f[j]>f[k]){
						int temp=f[j];
						f[j]=f[k];
						f[k]=temp;
						temp=s[j];
						s[j]=s[k];
						s[k]=temp;
						temp=fake[j];
						fake[j]=fake[k];
						fake[k]=temp;
					}
				}
			}
			It obj=new It(s,f,n,fake);
			output[i]=obj.allot();
			//end test cases
		}
		for(int i=0;i<t;i++){
			System.out.println("Case #"+(i+1)+": "+output[i]);
		}
	}
}