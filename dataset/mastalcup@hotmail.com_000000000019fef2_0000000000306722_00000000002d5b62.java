import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());

		    for (int i = 1; i <= t; ++i) {
				Map<Integer, Boolean> possibleMovesMap = new LinkedHashMap<>();
		    	int thisMove = 0;
		    	int n = 0;
		    	while(thisMove < 128){//stop here for small data sets since graph is only 200x200
		    		thisMove = (int)Math.pow((double)2, (double)n);
		    		possibleMovesMap.put(thisMove, true);
		    		n++;
		    	}
		    	
		    	String[] parts = in.nextLine().split(" ");
		    	
		    	int x = Integer.parseInt(parts[0]);
		    	int y = Integer.parseInt(parts[1]);
		    	
				System.out.println("Case #" + i + ": " + findAnswer(x, y, possibleMovesMap));
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String findAnswer(int x, int y, Map<Integer, Boolean> possibleMovesMap){
		//if both targets are odd, or both are even, it's impossible since we have to hop 1
		if( (x % 2 != 0 && y % 2 != 0)
				|| (x % 2 == 0 && y % 2 ==0)){
			return "IMPOSSIBLE";
		}
		
		List<String> moves = new ArrayList<>();

		boolean negativeX = x < 0;
		boolean negativeY = y < 0;
		String xBinary = Integer.toBinaryString(Math.abs(x));
		String yBinary = Integer.toBinaryString(Math.abs(y));
		
		char[] binaryX = new char[Math.max(xBinary.length(), yBinary.length()) + 1];
		char[] binaryY = new char[Math.max(xBinary.length(), yBinary.length()) + 1];

		System.arraycopy(
				xBinary.toCharArray(),
				0, 
				binaryX,
				binaryX.length - xBinary.length(), 
				xBinary.toCharArray().length);
		System.arraycopy(
				yBinary.toCharArray(),
				0, 
				binaryY,
				binaryY.length - yBinary.length(), 
				yBinary.toCharArray().length);
		
		for(int i = binaryX.length-1; i >= 1; i--){
			char xChar = binaryX[i];
			char yChar = binaryY[i];
			
			if(xChar == '2'){
				xChar = '0';
				binaryX[i-1] = binaryX[i-1] == '1' ? '2' : '1';
			}
			if(yChar == '2'){
				yChar = '0';
				binaryY[i-1] = binaryY[i-1] == '1' ? '2' : '1';
			}
			
			//look ahead for duplicate..
			if(binaryX[i-1] == '1' && binaryY[i-1] == '1'){
				if(xChar == '1'){
					binaryX[i-1] = '2';
					moves.add(negativeX ? "E" : "W");
				}
				if(yChar == '1'){
					binaryY[i-1] = '2';
					moves.add(negativeY ? "N" : "S");
				}
			}
			else if(xChar == '1' && yChar != '1'){
				moves.add(negativeX ? "W" : "E");
			}
			else if(yChar == '1' && xChar != '1'){
				moves.add(negativeY ? "S" : "N");
			}
		}
		
		if(binaryX[0] == '1' && binaryY[0] == '1'){
			return "IMPOSSIBLE";
		}
		else if(binaryX[0] == '1'){
			moves.add(negativeX ? "W" : "E");
		}
		else if(binaryY[0] == '1'){
			moves.add(negativeY ? "S" : "N");
		}
		
		return String.join("", moves);
	}
	
}
