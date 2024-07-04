import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NestingDepth {
	
	static Scanner scanner;
	static List<TestCase2> testCases = new ArrayList<>();
	
	public static void main(String[] args) {

		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int numCases = scanner.nextInt();
		
		String inputString = null;
		TestCase2 testCase = null;
		
		for(int i=0; i<numCases; i++) {
			
			inputString = scanner.next();
//			System.out.println("main(): inputString: "+inputString);
			testCase = new TestCase2(inputString);
			
		}
		scanner.close();
		printOutput();
	}
	
	private static void printOutput() {
		int caseNr = 0;
		
		for(TestCase2 testCase: testCases) {
			
			caseNr++;
			System.out.println("Case #"+caseNr+": "+testCase.getProcessedString());
		}
	}
}

class TestCase2{
	
	List<String> inputString;
	
	public TestCase2(String inputString) {
		
		this.inputString = new ArrayList<>();
//		System.out.println("TestCase2()");
		String subString = null ;
		
		for(int i=0; i<inputString.length(); i++) {
			subString = inputString.substring(i, i+1);
			this.inputString.add(subString);
		}
//		System.out.println("TestCase2(): list build, list size: "+this.inputString.size());
	}

	public String getProcessedString() {
//		System.out.println("getProcessedString()");
		int value;
		int nrParentheses;
		
//		System.out.println("getProcessedString(): start iterating");
		for(int i=0; i<inputString.size(); i++) {
//			System.out.println("getProcessedString(): intermediar result: "+getSubstring(0, inputString.size())+" i="+i);
			
			
			value = getStringAsIntegerAtIndex(i);
			nrParentheses = getNumOfOpenParanthesesBeforeIndex(i);
			
//			System.out.println("getProcessedString(): start while");
			while(value>nrParentheses) {
				
//				System.out.println("getProcessedString(): start while: open para: "+nrParentheses+" value: "+value);
				addOpenParanthesesBeforeIndex(i);
				
				i++;
				nrParentheses = getNumOfOpenParanthesesBeforeIndex(i);
				addCloseParanthesesInLatestPlace(i, nrParentheses);
//				System.out.println("getProcessedString(): end while: open para: "+nrParentheses+" value: "+value);
			}
		}
		
		String proccesedString = "";
		
		for(String character: inputString) {
			proccesedString= proccesedString + character;
		}
		
		proccesedString = addMissingParantheses(proccesedString);
		
		return proccesedString;
	}

	private String addMissingParantheses(String proccesedString) {

		int missingParanthesesNumber = 0;
		
		String character= null;
		
		for(int i=0; i<proccesedString.length(); i++) {
			character = proccesedString.substring(i, i+1);
			if (character.equals("(")) {
				missingParanthesesNumber++;
			} else if(character.equals(")")) {
				missingParanthesesNumber--;
			}
		}
		
		for(int i=0; i< missingParanthesesNumber; i++) {
			proccesedString = proccesedString+")";
		}
		
		return proccesedString;
	}

	private void addCloseParanthesesInLatestPlace(int index, int nrParentheses) {
		
//		System.out.println("addCloseParanthesesInLatestPlace(): index="+index);
		
		for(int i=index+1; i<inputString.size(); i++ ) {
//			prinInput();
			if( getStringAsIntegerAtIndex(i) >= nrParentheses ) {
				continue;
			} else {
				addCloseParanthesesBeforeIndex(i);
				break;
			}
		}
	}

	private void prinInput() {

		for(String string: inputString) {
			System.out.print(string+" "+"\n");
		}
	}

	private void addCloseParanthesesBeforeIndex(int i) {
//		System.out.println("addCloseParanthesesBeforeIndex(): index="+i);
		inputString.add(i, ")");
	}

	private void addOpenParanthesesBeforeIndex(int i) {
//		System.out.println("addOpenParanthesesBeforeIndex(): i="+i);
		inputString.add(i, "(");
	}

	private int getNumOfOpenParanthesesBeforeIndex(int index) {
		
		int nrParentheses = 0;
		String stringToProcess = getSubstring(0, index+1);
		String stringAtI = null;
		
		for(int i=0; i<stringToProcess.length(); i++) {
			stringAtI = getSubstring(i, i+1);
			if(stringAtI.equals("(")) {
				nrParentheses++;
			}else if(stringAtI.equals(")")){
				nrParentheses--;
			}
		}
//		System.out.println("getNumOfOpenParanthesesBeforeIndex(): i="+index+" returned:"+nrParentheses);
		return nrParentheses;
	}	
	
	private int getStringAsIntegerAtIndex(int index) {
		
		
		String stringAtIndex = inputString.get(index);
		
		try {
//		System.out.println("getStringAsIntegerAtIndex(): i="+index+" returned:"+Integer.parseInt(stringAtIndex));
		
		return Integer.parseInt(stringAtIndex);
		}catch (java.lang.NumberFormatException e) {
			return 0;
		}
	}
	
	private String getSubstring(int fromIndex, int toIndex) {
		
		String subString = "";
		
		for(int i=fromIndex; i<toIndex; i++) {
			subString = subString + inputString.get(i);
		}
		
//		System.out.println("getSubstring(): fromIndex="+fromIndex+" toIndex="+toIndex+" returned:"+subString);
		
		return subString;
	}
	
}