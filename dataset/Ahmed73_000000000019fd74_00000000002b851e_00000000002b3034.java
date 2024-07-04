class GFG 
{ 
  
static int ALPHABET_SIZE = 26; 
  
// Trie node 
static class TrieNode 
{ 
    TrieNode []children =  
    new TrieNode[ALPHABET_SIZE]; 
  
    // isEndOfWord is true if node 
    // represents the end of the word 
    boolean isEndOfWord; 
  
    public TrieNode() 
    { 
        super(); 
    } 
      
}; 
  
// Returns new trie node 
static TrieNode getNode() 
{ 
    TrieNode pNode = new TrieNode(); 
  
    pNode.isEndOfWord = false; 
  
    for (int i = 0; i < ALPHABET_SIZE; i++) 
        pNode.children[i] = null; 
  
    return pNode; 
} 
  
// If not present, inserts key into trie 
// If the key is prefix of trie node, 
// marks the node as leaf node 
static void insert(TrieNode root, String key) 
{ 
    TrieNode pCrawl = root; 
  
    for (int i = 0; i < key.length(); i++) 
    { 
        int index = key.charAt(i) - 'a'; 
        if (pCrawl.children[index] == null) 
            pCrawl.children[index] = getNode(); 
  
        pCrawl = pCrawl.children[index]; 
    } 
  
    // Mark node as leaf 
    pCrawl.isEndOfWord = true; 
} 
  
// Returns true if the key is present in the trie 
static boolean search(TrieNode root, String key) 
{ 
    TrieNode pCrawl = root; 
  
    for (int i = 0; i < key.length(); i++) 
    { 
        int index = key.charAt(i) - 'a'; 
        if (pCrawl.children[index] == null) 
            return false; 
  
        pCrawl = pCrawl.children[index]; 
    } 
  
    return (pCrawl != null && pCrawl.isEndOfWord); 
} 
  
// Result stores the current prefix with 
// spaces between words 
static void wordBreakAll(TrieNode root, 
                String word, int n, String result) 
{ 
    // Process all prefixes one by one 
    for (int i = 1; i <= n; i++)  
    { 
  
        // Extract subString from 0 to i in prefix 
        String prefix = word.substring(0, i); 
  
        // If trie conatins this prefix then check 
        // for the remaining String. 
        // Otherwise ignore this prefix 
        if (search(root, prefix)) 
        { 
  
            // If no more elements are there then print 
            if (i == n)  
            { 
  
                // Add this element to the previous prefix 
                result += prefix; 
  
                // If(result == word) then return 
                // If you don't want to print last word 
                System.out.print("\t" + result +"\n"); 
                return; 
            } 
            wordBreakAll(root, word.substring(i, n), n - i, 
                        result + prefix + " "); 
        } 
    } 
} 
  
// Driver code 
public static void main(String[] args) 
{ 
    new TrieNode(); 
    TrieNode root = getNode(); 
  
    String dictionary[] = {"sam", "sung", 
                            "samsung"}; 
    int n = dictionary.length; 
  
    for (int i = 0; i < n; i++) 
    { 
        insert(root, dictionary[i]); 
    } 
  
    for (int i = 0; i < n; i++) 
    { 
        System.out.print(dictionary[i]+ ": \n"); 
        wordBreakAll(root, dictionary[i], 
                    dictionary[i].length(), ""); 
    } 
} 
}