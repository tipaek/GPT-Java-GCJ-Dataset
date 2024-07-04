import java.util.Scanner;

public class Solution {

	private static int queriesMade = 0;
	
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		
		int tCount = input.nextInt();
		int bitCount = input.nextInt();
		for(int t = 0; t < tCount; t++)
		{
			String knownData = initKnownData(bitCount);
			boolean anchorPointsFound = false;
			int leftSideAnchorIndex = 1;
			int rightSideAnchorIndex = bitCount;
			//First we try the first two and last two indicies.
			//If they aren't an anchor point, we move up one at a time on both sides.
			//First two on the left side.
			int leftSideValue = makeQuery(input, leftSideAnchorIndex++);
			int rightSideValue = makeQuery(input, rightSideAnchorIndex--);
			int firstValue = leftSideValue;
			int nextLeftSideValue = -1;
			int nextRightSideValue = -1;
			while(!anchorPointsFound && leftSideAnchorIndex < rightSideAnchorIndex)
			{
				//Try two values at a time, if they don't make an anchor with prev values, then overwrite the previous values.
				nextLeftSideValue = makeQuery(input, leftSideAnchorIndex);
				nextRightSideValue = makeQuery(input, rightSideAnchorIndex);
				if(checkIfValidAnchors(leftSideValue+""+nextLeftSideValue, nextRightSideValue+""+rightSideValue))
				{
					//The anchor index's are currently perfect.
					knownData = updateKnownData(knownData, (leftSideAnchorIndex)-1, String.valueOf(nextLeftSideValue));
					knownData = updateKnownData(knownData, (leftSideAnchorIndex-1)-1, String.valueOf(leftSideValue));
					
					knownData = updateKnownData(knownData, (rightSideAnchorIndex)-1, String.valueOf(nextRightSideValue));
					knownData = updateKnownData(knownData, (rightSideAnchorIndex+1)-1, String.valueOf(rightSideValue));
					anchorPointsFound = true;
					//System.out.println("LOCKED IN ANCHOR VALUES: " + leftSideValue+""+nextLeftSideValue+", "+nextRightSideValue+""+rightSideValue);
					//System.out.println("INDEX's ARE: " + (leftSideAnchorIndex-1)+""+(leftSideAnchorIndex)+", "+(rightSideAnchorIndex)+""+(rightSideAnchorIndex+1));
					break;
				}
				else
				{
					//System.out.println("INVALID ANCHOR VALUES: " + leftSideValue+""+nextLeftSideValue+", "+nextRightSideValue+""+rightSideValue);
				}
				leftSideValue = nextLeftSideValue;
				rightSideValue = nextRightSideValue;
				if(queriesMade%10==0)
				{
					//Recalculate last values if a change happened since.
					leftSideValue = makeQuery(input, leftSideAnchorIndex);
					firstValue = makeQuery(input, 1);
					firstValue = makeQuery(input, 1);//Just to keep queries even.
					rightSideValue = makeQuery(input, rightSideAnchorIndex);
				}
				leftSideAnchorIndex++;
				rightSideAnchorIndex--;
			}
			
			
			//We know our anchor indicies ARE leftSideAnchorIndex, leftSideAnchorIndex+1, rightSideAnchorIndex, rightSideAnchorIndex+1
			String prevLeftAnchorValue = leftSideValue+""+nextLeftSideValue;
			String prevRightAnchorValue = nextRightSideValue+""+rightSideValue;
			//System.out.println("WE FOUND ANCHOR VALUES: " + prevLeftAnchorValue+", "+prevRightAnchorValue);
			while(knownData.contains("X"))
			{
				//System.out.println("Known Data At Start Of Loop: " + knownData);
				if(queriesMade%10==0)
				{
					//A CHANGE HAS JUST OCCURED. Check with anchors to see what change has occured.
					//System.out.println("A change is occuring!");
					if(anchorPointsFound)
					{
						int leftSideFirstValue = makeQuery(input, leftSideAnchorIndex-1);
						int leftSideSecondValue = makeQuery(input, leftSideAnchorIndex);
						
						int rightSideFirstValue = makeQuery(input, rightSideAnchorIndex);
						int rightSideSecondValue = makeQuery(input, rightSideAnchorIndex+1);
						String newLeftAnchorValue = leftSideFirstValue + "" + leftSideSecondValue;
						String newRightAnchorValue = rightSideFirstValue + "" + rightSideSecondValue;
						ChangeType change = getChangeTypeOfData(prevLeftAnchorValue, prevRightAnchorValue, newLeftAnchorValue, newRightAnchorValue);
						if(change.equals(ChangeType.C))
						{
							knownData = getComplement(knownData);
						}
						else if(change.equals(ChangeType.R))
						{
							knownData = getReverse(knownData);
						}
						else if(change.equals(ChangeType.RC))
						{
							knownData = getReverseComplement(knownData);
						}
						prevLeftAnchorValue = newLeftAnchorValue;
						prevRightAnchorValue = newRightAnchorValue;
						//System.out.println("Change Detected As: " + change.toString());
					}
					else
					{
						//We never found an anchor point so we can just rely on the first index as our anchor.
						int newFirstValue = makeQuery(input, 1);
						if(newFirstValue != firstValue)
						{
							knownData = getComplement(knownData);
							firstValue = newFirstValue;
							//System.out.println("Change Detected As: C (with no anchors)");
						}
					}
				}
				
				//Find the next X in the known data, and update it.
				//System.out.println("Known Data Before New Update: " + knownData);
				int nextIndex = knownData.indexOf("X")+1;
				int newValue = makeQuery(input, nextIndex);
				knownData = updateKnownData(knownData, nextIndex-1, String.valueOf(newValue));
			}
			
			//After submitting attempt.
			String status = submitAttempt(input, knownData);
			if(status.equals("N"))
		    {
		        return;
		    }
			queriesMade = 0;
		}
	}
	
	private static String initKnownData(int bitCount)
	{
		String knownData = "";
		for(int i = 0; i < bitCount; i++)
		{
			knownData += "X";
		}
		return knownData;
	}
	
	private static String updateKnownData(String knownData, int index, String data)
	{
		return knownData.substring(0, index) + data + knownData.substring(index+1);
	}
	
	private static String submitAttempt(Scanner input, String bitString)
	{
		System.out.println(bitString);
		input.nextLine();
		String status = input.nextLine();
		return status;
	}
	
	private static int makeQuery(Scanner input, int queryIndex)
	{
		queriesMade++;
		System.out.println(queryIndex);
		return input.nextInt();
	}
	
	private static boolean checkIfValidAnchors(String anchor1, String anchor2) throws Exception
	{
		if(anchor1.equals(anchor2))
		{
			return false;
		}
		if(anchor1.equals(getReverse(anchor2)))
		{
			return false;
		}
		if(anchor1.equals(getComplement(anchor2)))
		{
			return false;
		}
		return true;
	}
	
	private static ChangeType getChangeTypeOfData(String anchor1, String anchor2, String newAnchor1, String newAnchor2)
	{
		//Check for S ChangeType.
		if(anchor1.equals(newAnchor1) && anchor2.equals(newAnchor2))
		{
			//Anchors are unchanged.
			return ChangeType.S;
		}
		
		//Check for R ChangeType.
		String revAnchor1 = getReverse(anchor1);
		String revAnchor2 = getReverse(anchor2);
		
		if(revAnchor1.equals(newAnchor2) && revAnchor2.equals(newAnchor1))
		{
			//Anchors are reversed.
			return ChangeType.R;
		}
		
		//Check for C ChangeType.
		String compAnchor1 = getComplement(anchor1);
		String compAnchor2 = getComplement(anchor2);
		if(compAnchor1.equals(newAnchor1) && compAnchor2.equals(newAnchor2))
		{
			//Anchors are complement.
			return ChangeType.C;
		}
		
		//If it was nothing else, must br R+C.
		return ChangeType.RC;
	}
	
	private static String getComplement(String bits)
	{
		String result = "";
		for(int i = 0; i < bits.length(); i++)
		{
			if(bits.charAt(i)=='0')
			{
				result += "1";
			}
			else if (bits.charAt(i)=='1')
			{
				result += "0";
			}
			else
			{
				result += bits.charAt(i);
			}
		}
		return result;
	}
	
	private static String getReverse(String bits)
	{
		StringBuilder reverse = new StringBuilder(bits);
		reverse = reverse.reverse();
		return reverse.toString();
	}
	
	private static String getReverseComplement(String bits)
	{
		return getReverse(getComplement(bits));
	}
	
	private enum ChangeType {S, R, C, RC};
}

/*
RULES:

WORST CASE: 11111_11110_11111_11111
10 Queries, unsearched middle: 11110_11111
Magic happens, R+C, now 00000_00000_10000_00000 
20th query we realise we have 00_10.
Magic happens, C, now 11111_11111_01111_11111 
21st-24th queries verify the two anchor points, to see what happened to the data, updating our current knowledge (C happened, updated known knowledge:XXXXX_XXX11_01XXX_XXXXX).
25-30 are used to read the first 6 digits again (known knowledge:00000_0XX00_10XXX_XXXXX)
Magic happens, R, now 11111_11110_11111_11111 
31st-34th query verify the anchor points, to see what happened to the data, updating our current knowledge (R happened, updated known knowledge:XXXXX_XXX10_11XX1_11111).
35-40 are used to read the first 6 digits again (known knowledge:11111_1XX10_11XX1_11111)
Magic happens, C+R, now 00000_00000_10000_00000
41st-44th query verify the anchor points, to see what happened to the data, updating our current knowledge (C+R happened, updated known knowledge:00000_0XX00_10XX0_00000).
45-48 verify the remaining data (known knowledge:00000_00000_10000_00000).
SEND ANSWER.

EDGE CASE (No Anchor)
Once all possible anchors are checked, if there are no candidates that means the string is a palindrome so REVERSE will have no effect.
THis means we can use a single value (the first bit) as our anchor value.
*/