import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] tabla;
		try
		{
			String rta = "";
			String line = bf.readLine();
			int casos = Integer.parseInt( line.split(" ")[0] );
			int i = 0;
			while( i < casos )
			{
				line = bf.readLine();
				String[] linea = line.split(" ");
				int n = Integer.parseInt( linea[0] );
				tabla = new int[n][n];
				int x = 0;
				while( x < n )
				{
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

				boolean bol;
				int fila = 0;
				boolean bol2;

				int columna = 0;
				for( int a = 0; a < n; a++)
				{
					bol = false;
					for( int b = 0; b < n && !bol; b++)
					{
						for( int e = 0; e < n && !bol; e++)
						{
							if( b != e)
								if( tabla[a][b] == tabla[a][e])
								{
									columna++;
									bol = true;
								}
						}
					}	
				}

				for( int a = 0; a < n; a++)
				{
					bol2 = false;
					for( int b = 0; b < n && !bol2; b++)
					{
						for( int e = 0; e < n && !bol2; e++)
						{
							if( b != e)
								if( tabla[b][a] == tabla[e][a])
								{
									fila++;
									bol2 = true;
								}
						}
					}	
				}

				i++;
				rta += "Case #" + i +": " + d + " " + columna + " " + fila + "\n";
			}

				System.out.println( rta );
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
	}
}