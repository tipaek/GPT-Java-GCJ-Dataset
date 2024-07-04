import java.io.BufferedReader;
import java.io.InputStreamReader;

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
					valoresFila=valoresFila.replace(" ", "");
					char[] caracteres=valoresFila.toCharArray();
					for(int j=0; j<caracteres.length; ++j)
					{
						matriz[i][j]=Integer.parseInt(Character.toString(caracteres[j]));
						if(i==j)
						{
							k+=matriz[i][j];
						}
					}
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
			System.out.println(resultado);
		}
		catch(Exception e)
		{
			
		}
		
	} 
	
	public static boolean repetidos(char[] pChar)
	{
		try
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

		}
		catch(Exception e)
		{

		}
		return false;

	}
}