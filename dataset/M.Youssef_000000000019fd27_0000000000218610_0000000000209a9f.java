import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Solution {

	private int top = -1;
	private String[] arrayStr = new String[20];
	
	public void push(String s)
	{
		top++;
		arrayStr[top] = s;
	}
	
	public String pop()
	{
		String s = null;
		if(top > -1)
		{
			s = ")";
			top--;	
		}
		return s;
	}
	
	public int getSize()
	{
		return top + 1;
	}
	
	public static void main(String[] args) {
		try
		{
			Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			//Discard first line
			String noOfTestCases = scanner.nextLine();
			
			Solution paranthesis = new Solution();
			String number;
			for(int counter = 1; counter < Integer.parseInt(noOfTestCases) + 1; counter++)
			{
			number = scanner.nextLine();
			int sizeOfStringPassed = number.length();
			String construct = "";
			String finalValue = "";
			int sizeOfStack = 0;
			
			
			for (int i = 0; i < sizeOfStringPassed; i++)
			{
				finalValue = "";
				int OneNum = number.charAt(i) - 48;
				sizeOfStack = paranthesis.getSize();
				//First time or empty stack
				if(0 == sizeOfStack)
				{
					//Empty stack
					for(int j = 0; j < OneNum; j++)
					{
						paranthesis.push("(");
						finalValue += "(";
					}
					finalValue += OneNum;
					construct += finalValue;
				}
				else
				{
					//Not empty
					if(sizeOfStack == OneNum)
					{
						construct += OneNum;
					}
					else
					{
						int diff = Math.abs(sizeOfStack - OneNum);
						if(sizeOfStack < OneNum)
						{
							for(int j = 0; j < diff; j++)
							{
								paranthesis.push("(");
								finalValue += "(";
							}
						}
						else
						{
							for(int j = 0; j < diff; j++)
							{
								finalValue += paranthesis.pop();
							}
						}
						finalValue += OneNum;
						construct += finalValue;
					}
					
				}
			
				if (sizeOfStringPassed == (i + 1))
				{
					sizeOfStack = paranthesis.getSize();
					for(int j = 0; j < sizeOfStack; j++)
					{
						construct += paranthesis.pop();
					}
				}
			}
			
			System.out.println("Case #" + counter + ": " + construct);
	
			}
		}
	catch(Exception e){
	     System.out.println(e);
	    }
	}

}
