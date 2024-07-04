import java.util.LinkedList;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases= in.nextInt();
		String ans="";
		int counter=1;
		while(cases-->0){
			int size= in.nextInt();
			int [][] mat= new int[size][size];
			int trace=0;
			LinkedList<Integer> hor = null;
			LinkedList<Integer> ver = null;
			int h=0;
			for(int i = 0 ; i < size ; i++){
				hor = new LinkedList<Integer>();
				for(int j = 0 ; j < size ; j++){
					mat[i][j]=in.nextInt();
					int x = mat[i][j];
					if(!hor.contains(x))
						hor.add(x);
					if(i==j){
						trace=trace+mat[i][j];}
				}
				if(size!=hor.size())
					h++;
			}
			int v = 0 ;
			for(int i = 0 ; i < size ; i++){
				ver = new LinkedList<Integer>();
				for(int j = 0 ; j < size ; j++){
					int x = mat[j][i];
					if(!ver.contains(x))
						ver.add(x);
				}
				if(size!=ver.size())
					v++;
			}
			ans+="Case #"+counter+": "+trace+" "+(h)+" "+v+"\n";
			counter++;
		}
		System.out.println(ans);

	}

}
