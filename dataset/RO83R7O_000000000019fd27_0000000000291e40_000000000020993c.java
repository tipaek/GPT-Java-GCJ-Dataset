import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void Main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++)
		{
			int tam, traza = 0;
			tam = sc.nextInt();
			HashSet<Integer> filas = new HashSet<>();
			HashSet<Integer> columnas = new HashSet<>();
			Boolean f[] = new Boolean[tam];
			Boolean c[] = new Boolean[tam];
			int fil = 0;
			int col = 0;
			int matriz[][] = new int[tam][tam];

			for(int j = 0; j < tam; j++)
			{
				for(int k = 0; k < tam; k++)
				{
					int num = sc.nextInt();
					traza += num;
					matriz[j][k] = num;
					if(filas.contains(num) && !f[j])
					{
						f[j] = true;
						filas.add(num);
					}
					else
						fil++;
					
					if(columnas.contains(num) && !c[k])
					{
						c[k] = true;
						columnas.add(num);
					}
					else
						col++;
				}
			}
			
			System.out.println("Casos #" + i + ": " + traza + " " + fil + " " + col);
		}
	}
}
