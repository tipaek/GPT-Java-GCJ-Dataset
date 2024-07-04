import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		int casos,n,a,b,c;
		int numeros[][],eF[];
		boolean existe=false;
		casos=Integer.parseInt(bf.readLine());
		for (int i = 1; i <= casos; i++) {
			n=Integer.parseInt(bf.readLine());
			numeros=new int[n+1][n+1];
			a=0;
			b=0;
			c=0;
			for (int j = 0; j < n; j++) {
				tk=new StringTokenizer(bf.readLine());
				eF=new int[n+1];
				existe=false;
				for (int k = 0; k < n; k++) {
					numeros[j][k]=Integer.parseInt(tk.nextToken());
					if(j==k) {
						a+=numeros[j][k];
					}
					if(eF[numeros[j][k]]==0) {
						eF[numeros[j][k]]=1;
					}else {
						existe=true;
					}
				}
				if(existe) {
					b++;
				}
			}
			for (int j = 0; j < n; j++) {
				eF=new int[n+1];
				existe=false;
				for (int k = 0; k < n; k++) {
					if(eF[numeros[k][j]]==0) {
						eF[numeros[k][j]]=1;
					}else {
						existe=true;
					}
				}
				if(existe) {
					c++;
				}
			}
			System.out.println("Case #"+i+": "+a+" "+b+" "+c);
		}

	}

}
