import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Vestigium
{   
	public static void main(String[] args) {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int cases=Integer.parseInt(bf.readLine());
			int contador=0;
			String resultado="";
			while(contador<cases)
			{
				//TAMA�O MATRIZ
				int size=Integer.parseInt(bf.readLine());
				int matriz[][]=new int[size][size];
				
				//VALOR DE K, SUMATORIA DE LA DIAGONAL (FILA)
				int diagonal=0;
				int k=0;
				
				//VALOR DE R, ELEMENTOS REPETIDOS FILA.
				int r=0;
				
				//VALOR DE C, ELEMENTOS REPETIDOS COLUMNA.
				int c=0;
				
				for(int i=0; i<size;++i)
				{
					String valoresFila=bf.readLine();
					valoresFila=valoresFila.trim();
					valoresFila=valoresFila.replace(" ", "");
					char[] caracteres=valoresFila.toCharArray();
					for(int j=0; j<caracteres.length; ++j)
					{
						matriz[i][j]=Integer.parseInt(Character.toString(caracteres[j]));
						//DIAGONAL
						if(i==j)
						{
							k+=matriz[i][j];
						}
					}
					//REPETICION EN FILAS
					if(repetidos(caracteres)==true)
					{
						++r;
					}
				}
				
				for(int i=0; i<size;++i)
				{	String columna="";
					for(int j=0; j<size;++j)
					{
						columna+=matriz[j][i];
					}
					char[] valoresColumna=columna.toCharArray();
					//REPETICION EN COLUMNAS
					if(repetidos(valoresColumna)==true)
					{
						++c;
					}
				}
				resultado+="Case #"+Integer.toString(contador+1)+":"+" "+Integer.toString(k)+" "+Integer.toString(r)+" "+Integer.toString(c)+"\n";
				++contador;
			}
			System.out.println(resultado);
			
			
			
		} catch (IOException e) {
					
		}

		
	}
	
	public static boolean repetidos(char[] pChar)
	{
		String num="0123456789";
		boolean[] numBool=new boolean[10];
		for(int i=0; i<numBool.length;++i)
		{
			numBool[i]=false;
		}
		char[] numeros=num.toCharArray();
		for(int i=0; i<pChar.length; ++i)
		{
			for(int j=0; j<numeros.length; ++j)
			{
				if(pChar[i]==numeros[j])
				{
					int valor=Integer.parseInt(Character.toString(pChar[i]))-1;
					if(numBool[valor]==false)
					{
						numBool[valor]=true;
					}
					else if(numBool[valor]==true)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
