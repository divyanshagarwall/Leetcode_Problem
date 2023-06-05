class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int a[]=new int[51];
        int len=A.length;
        int res[]=new int[len];
        for(int i=1;i<=len;i++)
        {
            a[A[i-1]]++;
            a[B[i-1]]++;
            int count=0;
            for(int j=0;j<=50;j++)
            {
                if(a[j]==2)
                {
                    count++;
                }
            }
            res[i-1]=count;
        }
        return res;
    }
}