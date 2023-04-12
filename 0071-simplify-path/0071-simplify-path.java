class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb=new StringBuilder();
        Deque<String>st=new LinkedList<>();
        for(String p :path.split("/"))
        {
            if(p.equals("") || p.equals("."))
                continue;
            else if(p.equals(".."))
            {
                if(!st.isEmpty())
                    st.pollFirst();
            }
            else
                st.addFirst(p);
        }
        if(st.size()==0)
            return"/";
        while(!st.isEmpty())
            sb.append("/").append(st.pollLast());
            return sb.toString();
    }
}