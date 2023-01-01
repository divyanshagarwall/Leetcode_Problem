class Solution {
    public boolean wordPattern(String pattern, String s) {
	var words = s.split(" ");
	var n = words.length;
	if (pattern.length() != n)
		return false;
		
	var letterToWord = new HashMap<Character, String>();
	var wordToLetter = new HashMap<String, Character>();

	for (var i = 0; i < n; i++) {
		var letter = pattern.charAt(i);
		var word = words[i];

		if (!letterToWord.computeIfAbsent(letter, k -> word).equals(word) ||
			wordToLetter.computeIfAbsent(word, k -> letter) != letter)
			return false;
	}

	return true;
}
}