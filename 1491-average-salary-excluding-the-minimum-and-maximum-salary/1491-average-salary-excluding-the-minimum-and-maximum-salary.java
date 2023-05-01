class Solution {
    public double average(int[] salary) {
        int sum = 0;
        for(int i : salary)
            sum += i;
        int min = salary[0], max = salary[0];
        for(int i : salary){
            if(i>max)
                max=i;
            if(i<min)
                min=i;
        }
        sum = sum - min - max;
        return (double) sum/(salary.length-2);    
    }
}