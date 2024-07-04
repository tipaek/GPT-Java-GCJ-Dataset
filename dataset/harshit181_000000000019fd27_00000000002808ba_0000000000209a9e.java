
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String data[]=br.readLine().split(" ");
	int t=Integer.valueOf(data[0]);
	int b=Integer.valueOf(data[1]);
	
	for(int tada=1; tada<=t;tada++)
	{
		
		int arrInit[]=new int[b];
		for(int i=0;i<arrInit.length;i++)
		{
			arrInit[i]=-1;
		}
		
		
		boolean isDone=false;
		int count=0;
		ArrayList<Object> possibleList=new ArrayList<Object>();
		possibleList.add(arrInit);
		while(!isDone)
		{
			
			
			if(possibleList.size()==1) {
				int arr[]=(int[]) possibleList.get(0);
			for(int i=0;i<b/2;i++)
			{
				if(arr[i]==-1) {
				arr[i]=sendData(i, br);
				arr[b-1-i]=sendData(b-1-i, br);
				count+=2;
				}
				if(count%10==0||i==b/2-1)
				{
					
					isDone=addDataToList(isDone, arr, possibleList, br,count);
					break;
					
				}
				
			}
			
			
			
			
					
		}
		else 
			{
			
			boolean needToCheck=true;
			
				int arrTemp[]=new int[b];
				for(int i=0;i<arrTemp.length;i++)
				{
					arrTemp[i]=-1;
				}
				
				for(int i=b/2;i>=0;i--)
				{
					int tempData[]=(int [])possibleList.get(0);
					if(tempData[i]!=-1) {
					arrTemp[i]=sendData(i, br);
					count+=1;
					for(int d=possibleList.size()-1;d>=0;d--)
					{
						if(!verifyArr((int [])possibleList.get(d), arrTemp))
						{
							possibleList.remove(d);
						}
					}
					if(count%10==0)
					{
						ArrayList<Object> possibleList2=new ArrayList<Object>();
						for(Object nopeArray:possibleList) {
						addDataToList(isDone, (int [])nopeArray, possibleList2, br,count);
						}
						possibleList.addAll(possibleList2);
						needToCheck=false;
						break;
					}
					if(possibleList.size()==1)
					{
						if(count%2!=0)
						{
							//Evening the odd
							sendData(i, br);
							count++;
	
						}
						needToCheck=false;
						break;
					}
					
				}
				}
				if(needToCheck)
				for(int i=b/2;i<b;i++)
				{
					int tempData[]=(int [])possibleList.get(0);
					if(tempData[i]!=-1) {
					arrTemp[i]=sendData(i, br);
					count+=1;
					for(int d=possibleList.size()-1;d>=0;d--)
					{
						if(!verifyArr((int [])possibleList.get(d), arrTemp))
						{
							possibleList.remove(d);
						}
					}
					if(count%10==0)
					{
						ArrayList<Object> possibleList2=new ArrayList<Object>();
						for(Object nopeArray:possibleList) {
						addDataToList(isDone, (int [])nopeArray, possibleList2, br,count);
						}
						possibleList.addAll(possibleList2);
						needToCheck=false;
						break;
					}
					if(possibleList.size()==1)
					{
						if(count%2!=0)
						{
							//Evening the odd
							sendData(i, br);
							count++;
	
						}
						needToCheck=false;
						break;
					}
					
				}
				}
				
	}
		}
		
		
	}
	
	
}
	
	public static boolean addDataToList(boolean isDone,int arr[],ArrayList<Object> possibleList,BufferedReader br,int count) throws Exception
	{
		if(allDone(arr))
		{
			String toPrint="";
			for(int x:arr)
			{
				toPrint=toPrint+x;
			}
			System.out.println(toPrint);
			String answer=br.readLine();
			if(answer.equals("N"))
				System.exit(0);
			isDone=true;
		}
		int arr1[]=reverse(arr);
		int arr2[]=compliemnt(arr);
		int arr3[]=reverse(arr2);
		if(!Arrays.equals(arr, arr1))
		possibleList.add(arr1);
		if(!Arrays.equals(arr2, arr1)&&!Arrays.equals(arr, arr2))
		possibleList.add(arr2);
		if(!Arrays.equals(arr3, arr1)&&!Arrays.equals(arr, arr3)&&!Arrays.equals(arr2, arr3))
		possibleList.add(arr3);
		
		return isDone;
	}
	
	public static boolean verifyArr(int arr[],int arrTemp[])
	{
		int n=arrTemp.length;
		for(int i=0;i<arrTemp.length;i++)
		{
			if(arrTemp[i]==-1)
				continue;
			else if(arrTemp[i]!=arr[i]&&arrTemp[n-i-1]!=arr[n-i-1])
			{
				return false;
			}
		}
		return true;
		
	}
	public static boolean allDone(int arr[]) {
		for(int x:arr)
		{
			if(x==-1)
				return false;
		}
		return true;
		
	}

	public static int sendData(int loc,BufferedReader br) throws Exception
	{
		System.out.println(loc+1);
		String toReturn=br.readLine();
		if(toReturn.equalsIgnoreCase("N"))
		{
			
			System.exit(0);
		}
		return Integer.valueOf(toReturn);
	}
	
	public static int [] reverse(int arr[]) {
		
		int n=arr.length;
		int retu[]=new int[n];
		for(int i=0;i<n;i++)
		{
			retu[i]=arr[n-i-1];
		}
		return retu;
		
	}
	
	public static int[] compliemnt(int arr[])
	{
		
		int n=arr.length;
		int retu[]=new int[n];
		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				retu[i]=1;
			}
			else if(arr[i]==1)
			{
				retu[i]=0;
			}
			else
			{
				retu[i]=arr[i];
			}
		}
		return retu;
		
	}
	public static int[] doBoth(int arr[])
	{
		int arr1[]=reverse(arr);
		int arr2[]=compliemnt(arr1);
		return arr2;
	}
}


