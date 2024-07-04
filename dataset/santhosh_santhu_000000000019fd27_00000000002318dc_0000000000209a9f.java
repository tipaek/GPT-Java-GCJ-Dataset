import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String[] arr=new String[t];
        String[] ar=new String[t];
        for(int i=0;i<t;i++)
        {
            arr[i]=sc.next();
        }
        String word="";
        for(int i=0;i<t;i++)
        {
            word="";
        for(int j=0;j<arr[i].length();j++)
        {
            if(j==0 && arr[i].charAt(j)=='1'&& j==arr[i].length()-1)
            {
                word=word+"(1)";
            }
            else if(j==0 && arr[i].charAt(j)=='1')
            {
                word=word+"(1";
            }
            else if(j==0 && arr[i].charAt(j)=='0')
            {
                word=word+"0";
            }
            else if(arr[i].charAt(j-1)=='0'&& arr[i].charAt(j)=='1' && j==arr[i].length()-1)
                word=word+"(1)";
                else if(arr[i].charAt(j-1)=='1'&& arr[i].charAt(j)=='1' && j==arr[i].length()-1)
                word=word+"1)";
            else if(arr[i].charAt(j)=='1' && arr[i].charAt(j-1)=='0')
            {
                word=word+"(1";
            }
            else if(arr[i].charAt(j-1)=='1' && arr[i].charAt(j)=='0')
            {
                word=word+")0";
            }
            else if(j!=arr[i].length()-1 && arr[i].charAt(j)=='1' && arr[i].charAt(j+1)=='1')
            {
                word=word+"1";
            }
            else if(j!=arr[i].length()-1 && arr[i].charAt(j)=='1' && arr[i].charAt(j+1)=='0')
            {
                word=word+"1";
            }
            else if(arr[i].charAt(j)=='0')
            {
                word=word+"0";
            }
            
        }
        ar[i]=word;
        }
        for(int i=0;i<ar.length;i++)
        System.out.println("Case #"+(i+1)+": "+ar[i]);
        }
}