import java.util.*;
class Vestigium
{
    public void vestigium(int Case)
    {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the size of Matrix : ");
        int size = inp.nextInt();
        int array[][] = new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                array[i][j] = inp.nextInt();
                
            }
            //System.out.println(" ");
        }
        //int array[][]={{1,2,3,4},{2,1,4,3},{3,4,1,2},{4,3,2,1}};
        int sum = 0;
        int rowsRep= 0 ;
        int colRep = 0 ;
        for(int i=0;i<size;i++)
        {
            int count[]= new int[size]; 
            
            for(int j=0;j<size;j++)
            {
                if(i==j)
                {
                    sum= sum+array[i][j];
                }
                int val1 = array[i][j];
                
                for(int k=0;k<size;k++)
                {
                    if(val1==array[i][k])
                    {
                        count[j]++;
                    }
                }  
            }
            boolean flag = false ;
            for(int l=0;l<size;l++)
            {
                if(count[l]>1)
                {
                    flag = true ;
                }
            }
            if(flag==true)
            {
                rowsRep++;
            }
        }        
        for(int i=0;i<size;i++)
        {
            int count[]= new int[size]; 
            for(int j=0;j<size;j++)
            {
                int val1 = array[i][j];
                
                for(int k=0;k<size;k++)
                {
                    if(val1==array[k][i])
                    {
                        count[j]++;
                    }
                }  
            }
            boolean flag = false ;
            for(int l=0;l<size;l++)
            {
                if(count[l]>1)
                {
                    flag = true ;
                }
            }
            if(flag==true)
            {
                colRep++;
            }

        }
        System.out.println("Case #"+(Case+1)+":"+sum + " "+rowsRep+" "+colRep);
    }
}
class Google_Competition {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the number of test Cases : ");
        int NumTestCases = inp.nextInt();
        Vestigium V1 = new Vestigium();
        for(int i=0;i<NumTestCases;i++)
        {
            //System.out.print("Case #"+(i+1)+":");
            V1.vestigium(i);
        }
        
    }
    
}
