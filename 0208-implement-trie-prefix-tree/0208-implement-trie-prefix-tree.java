class Trie {
    
    public static class Node{
        char ch;
        Node[] children;
        boolean isTerminal;
        public Node(char ch){
            this.ch = ch;
            children = new Node[26];
            isTerminal = false;
        }
    }

    Node Root;
    
    public Trie() {
        Root = new Node('\0');
    }
    
    public void insert(String word) {
        insertHelper(Root, word);
    }
    
    public void insertHelper(Node root, String word){
        if(word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        
        int index = word.charAt(0) - 'a';
        Node child;
        
        if(root.children[index] != null){
            child = root.children[index];
        }
        else{
            child = new Node(word.charAt(0));
            root.children[index] = child;
        }
        insertHelper(child, word.substring(1));
    }    
    
    
    
    public boolean search(String word) {
        return searchHelper(Root, word);
    }
    
    public boolean searchHelper(Node root, String word){
        if(word.length() == 0) return root.isTerminal;
        
        int index = word.charAt(0) - 'a';
        Node child;
        if(root.children[index] == null){
            return false;
        }
        else{
            child = root.children[index];
        }
        return searchHelper(child, word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        return startWithHelper(Root, prefix);
    }
    
    public boolean startWithHelper(Node root, String word){
        if(word.length() == 0) {
            System.out.println("Length over");
            return true;
        }
        
        int index = word.charAt(0) - 'a';
        Node child;
        
        if(root.children[index] == null){
            return false;
        }
        else{
            child = root.children[index];
        }
        return startWithHelper(child, word.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */