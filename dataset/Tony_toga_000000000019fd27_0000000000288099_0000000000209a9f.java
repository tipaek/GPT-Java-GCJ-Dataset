import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		String ini, res="";

		char uno, dos=0;
		int resta=0, restaAnt=-1,h, aux1, aux2=0;
		int tot=input.nextInt();

		for(int k=0; k<tot; k++){
			ini=input.next();
			uno=ini.charAt(0);
			System.out.println(uno);
			res="";

			h=0;
			aux1=Character.getNumericValue(uno);
			while(aux1!=h){
				res=res+"(";
				h++;
			}
			

			res=res+uno;
			for(int i=1; i<ini.length(); i++){
				dos=ini.charAt(i);
				aux2=Character.getNumericValue(dos);
				if(aux2==0){
					h=0;
					while(aux1!=h){
						res=res+")";
						h++;
					}
					res=res+dos;
				}
				else{
					resta=aux1-aux2;
					if((restaAnt>=0 && resta<0) || (aux1==0) ){
						h=0;
						while(aux1!=h){
							res=res+")";
							h++;
						}
						h=0;
						while(aux2!=h){
							res=res+"(";
							h++;
						}
						res+=dos;
					}
					else{
						if(resta>0){
							for(int j=0; j<resta; j++){
								res+=")";
							}
							res+=dos;
						}
						else{
							for(int j=0; j<resta; j++){
								res+="(";
							}
							res+=dos;
						}
					}
				}
				aux1=aux2;
				restaAnt=resta;
			}
			h=0;
			if(aux2!=0){
				while(aux2!=h){
					res=res+")";
					h++;
				}
			}
			else{
				while(aux1!=h){
					res=res+")";
					h++;
				}
			}
			System.out.println(res);
			System.out.println("\n");
		}
	}
}