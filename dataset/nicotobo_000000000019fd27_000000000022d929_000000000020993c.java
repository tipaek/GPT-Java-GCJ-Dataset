import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution 
{
	public static void main(String[] args) throws IOException 
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String strNumCasos=br.readLine();
		int numCasos=Integer.parseInt(strNumCasos);

		for (int i = 0; i < numCasos; i++) 
		{
			String strN=br.readLine();
			int N=Integer.parseInt(strN);

			int[][] matriz=new int[N][N];

			for (int f = 0; f < matriz.length; f++) 
			{
				String[] strFila=br.readLine().split(" ");
				for (int j = 0; j < matriz.length; j++) 
				{
					matriz[f][j]=Integer.parseInt(strFila[j]);
				}
			}
			
			int k=0;
			int r=0;
			int c=0;

			for (int j = 0; j < matriz.length; j++) 
			{
				k+=matriz[j][j];	
			}

			 
		    HashMap<Integer,Integer> comprobante ; 
			
			for (int j = 0; j < matriz.length; j++) 
			{
				comprobante = new HashMap<Integer,Integer>();
				for (int j2 = 0; j2 < matriz.length; j2++) 
				{
					if(comprobante.containsKey(matriz[j][j2]))
					{
						r++;
						break;
					}
					else
					{
						comprobante.put(matriz[j][j2], 1);
					}
				
				}
			}
			
			for (int j = 0; j < matriz.length; j++) 
			{
				comprobante = new HashMap<Integer,Integer>();
				for (int j2 = 0; j2 < matriz.length; j2++) 
				{
					if(comprobante.containsKey(matriz[j2][j]))
					{
						c++;
						break;
					}
					else
					{
						comprobante.put(matriz[j2][j], 1);
					}
				}
			}
	
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);			
		}	
	}






	public static void imprimirMatriz(int[][] pMatriz)
	{
		for (int f = 0; f < pMatriz.length; f++) 
		{
			String strFila="";
			for (int j = 0; j < pMatriz.length; j++) 
			{
				strFila+=pMatriz[f][j]+" ";
			}
			System.out.println(strFila);
		}


	}


}