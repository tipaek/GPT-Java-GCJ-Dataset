import java.util.*;
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int c=sc.nextInt();
        for(int d=1;d<=c;d++)
        {

            int size=sc.nextInt();
            int matrix[][]=new int[size][size];

            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    matrix[i][j]=sc.nextInt();
                }
            }

            int k=trace(matrix,size);
            int column=columnDup(matrix,size);
            int row=rowDup(matrix,size);

            

            System.out.println("Case #" +d+ ":"+" " +k+ " " +row+ " " +column); 
        }
    }

    public static int trace(int a[][],int size){
        int sum=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j) {
                    sum=sum+a[i][j];
                }
            }
        }
        return sum;
    }
    public static int rowDup(int a[][],int size){
        Hashtable<Integer,Integer> rowTable=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++){
            int row[]=a[i];
            for(int j=0;j<row.length;j++){
                if(rowTable.containsKey(row[j])){
                    count++;
                    break;
                } else {
                    rowTable.put(row[j],1);
                }
            }
            rowTable.clear();
        }
        return count;
    }

    public static int columnDup(int a[][],int size){
        Hashtable<Integer,Integer> colTable=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int element=a[j][i];
                if(colTable.containsKey(element)){
                    count++;
                    break;
                } else {
                    colTable.put(element,1);
                }
            }
            colTable.clear();
        }
        return count;

	}

}
