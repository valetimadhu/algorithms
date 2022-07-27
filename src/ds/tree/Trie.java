package ds.tree;

import java.util.Arrays;

public class Trie {
	
	private TrieNode root;
	
	Trie(){
		root = new TrieNode();
	}
	
	public int getIndex(char t) {
		return t-'a';
	}
	
	public TrieNode getRoot() {
		return this.root;
	}
	
	public void insert(String key) {
		if(key == null) {
			System.out.println(" Null key can't insert");
			return;
		}
		key = key.toLowerCase();
		TrieNode current = this.root;
		int index =0;
		for(int i=0; i< key.length(); i++) {
			index = getIndex(key.charAt(i));
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.markAsLeaf();
		
	}
	
	
	public boolean search(String key) {
		if(key == null ) return false;
		key = key.toLowerCase();
		TrieNode current = this.root;
		int index =0;
		for(int i=0; i< key.length(); i++) {
			index = getIndex(key.charAt(i));
			if(current.children[index] == null ) return false;
			current = current.children[index];
		}
		return current.isEndWord;
	}
	
	public int totalWords(TrieNode root) {
		int result =0;
		if(root.isEndWord) result ++;
		
		for(int i=0; i< 26; i++) {
			if(root.children[i] != null) {
				result += totalWords(root.children[i]);
			}
		}
		return result;
	}
	
	public boolean isFormationPossible(String[] dict, String word) {
		if(word.length() <2 || dict.length < 2) return false;
		Trie trie = new Trie();
		for(String str: dict) {
			trie.insert(str);
		}
		for(int i=0; i< word.length(); i++) {
			String first = word.substring(0,i);
			String second = word.substring(i, word.length());
			if(trie.search(first) && trie.search(second)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", "there", "answer", "any",
	                     "by", "bye", "their","abc"};
	    String output[] = {"Not present in trie", "Present in trie"};
	    Trie t = new Trie();
	    
	    System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");
	        
	    // Construct trie       
	    int i;
	    for (i = 0; i < keys.length ; i++)
	    {
	      t.insert(keys[i]);
	      System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
	    }
	    
	 // Search for different keys
	    if(t.search("the") == true)
	      System.out.println("the --- " + output[1]);
	    else System.out.println("the --- " + output[0]);
	         
	    if(t.search("these") == true)
	      System.out.println("these --- " + output[1]);
	    else System.out.println("these --- " + output[0]);
	         
	    if(t.search("abc") == true)
	      System.out.println("abc --- " + output[1]);
	    else System.out.println("abc --- " + output[0]);
	    
	    System.out.println(t.totalWords(t.getRoot()));
	    
	    String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};
	    if(t.isFormationPossible(dict, "helloworld"))
	        System.out.println("true");
	      else
	        System.out.println("false");
	    
	}

}

class TrieNode{
	TrieNode[] children;
	boolean isEndWord;
	static final int ALPHABET_SIZE = 26;
	
	TrieNode(){
		this.isEndWord = false;
		children = new TrieNode[ALPHABET_SIZE];
	}
	
	public void markAsLeaf() {
		this.isEndWord = true;
	}
	
	public void unMarkAsLeaf() {
		this.isEndWord = false;
	}
 }

