import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
		int answers[] = new int[numberOfTestCases];
		int moves[][][] = new int[numberOfTestCases][1000][2];
		for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
		{	
			answers[testCaseInstance] = 0;
			String deck = bufferedReader.readLine();
			String deckSize[] = new String[2];
			deckSize = deck.split(" ");
			int rank = Integer.parseInt(deckSize[0]);
			int suit = Integer.parseInt(deckSize[1]);
			
			int currentInstance = 0;
			while(rank > 1)
			{
				int rankCopy = rank;
				int suitCopy = suit;
				int flag = 0;
				while(suitCopy>1){
					moves[testCaseInstance][currentInstance][0] = rankCopy * (suitCopy-1);
					if(flag>0 && currentInstance>0)
						moves[testCaseInstance][currentInstance][0]+=moves[testCaseInstance][currentInstance-1][1];
					moves[testCaseInstance][currentInstance][1] = rankCopy - 1;
					currentInstance++;
					suitCopy--;			
					flag++;
				}
				rank--;				
			}
			answers[testCaseInstance] = currentInstance;
		}
		for(int j=0;j<numberOfTestCases;j++)
		{
			System.out.println("Case #"+(j+1)+": "+answers[j]);
			for(int k=0;k<answers[j];k++)
			{
				System.out.println(moves[j][k][0]+" "+moves[j][k][1]);
			}
		}
	}
	
	
}