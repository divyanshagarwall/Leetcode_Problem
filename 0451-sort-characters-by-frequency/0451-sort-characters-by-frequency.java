import java.util.*;
class Solution {
    public String fill(int length,Character c)
    {
        char[] data = new char[length];
        Arrays.fill(data,c);
        return new String(data);
    }
    public String frequencySort(String s) {
        HashMap <Character,Integer> map=new HashMap<>();
    int max=0;
    for(int i=0;i<s.length();i++)
    {
        int k=map.getOrDefault(s.charAt(i),0);
        map.put(s.charAt(i),k+1);
        if(max<map.get(s.charAt(i)))
        {
            max=map.get(s.charAt(i));
        }
    }
    SortedMap<Integer, String> map1
        = new TreeMap<Integer, String>();
    for(Map.Entry <Character,Integer> e : map.entrySet())
    {
        if(map1.containsKey(e.getValue()))
        {
            map1.put(e.getValue(),map1.get(e.getValue())+fill(e.getValue(),e.getKey()));
        }
        else
        {
            map1.put(e.getValue(),fill(e.getValue(),e.getKey()));
        }
    }
    String str="";
    for(Map.Entry <Integer,String> y : map1.entrySet())
    {
        str=y.getValue()+str;
    }
    return str;
    }
}