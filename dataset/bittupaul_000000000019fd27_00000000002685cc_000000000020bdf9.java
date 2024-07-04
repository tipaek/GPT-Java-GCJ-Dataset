import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        for(int i=0;i<t;i++)
        {
            n = sc.nextInt();
            int arr[][] = new int[n][2];
            for(int j=0;j<n;j++)
                for(int k=0;k<2;k++)
                    arr[j][k] = sc.nextInt();
            Arrays.sort(arr, new Comparator<int[]>(){
                @Override
                public  int compare(final int[] entry1, final int[] entry2) { 
                if (entry1[0] > entry2[0]) 
                    return 1; 
                else
                    return -1; 
                }
            });
            String result="";
            int lastJ = 0, lastC = 0;
            if(arr[1][0]>=arr[0][1]){
                result = "JJ";
                lastJ = 1;
                lastC = -1;
            }
            else{
                result = "JC";
                lastJ = 0;
                lastC = 1;
            }
            boolean isImpossible = false;
            
            for(int k=2;k<n;k++)
            {
                if(arr[k-1][1]>arr[k][0])/*finish > start*/{
                    if(result.substring(result.length()-1, result.length()).equals("C")){
                        if(arr[lastJ][1]<=arr[k][0]){
                            result+="J";
                            lastJ = k;
                        }
                        else {isImpossible = true; break;}
                    }
                    else{
                        if(lastC!=-1){
                        if(arr[lastC][1]<=arr[k][0]){
                            result+="C";
                            lastC = k;
                        }
                        else {isImpossible = true; break;}    
                        }
                        else
                        {
                            result+="C";
                            lastC = k;
                        }
                    }        
                }
                else/*finish <= start*/{
                    if(result.substring(result.length()-1, result.length()).equals("C")){
                        if(arr[lastJ][1]<=arr[k][0]){
                            result+="J";
                            lastJ = k;
                        }
                        else {result+="C"; lastC=k;}
                    }
                    else{
                        if(lastC!=-1){
                        if(arr[lastC][1]<=arr[k][0]){
                            result+="C";
                            lastC = k;
                        }
                        else {result+="J"; lastJ=k;}    
                        }
                        else
                        {
                            result+="C";
                            lastC = k;
                        }
                    }
                }
            }//end of arr traversal
        if(isImpossible){
            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
        else{
            System.out.println("Case #"+(i+1)+": "+result);
        }
        }//end of test cases for loop
    } //end of method
}//end of class