import java.util.Scanner;

public class Solution {

	public static enum SolverState
	{
		QUERY, REFRESHED
	}
	
	public static enum ElType
	{
		SAME, DIFF, UNKNOWN
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		short B = input.nextShort();
				
		for(int t=0; t<T; t++)
		{
			SolverState state = SolverState.QUERY;
			short lastQuery = 0;
			boolean stay = false;
			
			short[] answer = new short[B];
			ElType[] answerType = new ElType[B];
			for(int i=0;i<B;i++) {
				answer[i] = -1;
				answerType[i] = ElType.UNKNOWN;
			}
			int samePair = 0;
			int diffPair = 0;
			
			for(short round=1; round<=150; round++)
			{
				if(round>1 && round%10 == 1)
					state = SolverState.REFRESHED;
				
				switch(state)
				{
					case QUERY:
						if(!stay) {
							if(lastQuery == 0){
								lastQuery = 1;
							}else if(lastQuery == (B/2)+1){
								break;
							}else if(lastQuery <= B/2){
								lastQuery = (short) ((B+1) - lastQuery);
							}else{
								lastQuery = (short) ((B+2) - lastQuery);
							}
						}
						System.out.println(lastQuery);
						answer[lastQuery-1] = input.nextShort();
						if(lastQuery>B/2) {
							short a = answer[B - lastQuery];
							short b = answer[lastQuery-1]; 
							if(a==b) {
								answerType[B-lastQuery] = ElType.SAME;
								answerType[lastQuery-1] = ElType.SAME;
								if(samePair==0) 
									samePair = lastQuery;
							}else {
								answerType[B-lastQuery] = ElType.DIFF;
								answerType[lastQuery-1] = ElType.DIFF;
								if(diffPair==0)
									diffPair = lastQuery;
							}
						}
						if(stay)
							stay = false;
						
						break;
					case REFRESHED:
						if(lastQuery<=B/2)
							stay = true;
						if(samePair!=0) {
							System.out.println(samePair);
							short newSame = input.nextShort();
							if(newSame != answer[samePair-1]) {
								for(int i=0;i<B;i++) {
									if(answerType[i]==ElType.SAME)
										answer[i] = (short) (1 - answer[i]);
								}
							}
						}
						if(diffPair!=0) {
							System.out.println(diffPair);
							short newDiff = input.nextShort();
							if(newDiff != answer[diffPair-1]) {
								for(int i=0;i<B;i++) {
									if(answerType[i]==ElType.DIFF)
										answer[i] = (short) (1 - answer[i]);
								}
							}
							if(samePair!=0) 
								round++;
						}
						state = SolverState.QUERY;
						break;
				}
			}
			
			for(int i=0;i<B;i++)
			{
				System.out.print(answer[i]);
			}
			System.out.println();
			
			// check judge respond
			if(input.next()=="N") {
				break;
			}
			
//			System.err.print(t + ": ");
//			for(int i=0;i<B;i++)
//			{
//				System.err.print(answer[i]);
//			}
//			System.err.println();
//			System.err.print(t + ": ");
//			for(int i=0;i<B;i++)
//			{
//				System.err.print(answerType[i]==ElType.SAME ? "S":"D");
//			}
//			System.err.println();
		}
		
	}

}
