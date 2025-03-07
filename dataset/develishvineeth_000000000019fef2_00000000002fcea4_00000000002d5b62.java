import java.util.*;




class Solution
{
    static HashSet<String> hs=new HashSet<>();
    static void findallpossible(char[] set, int k) 
{ 
	int n = set.length; 
    printAllKLengthRec(set, "", n, k); 
    
} 


static void printAllKLengthRec(char[] set, 
							String prefix, 
							int n, int k) 
{ 
	
	
	if (k == 0) 
	{ 
		hs.add(prefix); 
		return; 
	} 

	
	for (int i = 0; i < n; ++i) 
	{ 

		
		String newPrefix = prefix + set[i]; 
		
		
		printAllKLengthRec(set, newPrefix, 
								n, k - 1); 
	} 
} 


    

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int t=s.nextInt();
        int t1=1;
        while(t-->0)
        {
            int x=s.nextInt();
            int y=s.nextInt();
            char[] directions = {'N', 'S', 'E', 'W'};
            String ans="IMPOSSIBLE";
           outer: for(int k=1;k<5;k++)
            {
                findallpossible(directions, k);
                //System.out.println(hs);
                for (String str : hs) {
                    if(calculate(str.toCharArray(),x,y))
                    {
                        ans=str;
                        break outer;
                    }
                }
            }
            System.out.println("Case #"+t1+": "+ans);
        }
        
        
        s.close();
    }

    private static boolean calculate(char[] charArray, int x, int y) {
        int currx=0,curry=0;
        int value=1;
        for(int i=0;i<charArray.length;i++)
        {
            
            switch(charArray[i])
            {
                case 'N': currx+=value;break;
                case 'S': currx-=value;break;
                case 'E': curry+=value;break;
                case 'W': curry-=value;break;
            }
            value=value*2;
        }
        if(currx==y && curry==x)
        return true;
        return false;
    }

}