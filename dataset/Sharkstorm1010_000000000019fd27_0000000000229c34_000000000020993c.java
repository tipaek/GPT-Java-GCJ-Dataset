import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{   
	public static void main(String[] args) throws Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int cases=Integer.parseInt(bf.readLine());
			int contador=0;
			String resultado="";
			while(contador<cases)
			{
				int size=Integer.parseInt(bf.readLine());
				int matriz[][]=new int[size][size];
				int k=0;
				int r=0;
				int c=0;
				for(int i=0; i<size;++i)
				{
					String valoresFila=bf.readLine();
					valoresFila=valoresFila.trim();
					String[] numeros=valoresFila.split(" ");
					for(int j=0; j<numeros.length; ++j)
					{
						matriz[i][j]=Integer.parseInt(numeros[j]);
						if(i==j)
						{
							k+=matriz[i][j];
						}
					}
					if(repetidos(numeros)==true)
					{
						++r;
					}
				}
				for(int i=0; i<size;++i)
				{	String columna="";
					for(int j=0; j<size;++j)
					{
						columna+=matriz[j][i]+" ";
					}
					String[] valoresColumna=columna.split(" ");
					if(repetidos(valoresColumna)==true)
					{
						++c;
					}
				}
				if((contador+1)==cases)
				{
					resultado+="Case #"+Integer.toString(contador+1)+":"+" "+Integer.toString(k)+" "+Integer.toString(r)+" "+Integer.toString(c);
					bf.close();
				}
				else
				{
					resultado+="Case #"+Integer.toString(contador+1)+":"+" "+Integer.toString(k)+" "+Integer.toString(r)+" "+Integer.toString(c)+"\n";
					
				}
				++contador;
			}
			resultado=resultado.trim();
			System.out.println(resultado);
		}
		catch(Exception e)
		{
			
		}
		
	} 
	
	public static boolean repetidos(String[] pString)
	{
		try
		{
			ArrayList<String>valores=new ArrayList();
			for(int i=0; i<pString.length;++i)
			{
				if(!valores.contains(pString[i]))
				{
					valores.add(pString[i]);
				}
				else if(valores.contains(pString[i]))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{

		}
		return false;

	}
}