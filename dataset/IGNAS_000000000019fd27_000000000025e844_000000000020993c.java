package vestigium;

import java.lang.Character.Subset;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases;
		int mSize;
		int cell;
		int trace = 0;
		int caseCounter = 1;
		int rowRepeat = 0;
		int colRepeat = 0;
		String colArr[];
		boolean isRowRepeat = false;
		boolean isColRepeat = false;
		String rowStr = "";
		String colStr = "";
		
	//	scanner.nextLine();
		cases = scanner.nextInt();
		System.out.println("");
		colArr = new String[cases+1];
		while(scanner.hasNextLine()) {
			colRepeat = 0;
			trace = 0;
			rowRepeat = 0;
			mSize = scanner.nextInt();

			for(int i = 0; i < mSize; i++) {
				//rowRepeat = 0;
				colArr[i] = "";
				rowStr = "";
				for(int j = 0; j < mSize; j++) {
					cell = scanner.nextInt();
					if(rowStr.contains(Integer.toString(cell))) {
						isRowRepeat = true;
					}
					rowStr = rowStr + cell;
					colArr[i] += cell;
					if(j == i) {
						trace += cell; 
					}
				}
				if(isRowRepeat) {
					rowRepeat++;
					isRowRepeat = false;
				}
			}
			colRepeat = 0;
			for(int g = 0; g < colArr.length; g++) {
				String str = colArr[g];
				while(str.length() != 0) {
					char ch = str.charAt(0);
					str = str.substring(1);
					if(str.contains(""+ch)) {
						colRepeat++;
						str = "";
					}
				}
			}
			
			System.out.println("Case #"+caseCounter+": " + trace + " " + rowRepeat + " " + colRepeat);
			caseCounter++;
		}
		
		
		
		scanner.close();
	}

}
