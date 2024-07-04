import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(reader);

		try {
			Integer testCases = Integer.parseInt(bufferReader.readLine());
			for (int i = 1; i <= testCases; i++) {
				String input = bufferReader.readLine();
				System.out.println(Solution.calculate(input));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static StringBuilder calculate(String input){
		int[] modifiedString=new int[input.length()];
		for(int i=0;i<input.length();i++){
			modifiedString[i]=Integer.parseInt(String.valueOf(input.charAt(i)));
		}
		int temp;
		int[] openingBraces=new int[input.length()];
		int[] closingBraces=new int[input.length()];
		while(!checkForAllZero(modifiedString)){
			int firstNonZeroIndex=firstNonZero(modifiedString);
			modifiedString[firstNonZeroIndex]--;
			openingBraces[firstNonZeroIndex]++;
			int i;
			for(i=firstNonZeroIndex+1;(firstNonZeroIndex!=-1 && i<modifiedString.length);i++){
				if(modifiedString[i]>0){
					modifiedString[i]--;
				}
				else
					break;
			}
			closingBraces[i-1]++;
		}
		return getBalancedString(input,openingBraces,closingBraces);
	}

	public static boolean checkForAllZero(int[] modifiedInput) {
		boolean flag = true;
		for (int i = 0; i < modifiedInput.length; i++) {
			if (modifiedInput[i] != 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static StringBuilder getBalancedString(String input, int[] opening,
			int[] closing) {
		StringBuilder outputString = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (opening[i] != 0) {
				for(int j=0;j<opening[i];j++){
					outputString.append('(');
				}

			}
			outputString.append(input.charAt(i));
			if (closing[i] != 0) {
				for(int j=0;j<closing[i];j++){
					outputString.append(')');
				}
			}
		}
		return outputString;
	}

	public static int firstNonZero(int[] modifiedString){
		for(int i=0;i<modifiedString.length;i++){
			if(modifiedString[i]!=0)
				return i;
		}
		return -1;
	}
}
