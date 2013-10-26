public class Palindrome {
	public static void main (String[] args)
	{
		System.out.println("is gaga a palindrome? " + isPalindrome("gaga"));
		System.out.printf("is gaag a palindrome? %b\n", isPalindrome("gaag"));

	}
	
	public static boolean isPalindrome(String word) {
		char [] letters = word.toCharArray();
		int wordLength = letters.length;
		for (int i = 0; i < letters.length / 2; i++)
		{
			if (letters[i] != letters[wordLength-i-1])
				return false;
		}
		return true;
	}


}

