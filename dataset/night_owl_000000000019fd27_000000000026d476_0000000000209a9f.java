import java.util.Scanner;

class Solution {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int cno = 1;
        int testCases = scanner.nextInt();
        while(testCases--> 0){
            String s = scanner.next();
            StringBuilder answer = getExtractedString(s);
            System.out.println("Case #" + cno +": "+answer.toString());
            cno++;
        }
       
    }

	private static StringBuilder getExtractedString(String s) {
		int noOP = 0;
		StringBuilder answer = new StringBuilder();
		for(char character : s.toCharArray()){
		    int currentNumber = (int)(character-'0');
		    if(currentNumber == 0){
		        while(noOP!=0){
		            answer.append(")");
		            noOP--;
		        }
		        answer.append("0");
		    }
		    else{
		        int noONP = currentNumber - noOP;
		        if(noONP > 0){
		            while(noONP!=0){
		                answer.append("(");
		                noONP--;
		                noOP++;
		            }
		        }
		        else if(noONP < 0) {
		            while(noONP!=0){
		                answer.append(")");
		                noONP++;
		                noOP--;
		            }
		        }
		        answer.append(currentNumber);
		    }
		}
		while(noOP > 0) {
			answer.append(")");
			noOP--;
		}
		return answer;
	}
}