/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> old2New = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        old2New.put(node, new Node(node.val));
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            for (Node neighbor: n.neighbors){
                if (!old2New.containsKey(neighbor)) {
                    old2New.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                old2New.get(n).neighbors.add(old2New.get(neighbor));
            }
        }
        return old2New.get(node);
    }
}