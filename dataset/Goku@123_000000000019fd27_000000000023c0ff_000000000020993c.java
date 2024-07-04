

import java.util.*;

 class LatinMatrix{

	public static void main(String[] args)
	{
		LatinMatrix lmObj = new LatinMatrix();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Scanner scan = new Scanner(System.in);
		int noTestCases = Integer.parseInt(scan.nextLine());
		List<List<Integer>> matrix;
		int sizeMatrix=0;
		for(int i=1;i<=noTestCases;i++)
		{
			sizeMatrix=Integer.parseInt(scan.nextLine());
			matrix= lmObj.createMatrix(sizeMatrix,result,scan);
			lmObj.checkForColumn(result,i-1,matrix);
		}
		
		int caseNo=1;
		for(List<Integer> list: result)
		{	System.out.print("Case #"+caseNo+":");
			for(Integer intObj: list)
			{
				System.out.print(intObj);
			}
			caseNo++;
			System.out.println();
		}
	}
	

	public List<List<Integer>>createMatrix(int n,List<List<Integer>> result, Scanner scan)
	{
		List<Integer> resultRowList = new LinkedList<Integer>();
		List<List<Integer>> matrix = new LinkedList<List<Integer>>();
		List<Integer> traverRowList =null;
		Set<Integer> rowSet = new HashSet<Integer>();
		int sum =0,row=0,noToadd=0;
		boolean onceDone = false;
		
		for(int i=0;i<n;i++)
		{
			String tmp =  scan.nextLine();
			String[] str = tmp.split("\\s+");
			int k=0;
			rowSet.clear();
			traverRowList= new LinkedList<Integer>();
			for(int j=0;j<n;j++)
			{
				noToadd=0;
				noToadd= Integer.parseInt(str[k]);
				traverRowList.add(noToadd);
				if(!rowSet.add(noToadd) &&!onceDone)
				{
					onceDone= true;
					row++;
				}
				if(i==j)
				{
					sum= sum+noToadd;
				}
				k++;
			}
			onceDone= false;
			matrix.add(traverRowList);
		}
		resultRowList.add(sum);
		resultRowList.add(row);
		result.add(resultRowList);
		return matrix;
	}


	public void checkForColumn(List<List<Integer>> outputList,int pos, List<List<Integer>>  matrix)
	{
		int length = matrix.size()-1;
		List<Integer> travRowList =null;
		Set<Integer> colSet = new HashSet<Integer>();
		int col=0;
		while(length>=0){

			colSet.clear();
			for(int i=0;i<=matrix.size()-1;i++)
			{
				travRowList= matrix.get(i);
				if(!colSet.add(travRowList.get(length)))
				{
					col++;
					break;
				}
			}
			length--;
		}
		outputList.get(pos).add(col);
	}
}