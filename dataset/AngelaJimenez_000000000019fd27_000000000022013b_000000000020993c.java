public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		try{
			int cases= Integer.parseInt(bf.readLine());
			for(int i=0; i<(cases-1);i++)
			{
				int suma = 0;
				int repetCol=0;
				int repetFil =0;
				int n = Integer.parseInt(bf.readLine());
				int[][] x = new int[n][n];
				for (int j = 0; j < n-1; j++) 
				{
					String[] linea = bf.readLine().split(" ");
					for (int h = 0; h < n-1; h++) 
					{
						x[j][h]= Integer.parseInt(linea[h]);
						if(j==h)
						{
							suma+=x[j][h];
						}
					}
				}
				int cantidadF =0;
				int cantidadC=0;
				for (int k = 0; k < n-1; k++) {
					boolean tieneF = false;
					boolean tieneC = false;
					for (int z= 0; z < n-1 && (tieneF ==false||tieneC==false);z++)
					{
						for (int m = z+1; m < n-1 && (tieneF ==false||tieneC==false); m++)
						{
							if(x[k][z]==x[k][m])
							{
								tieneF = true;
							}
							if(x[z][k]==x[m][k])
							{
								tieneC = true;	
							}
						}
					}
					if(tieneF == true)
					{
						cantidadF++;
					}
					if(tieneC == true)
					{
						cantidadC++;
					}
				}
				repetCol = cantidadF;
				repetFil = cantidadC;
				System.out.println("Case #"+(i+1)+": "+suma+" "+repetCol+" "+repetFil);	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
