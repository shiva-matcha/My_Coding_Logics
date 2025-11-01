/* 438. Find All Anagrams in a String
Medium
Topic :- Sliding Window
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab". */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_All_Anagrams_in_String {
    public List<Integer> findAnagrams(String s, String p) {
        List result= new ArrayList<>();
        int[] pCount= new int[26];
        int[] sCount= new int[26];
        for(char c : p.toCharArray()){
            pCount[c-'a']++;
        }
        int left=0, right=0;
        int windowLen= p.length();
        while(right< s.length()){
            for(int i=0; i<windowLen; i++){
                sCount[s.charAt(i)- 'a']++;
                right++;
            }
            if(right - left > windowLen){
                char lef= s.charAt(left);
                sCount[lef - 'a']--;
                left++;

                char righ= s.charAt(right-1);
                sCount[righ - 'a']++;
                right++;
            }
            if(Arrays.equals(sCount, pCount)){
                result.add(left);
            }
        }
        return result;
    }
}
