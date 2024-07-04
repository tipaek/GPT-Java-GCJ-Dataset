import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Solution{
//<>
public void negate(int[] tab){
	for(int i=0;i<tab.length;i++){
		if(tab[i]!=-1){
			tab[i] = 1-i;
		}
	}
}
public void reverse(int[] tab){
for(int i=0;i<(tab.length+1)/2;i++){
	int tmp = tab[i];
	tab[i] = tab[tab.length-1-i];
	tab[tab.length-1-i] = tmp;
}
}

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int T  = s.nextInt();
	int out=-1;
	int ch='?';
	for(int j=0; j<T;j++){
		String str = "";
		int B  = s.nextInt();
	int[] tab = new int[B];
	for(int i=0;i<B;i++){
		tab[i]=-1;
	}
	for(int i=0;i<10;i++){
		System.out.println(i+1);
		System.out.flush();
		tab[i]=s.nextInt();
	}
	for(int i=0;i<10;i++){str+='0'+tab[i];}
	System.out.println(s);
	ch = s.next().charAt(0);
	if(ch=='N'){System.exit(0);}
		
	}
	}
}
