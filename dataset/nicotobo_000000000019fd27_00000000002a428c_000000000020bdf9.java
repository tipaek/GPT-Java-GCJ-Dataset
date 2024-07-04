import java.io.*; 
import java.util.*; 

public class Solution 
{
	//Clase
	static class Pair { 
		int first; 
		int second; 

		// Constructor 
		public Pair(int first, int second) 
		{ 
			this.first = first; 
			this.second = second; 
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
		} 

	} 


	static class Compare { 

		static void compare(Pair arr[], int n) 
		{ 
			// Comparator to sort the pair according to second element 
			Arrays.sort(arr, new Comparator<Pair>() { 
				@Override public int compare(Pair p1, Pair p2) 
				{ 
					return p1.first - p2.first; 
				} 
			}); 
		} 
	} 


	public static void main(String[] args) throws IOException 
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String strnumCasos=bf.readLine();
		Integer numCasos=Integer.parseInt(strnumCasos);

		for (int i=0;i<numCasos ;i++ )
		{
			HashMap<Integer,Integer> turnosSet = new HashMap<Integer,Integer>(); ; 
			HashMap<Pair,String> hashRespuesta =new HashMap<Solution.Pair, String>();
			String rta="";
			int numHorarios=0;
			int numCaso=i+1;
			numHorarios=Integer.parseInt(bf.readLine());
			Pair[] vectorHorarios=new Pair[numHorarios];
			Pair[] vectorOriginal=new Pair[numHorarios];;

			for(int j=0;j<numHorarios;j++)
			{
				int tInicial;
				int tFinal;
				String[] line=bf.readLine().split(" ");
				tInicial=Integer.parseInt(line[0]);
				tFinal=Integer.parseInt(line[1]);

				Pair tmp=new Pair(tInicial,tFinal);
				vectorOriginal[j]=tmp;
				vectorHorarios[j]=tmp; 
			}

			Compare obj = new Compare(); 
			obj.compare(vectorHorarios,numHorarios);

			int numT=0;
			boolean boolC=true;

			for (int j=0; j<vectorHorarios.length; j++)
			{
				if(j<vectorHorarios.length-1&&vectorHorarios[j].second>vectorHorarios[j+1].first)
				{
					if(turnosSet.containsKey(vectorHorarios[j+1].first))
					{
						numT--;
					}
					numT++;
					turnosSet.put(vectorHorarios[j].second,1);
					if(boolC)
					{
						hashRespuesta.put(vectorHorarios[j],"J");
					}
					else
					{
						hashRespuesta.put(vectorHorarios[j],"C");
					}
					if(boolC)
					{
						boolC=false;
					}
					else
					{
						boolC=true;
					}	
				}
				else
				{
					if(j<vectorHorarios.length-1&&turnosSet.containsKey(vectorHorarios[j+1].first))
					{
						numT--;
					}
					if(boolC)
					{
						hashRespuesta.put(vectorHorarios[j],"J");
					}
					else
					{
						hashRespuesta.put(vectorHorarios[j],"C");
					}
				}
			}

			if(numT<2)
			{
				for (int j = 0; j < vectorOriginal.length; j++) 
				{
					rta+=hashRespuesta.get(vectorOriginal[j]);
				}
				System.out.println("Case #"+numCaso+": "+rta);
			}
			else
			{
				System.out.println("Case #"+numCaso+": "+"IMPOSSIBLE");
			}
		}
	}
}
