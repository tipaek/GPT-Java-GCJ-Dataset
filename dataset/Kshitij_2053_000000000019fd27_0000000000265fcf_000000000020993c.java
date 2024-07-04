import java.util.Scanner;
import java.util.Vector;

public class Trace
{

	public int findTrace(Vector<Vector<Integer>> mat, int size)
	{
		int ans = 0;
		for(int i=0; i<size; i++)
			ans+=mat.get(i).get(i);
		return ans;
	}

	public int checkRows(Vector<Vector<Integer>> mat, int size)
	{
		int ans = 0;
		Vector<Integer> vec;
		for(int i=0; i<size; i++)
		{
			vec = mat.get(i);
			ans += checkDuplicate(vec, size);
		}
		return ans;
	}

	public int checkCols(Vector<Vector<Integer>> mat, int size)
	{
		int ans = 0;
		Vector<Integer> vec = new Vector<Integer>();
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				vec.add(mat.get(j).get(i));
			}
			ans += checkDuplicate(vec, size);
			vec.clear();
		}
		return ans;
	}

	public int checkDuplicate(Vector<Integer> vec, int size)
	{ 
		int flag = 0;
		for(int i=0; i<size-1; i++)
		{
			for(int j=i+1; j<size; j++)
			{
				if(vec.get(i)==vec.get(j))
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		return flag;
	}

	public static void main(String[] args)
	{
		Vector<Vector<Integer>> matrix = new Vector<Vector<Integer>>();
		Vector<Integer> vec = new Vector<Integer>();
		int size=0, temp;
		Trace obj = new Trace();
		Scanner myObj = new Scanner(System.in);
		int total_cases = myObj.nextInt();
		for(int i=1; i<=total_cases; i++)
		{
			size = myObj.nextInt();
			for(int j=0; j<size; j++)
			{
				matrix.add(new Vector<Integer>());
				for(int k=0; k<size; k++)
				{
					temp = myObj.nextInt();
					matrix.get(j).add(temp);
				}
			}
			System.out.println("Case #" + i + ": " + obj.findTrace(matrix, size) + " " + obj.checkRows(matrix, size) + " " + obj.checkCols(matrix, size));
			matrix.clear();
		}
	}
}