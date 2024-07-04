import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution  {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		int bitsInArray = in.nextInt();
		boolean stop = false;
		for(int i =0; i< testCasesNumber; i++) {
			String array = "";
			int maxQueries = 150;
			int numberOfMadeQueries = 0;
			if(bitsInArray == 10) {
				int ind = 1;
				while(true) {
					System.out.println(ind++);
					String response = in.next();
					if(response.equals("N")) {
						stop = true;
						break;
					} else {
						int responseInt = Integer.parseInt(response);
						array += responseInt;
					}
					if(ind == bitsInArray + 1) {
						System.out.println(array);
						String success = in.next();
						if(success.equals("Y")) {
							break;
						} else {
							stop = true;
							break;
						}
					}
				}
			} else {
				if(bitsInArray == 20) {
					int[] solution = new int[20];
					for(int ind = 1; ind < 6; ind++) {
						numberOfMadeQueries++;
						System.out.println(ind);
						String response = in.next();
						if(response.equals("N")) {
							stop = true;
							break;
						} else {
							int responseInt = Integer.parseInt(response);
							solution[ind - 1] = responseInt;
						}
					}
					for(int ind = 20; ind > 15; ind--) {
						numberOfMadeQueries++;
						System.out.println(ind);
						String response = in.next();
						if(response.equals("N")) {
							stop = true;
							break;
						} else {
							int responseInt = Integer.parseInt(response);
							solution[ind - 1] = responseInt;
						}
					}
					numberOfMadeQueries = doWork(in, numberOfMadeQueries, solution, 10);
					for(int ind = 6; ind < 10; ind++) {
						numberOfMadeQueries++;
						System.out.println(ind);
						int answer = Integer.parseInt(in.next());
						solution[ind - 1] = answer;
					}
					for(int ind = 15; ind > 11; ind--) {
						numberOfMadeQueries++;
						System.out.println(ind);
						int answer = Integer.parseInt(in.next());
						solution[ind - 1] = answer;
					}
					if(numberOfMadeQueries < 20) {
						for(int ind = 0; ind < (20 - numberOfMadeQueries); ind++) {
							System.out.println(1);
							in.next();
						}
					}
					doWork(in, numberOfMadeQueries, solution, 18);
					System.out.println(10);
					int tentxNumber = Integer.parseInt(in.next());
					System.out.println(11);
					int eleventhNumber = Integer.parseInt(in.next());
					solution[9] = tentxNumber;
					solution[10] = eleventhNumber;
					String answer = "";
					for(int ind = 0; ind < solution.length; ind++) {
						answer += solution[ind];
					}
					System.out.println(answer);
					String success = in.next();
					if(!success.equals("Y")) {
						break;
					}
				}
			}
			
			if(stop) {
				break;
			}
		}
		
	}

	private static int doWork(Scanner in, int numberOfMadeQueries, int[] solution, int numberOfKnownBits) {
		System.out.println(1);
		numberOfMadeQueries++;
		String response = in.next();
		
		int responseInt = Integer.parseInt(response);
		boolean reversedAndExchange = false;
		boolean reversedOnly = false;
		if(solution[0] != solution[19]) {
			if(responseInt == solution[0]) {
				for(int start = 1, end = 18; start < numberOfKnownBits / 2; start++, end--) {
					if(solution[start] == solution[end]) {
						System.out.println(start + 1);
						numberOfMadeQueries++;
						responseInt = Integer.parseInt(in.next());
						if(responseInt != solution[start]) {
							reversedAndExchange = true;
						}
						break;
					}
				}
			} else {
				reversedOnly = true;
			}
		} else {
			if(responseInt != solution[0]) {
				boolean found = false;
				for(int start = 1, end = 18; start < numberOfKnownBits / 2; start++, end--) {
					if(solution[start] != solution[end]) {
						found = true;
						System.out.println(start + 1);
						numberOfMadeQueries++;
						responseInt = Integer.parseInt(in.next());
						if(responseInt != solution[start]) {
							reversedOnly = true;
						} else {
							reversedAndExchange = true;
						}
						break;
					}
				}
				if(!found) {
					reversedOnly = true;
				}
			}
		}
		if(reversedOnly) {
			for(int start = 0, end = 19; start < numberOfKnownBits / 2; start++, end--) {
				if(solution[start] == 1) {
					solution[start] = 0;
				} else {
					solution[start] = 1;
				}
				if(solution[end] == 1) {
					solution[end] = 0;
				} else {
					solution[end] = 1;
				}
			}
		} else {
			if(reversedAndExchange) {
				for(int start = 0, end = 19; start < numberOfKnownBits / 2; start++, end--) {
					int solutionStart = solution[start];
					int solutionEnd = solution[end];
					if(solutionStart == solutionEnd) {
						if(solution[start] == 1) {
							solution[start] = 0;
						} else {
							solution[start] = 1;
						}
						if(solution[end] == 1) {
							solution[end] = 0;
						} else {
							solution[end] = 1;
						}
					}
				}	
			}
		}
		return numberOfMadeQueries;
	}
}
