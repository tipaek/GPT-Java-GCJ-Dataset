class Solution{
public static void main(String[] args){
    int count=1;
    int number;
    int next_lines;
    String row;
    String num;
    int r=0;
    int c =0;
    int k=0;
    Scanner input = new Scanner(System.in);
    int test_case  = input.nextInt();
    while(count<=test_case){ 
        k=0;
        Scanner lines = new Scanner(System.in);
        next_lines = input.nextInt();
        int[][] matrix=new int[next_lines][next_lines];
        for (int i = -1; i <=next_lines-1; i++){
            Scanner line = new Scanner(System.in);
            row = input.nextLine();
            for(int j=0;row.length()>0;j++){
                if(row.length()>1){
                    num =row.substring(0,1);
                    number = Integer.parseInt(num);
                    matrix[i][j]=number;
                    row = row.substring(row.indexOf(" ")+1);
                }
                else{
                    number = Integer.parseInt(row);
                    matrix[i][j]=number;
                    row = "";
                }
            }
        }
        for(int l=0; l<next_lines;l++){
            k+=matrix[l][l];
        }
        for (int x = 0; x < matrix.length; x++)
    {
        for (int y = 0; y < matrix[x].length; y++)
        {
            int a = matrix[x][y];
            for (int b = y + 1; b < matrix.length; b++)
            {
                if (a == matrix[x][b])
                {
                  if(r<=x)
                    r++;
                }
            }
            
        }
    }
        for (int m = 0; m < matrix.length; m++)
    {
        for (int n = 0; n < matrix.length; n++)
        {
            int a = matrix[n][m];
            for (int d = n + 1; d < matrix.length; d++)
            {
                if (a == matrix[d][m])
                {
                  if(c<=m)
                    c++;
                  n=matrix.length;
                }
            }
            
        }
    }
    System.out.println("Case #"+count+": "+k+ " " + r + " " + c);
    count++; 
    r=0;
    c=0;
    }
    
}

}

  
