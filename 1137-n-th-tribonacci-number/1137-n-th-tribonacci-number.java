class Solution {
    public int tribonacci(int n) {
	if (n < 2)
		return n;
	if (n == 2)
		return 1;

	var d = 0;
	for (int a = 0, b = 1, c = 1; n > 2; n--) {
		d = a + b + c;
		a = b;
		b = c;
		c = d;
	}
	return d;
}
}