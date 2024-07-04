import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise {


	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Integer[][] tabla;
		try
		{
			System.out.println("Casos" );
			String line = bf.readLine();
			String[] linea = line.split("");
			int casos = Integer.parseInt( linea[0] );
			int i = 0;
			while( i < casos )
			{
				System.out.println("N" );
				line = bf.readLine();
				linea = line.split("");
				int n = Integer.parseInt( linea[0] );
				tabla = new Integer[n][n];
				int x = 0;
				while( x < n )
				{
					System.out.println( "Fila" );
					line = bf.readLine();
					String[] fila = line.split(" ");
					for( int c = 0; c < n; c++)
					{						
						tabla[x][c] = Integer.parseInt( fila[c] );
					}
					x++;
				}
				
				int d = 0;
				for( int z = 0; z < n; z++ )
				{
					d += tabla[z][z];
				}
				
				int columna = 0;
				for( int a = 0; a < n; a++)
				{
					for( int b = 0; b < n; b++)
					{
						for( int e = b+1; e < n; e++)
						{
							if( tabla[a][b] == tabla[a][e])
								columna++;
						}
					}	
				}
				
				int fila = 0;
				for( int a = 0; a < n; a++)
				{
					for( int b = 0; b < n; b++)
					{
						for( int e = b+1; e < n; e++)
						{
							if( tabla[b][a] == tabla[e][a])
								fila++;
						}
					}	
				}				
				System.out.println( "Case #" + (i+1) +":" + d + " " + columna + " " + fila );
				i++;
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
	}
}