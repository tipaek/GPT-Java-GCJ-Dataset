import java.util.Scanner;

public class NestingDepth {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		NestingDepth nestingDepth = new NestingDepth();
		
		nestingDepth.inputString();
		
//		nestingDepth.parseToGen(1, "0000");		// 0000
//		nestingDepth.parseToGen(2, "101");		// (1)0(1)
//		nestingDepth.parseToGen(3, "111000");	// (111)000
//		nestingDepth.parseToGen(4, "1");		// (1)
//		nestingDepth.parseToGen(5, "221");		// ((22)1) 
//		nestingDepth.parseToGen(6, "312");		// (((3))1(2))
	}
	
	public void inputString() {
		Scanner sc = new Scanner(System.in);
		int caseNum = Integer.parseInt(sc.nextLine());
		
		String[] inputStringArray = new String[caseNum];
		String intString;
		for(int i = 0; i < caseNum; i ++) {
			intString = sc.nextLine();
			
			inputStringArray[i] = intString;
		}
		
		sc.close();
		
		for(int i = 0; i < caseNum; i ++) {
			this.parseToGen(i+1, inputStringArray[i]);
		}
    }
	
	public void parseToGen(int caseNum, String inputStr) {
		int keepNum=0, indexNum=0;
		String keepString, indexString;
		
		indexString = inputStr.substring(0, 1);
		indexNum = Integer.parseInt(indexString);
		
		keepNum = indexNum;
		keepString = indexString;
		
		for(int i=1; i<inputStr.length(); i++) {
			indexString = inputStr.substring(i, i+1);
			indexNum = Integer.parseInt(indexString);
			
			if(keepNum > indexNum) {
				keepString = this.genParentheses(keepString, keepNum-indexNum) + indexString;				
				keepNum = indexNum;
			}else if(keepNum < indexNum) {
				keepString = keepString + this.genParentheses(indexString, indexNum - keepNum);
			}else {
				keepString += indexString;	
			}
		}
		
		if(keepNum != 0) {
			keepString = this.genParentheses(keepString, keepNum);
		}
		
		System.out.println("Case #"+caseNum+": "+keepString);
	}
	
	public String genParentheses(String oriString, int num) {
		StringBuffer leftStr  = new StringBuffer();
		StringBuffer rightStr = new StringBuffer();
		
		for(int i=0; i<num; i++) {
			leftStr.append("(");
			rightStr.append(")");
		}

//		System.out.println("-----" + oriString +", "+num);
//		System.out.println("     " + oriString);
//		System.out.println("     " + leftStr.toString() + oriString + rightStr.toString());
		
		return leftStr.toString() + oriString + rightStr.toString();
	}
}
