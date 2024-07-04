import javax.swing.text.html.CSS;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Map;
import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Solution{
    private static Scanner sc;
    static int t=1;
    
    public static void main(String []args)
    {
        sc=new Scanner (System.in);
        int test=sc.nextInt();
        sc.nextLine();
        while(test-- >0)
        {
            parenting();
        }
    }

    private static void parenting()
    {
        int n=sc.nextInt();
        int [][] arr=new int[n][2];
        int [][] arrSorted=arr.clone();
        char per='J';
        char[] ch=new char[n];
        Stack<int[]> JSt =new Stack<>();
        Stack<int[]> CSt =new Stack<>();
        boolean imp=false;

        Map<int[], Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
            map.put(arr[i],i);
        }

        Arrays.sort(arrSorted,new Comparator<int[]>(){
            @Override
            public int compare(int[] ar, int[] br) {
                return ar[0]-br[0];
            }
        
        });
        
        for(int i=0;i<arrSorted.length;i++)
        {
            ch[map.get(arrSorted[i])]=per;

            if(i<arrSorted.length -1 && dO(arrSorted[i],arrSorted[i+1]))
            {
                if(per=='J')
                {
                    JSt.push(arrSorted[i]);
                    per=getP(per);

                    if(!CSt.isEmpty() && dO(CSt.peek(),arrSorted[i+1]))
                    {
                        imp=true;
                        break;
                    }
                }else
                {
                    CSt.push(arrSorted[i]);
                    per=getP(per);

                    if(!JSt.isEmpty() && dO(JSt.peek(),arrSorted[i+1]))
                    {
                        imp=true;
                        break;
                    }
                }
            }else{
                if(per=='J')
                {
                    JSt.push(arrSorted[i]);
                }else
                {
                    CSt.push(arrSorted[i]);
                }
            }
        }
    System.out.println("Case #"+(t++)+": "+(imp ? "IMPOSSIBLE": new String(ch)));
  }

    private static char getP(char p)
    {
        return p =='J'?'C':'J';
    }
    private static boolean dO(int[] a,int[]b)
    {
        return a[1]>b[0];
    }
}
//22061









