import java.util.*;
public class Solution {
    int s;
    int[][] arr=new int[1000][1000];
    String[] sarr1=new String[10000];
    int ct=0;
    int c=0;
    private void permute(String str, int l, int r) 
    { 
        if (l == r) 
            sarr1[c++]=str;
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    }
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    public void makeArray(String s)
    {
        for(int i=0 ; i<s.length() ; i++)
        {
            arr[ct][i]=Integer.parseInt(s.charAt(i)+"");
        }
        ct++;
    }
    public void printArray()
    {
        for(int i=0 ; i<s ; i++)
        {   
            for(int j=0 ; j<s ; j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    }
    public void main() {
        int n,t,len,c,cct=0;
        int t1=0,t2=0,t3=0,t4=0,sum=0;
        String str="";
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Cases");
        n=in.nextInt();
        
    while(cct!=n)
    {
        Solution obj=new Solution();
        str="";
        c=0;
        System.out.println("Enter Size and Trace");
        s=in.nextInt();
        t=in.nextInt();
        String[] sarr=new String[s];
        for(int i=1 ; i<=s ; i++)
        {
            str+=i;
        }
        permute(str,0,str.length()-1);
        int flag=0;
        for(int z=0 ; z<50 ; z++){
            String str1=sarr1[z];
            if(str1!=null){
        for(int i=1 ; i<=s ; i++)
        {
        makeArray(str1);
        char ch=str1.charAt(str1.length()-1);
        str1=ch+str1.replace(str1.charAt(str1.length()-1)+"","");
    }
    for(int i=0 ; i<s ; i++)
    {
        sum+=arr[i][i];
    }
    if(sum==t)
    {
        System.out.println("Case #"+(++cct)+": POSSIBLE");
        flag=1;
        printArray();
    }
    }
    else 
        continue;
    }
    if(flag==0)
    {
        System.out.println("Case #"+(++cct)+": IMPOSSIBLE");
    }
}
}
}

