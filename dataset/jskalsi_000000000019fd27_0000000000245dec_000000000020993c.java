import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
	    int trace,r,c;
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    String s[] = new String[T];
	    for(int i=1;i<=T;i++){
	        trace=0;
	        r=0;
	        c=0;
		    int size = sc.nextInt();
            int M[][] = new int[4][4];
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    M[j][k]=sc.nextInt();
                }
            }
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    if(j==k)
                        trace+=M[j][k];
                }
            }
            for(int j=0;j<size;j++){
                loop1: {
                    for(int k=0;k<size;k++){
                        for(int l=k+1;l<size;l++){
                            if(M[j][k]==M[j][l]){
                                r++;
                                break loop1;
                            }
                        }
                    }
                }
            }
            for(int k=0;k<size;k++){
                loop2: {
                    for(int j=0;j<size;j++){
                        for(int l=j+1;l<size;l++){
                            if(M[j][k]==M[l][k]){
                                c++;
                                break loop2;
                            }
                        }
                    }
                }
            }
            s[i-1]="Case #"+(i)+": "+trace+" "+r+" "+c;
	    }
	    for(int i=1;i<=T;i++){
	        System.out.println(s[i-1]);
	    }
	    
	}
}
