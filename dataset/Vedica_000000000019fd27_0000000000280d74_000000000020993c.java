import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int noCases=0;
		int Size=0;
		HashSet<Integer> row=new HashSet(); 
		HashSet<Integer> col=new HashSet(); 
		int num=0;
		int rowCount=0;
		int colCount=0;
		String res="";
		noCases=sc.nextInt();
		int sum=0;
		for(int i=0;i<noCases;i++) {
			Size=sc.nextInt();
			rowCount=0;
			colCount=0;
			sum=0;
			int arr[][]=new int[Size][Size];
			for (int r = 0, c = 0; r < Size;) {
				num=sc.nextInt();
				//System.out.println("++++++++++"+r+c+num);
				arr[r][c]=num;
				if(r==c) {
					sum+=num;
				}
				  if (c < Size-1) {
					  //System.out.println("Row.add(num) : "+num);
					  row.add(num);
					  ++c;
				  } 
				  else {
					  c = 0;
					  row.add(num);
					  if(row.size()<Size) {
						  //System.out.println("Row.size: "+row.size());
						  rowCount++;
					  }
					  row.clear();
					  col.add(num);
					  ++r;
					  
				  }
				  
				}
			for(int c=0;c<Size; c++) {
				col.clear();
				for(int r=0; r<Size;r++) {
					col.add(arr[r][c]);
				}
				if(col.size()<Size) {
					colCount++;
				}
			}
			String temp="Case #"+(i+1)+": "+sum+" "+rowCount+" "+colCount+"\n";
			res=res+temp;
		}
		System.out.println(res);
		
		
	}

}
