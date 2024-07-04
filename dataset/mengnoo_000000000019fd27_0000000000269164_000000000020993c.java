import java.util.*;
//import java.collections.Set;
public class Vestigium{
public static void main(String[] args){
int[][] mat;
int j=0;int k=0;
int nr=0,nc=0,d=0;
Set<Integer> set = new HashSet();
//int cr=0,cc=0;
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
for(int i=0;i<x;i++)
{

int y =sc.nextInt();
mat= new int[y][y];

// filling matrix
for(j=0;j<y;j++)
for(k=0;k<y;k++)
{
 mat[j][k]=sc.nextInt();
}


//checking repeated rows
nr=0;
for(j=0;j<y;j++)
    {set.clear();
      for(k=0;k<y;k++)
        {
        	if(set.contains(mat[j][k]))
        		{nr++;break;}
			set.add(mat[j][k]);
        }
       
    }


    // checking repeated col;
    nc=0;
    for(j=0;j<y;j++)
    {set.clear();
      for(k=0;k<y;k++)
        {
        	if(set.contains(mat[k][j]))
        		{nc++;break;}
			set.add(mat[k][j]);
        }
       
    }

    //calculating diagonal
    j=0;d=0;
    while(j<y)
      {d+=mat[j][j]; j++;}

 System.out.println("case #"+i+": "+d+" "+nr+" "+nc);
 return;   
}
}
}