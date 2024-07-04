import java.util.*;
public class Solution 
{
    
   int lcs1( char[] X, char[] Y, int m, int n ) 
  { 
    int L[][] = new int[m+1][n+1]; 
  
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } 
  return L[m][n]; 
  } 
  
   int lcs2( char[] X, char[] Y, int m, int n ) 
  { 
    int L[][] = new int[m+1][n+1]; 
  
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } 
  return L[m][n]; 
  } 
  
  /* Utility function to get max of 2 integers */
  int max(int a, int b) 
  { 
    return (a > b)? a : b; 
  } 
    
    
    
	public static void main (String[] jatin_is_my_name) 
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i_am_a_dico_dancer=1;i_am_a_dico_dancer<=t;i_am_a_dico_dancer++)
		{

/*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
			boolean my_nagu_is_back=true;
/*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		    int c=0;
		    
		    HashMap<Integer,String>this_is_my_first_map=new HashMap<>();

			int jumping_japak_jampak_jampak=0;
/*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */


		    int n=scan.nextInt();
		    ArrayList<thisone_is_min_class>this_is_my_list=new ArrayList<>();
		    for(int i=0;i<n;i++)
			{
			    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		        this_is_my_list.add(new thisone_is_min_class(scan.nextInt(),i+1));
		        this_is_my_list.add(new thisone_is_min_class(scan.nextInt(),-1*(i+1)));
		    }
		    Collections.sort(this_is_my_list,new Comparator<thisone_is_min_class>()
			{
			    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		        public int compare(thisone_is_min_class p1,thisone_is_min_class p2)
				{
				    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		            if(p1.this_is_my_variable_okkey==p2.this_is_my_variable_okkey)
					{
					    
					    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		                if(p1.this_one_is_my_index<0)
						{
						    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		                    return -1;
		                }
		                else
						{
						    
						    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		                    return 1;
		                }
		            }
		            return p1.this_is_my_variable_okkey-p2.this_is_my_variable_okkey;
		        }
		    }
			);       
		    
			
		    for(int i=0;i<=this_is_my_list.size()-1;i++)
			{
			    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		        if(this_is_my_list.get(i).this_one_is_my_index>0l)
				{
		            if(c==0)
					{
					    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		                this_is_my_first_map.put(this_is_my_list.get(i).this_one_is_my_index,"C");
		                c=this_is_my_list.get(i).this_one_is_my_index;
		            }
		            else if(jumping_japak_jampak_jampak==0)
					{
		                 this_is_my_first_map.put(this_is_my_list.get(i).this_one_is_my_index,"J");
		                 jumping_japak_jampak_jampak=this_is_my_list.get(i).this_one_is_my_index;
		            }
		            else
					{
		                my_nagu_is_back=false;
		                break;
		            }
		        }
		        else
				{
		            if(jumping_japak_jampak_jampak==(this_is_my_list.get(i).this_one_is_my_index)*(-1))
					{
					    /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		                jumping_japak_jampak_jampak=0;
		            }
		            else
					{
		                c=0;
		            }
		        }
		    }
		    if(!my_nagu_is_back)
			{
		        System.out.print("Case #"+i_am_a_dico_dancer+": "+"IMPOSSIBLE");
		        System.out.println();
		    }
		    else
		    {
		        /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		        System.out.print("Case #"+i_am_a_dico_dancer+": ");
		        for(int i=1;i<n+1;i++)
		        {
		            /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		            System.out.print(this_is_my_first_map.get(i));
		        }
		        System.out.println();
		    }
		}
	}
}




class thisone_is_min_class
{
    
    int this_is_my_variable_okkey;
    int this_one_is_my_index;
    char c;
    int temp_is_going_to_die=0;
    int this_is_one_more=0;


/*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */

	 thisone_is_min_class()
	 {
		 this_one_is_my_index=0;
		 this_is_my_variable_okkey=0;
	 }
	 
	 /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */

    thisone_is_min_class(int a,int b)
    {
        
        /*for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } */
		 this_one_is_my_index=b;
        this_is_my_variable_okkey=a;
       
    }
}