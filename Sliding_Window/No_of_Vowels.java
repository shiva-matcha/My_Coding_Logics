/* 1456. Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels. */


public class No_of_Vowels { // Maximum Number of Vowels in a Substring of Given Length

    public int maxVowels(String s, int k) {
        String ch = "aeiou";
        int maxWinLen = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (ch.indexOf(s.charAt(i)) != -1)
                count++;
        }
        maxWinLen= count;
        for (int i = k; i < s.length(); i++) {
            if (ch.indexOf(s.charAt(i - k)) != -1)
                count--;
            if (ch.indexOf(s.charAt(i)) != -1)
                count++;

            maxWinLen = Math.max(count, maxWinLen);
        }
        return maxWinLen;
    }
}
