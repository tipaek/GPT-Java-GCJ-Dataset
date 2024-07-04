import java.util.*;
class Codejam{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i =1 ;i<=t;i++)
    {
        String s = sc.next();
        String res = "";
        char temp[] = s.toCharArray();
        char arr[] = new char[temp.length+1];
        int front =1;
        arr[front] = temp[0];
        for(int j = 1;j<temp.length;j++)
        {

            if(arr[front]==temp[j] || front==0)
            {
                front++;
                arr[front] = temp[j];
            }
            else
            {
                int n = Character.getNumericValue(arr[front]);
                //System.out.println(n);
                for(int k = 0;k<n;k++ )
                {
                    res += "(";
                }
                while(front>=1)
                {
                    res+=arr[front];
                    front--;
                }
                for(int k = 0;k<n;k++ )
                {
                    res += ")";
                }
            }
            if(front==0)
              arr[++front] = temp[j];
        }
        if(front>=1)
        {
            int n = Character.getNumericValue(arr[front]);
                for(int k = 0;k<n;k++ )
                {
                    res += "(";
                }
                while(front>=1)
                {
                    res+=arr[front];
                    front--;
                }
                for(int k = 0;k<n;k++ )
                {
                    res += ")";
                }
        }
System.out.println("case #"+i+": "+res);
    }
  }
}
