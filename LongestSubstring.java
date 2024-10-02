/*
 * Copyright (c) 2024.
 * created by Kokouvi Gbenou
 *
 */


/*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/

import java.util.HashMap;
import java.util.Map;



public class LongestSubstring {


    // Main method to test the solutions
    public static void main(String[] args) {

        String s = "abcdefghijklabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&()_+{}[]:;'<>,./?mnopqrstuvwxyz" + "abc".repeat(10000);

        // ######### benchmarking solution 1 ###########
        System.out.println("Benchmarking solution 1");
        long startTime = System.nanoTime(); // Start timing
        long result = solution1(s);
        long endTime = System.nanoTime();// End timing

        System.out.println(" Solution 1- Length of longest substring: "  + result);
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        System.out.println();

        // ######### benchmarking solution 2 ###########
        System.out.println("Benchmarking solution 2");
        long startTime2 = System.nanoTime(); // Start timing
        long result2 = solution2(s);
        long endTime2 = System.nanoTime();// End timing

        System.out.println(" Solution 2- Length of longest substring : " + result2);
        System.out.println("Execution time: " + (endTime2 - startTime2) + " nanoseconds");
        System.out.println();
    }


    /*

         - The first solution by using a for loop to iterate through the string and a hash map to store the indices of the characters.
         - It uses a for loop to iterate through the string and checks if the current character is already in the map.
         - If it is, it updates the left pointer to the next index after the last occurrence of the character.
         - If it is not, it adds the character to the map with its index as the value and updates the maxLength if necessary.
         - After the loop, it returns the maxLength as the length of the longest substring without repeating characters.


         Time Complexity:
            Outer loop (for loop with the right pointer): This loop iterates over every character of the string s, so it runs n times, where n is the length of the string.
            Hash map operations (containsKey, get, put): All these operations (inserting and checking values in a HashMap) are O(1) on average.
            Thus, the overall time complexity is O(n), where n is the length of the input string.

         Space Complexity:
            The map stores each unique character and its index. In the worst case, all characters are unique, so the space required by the map is proportional to the number of characters in the string, i.e., O(n).
            Other variables (left, right, maxLength) use constant space, i.e., O(1).
            So, the overall space complexity is O(n).
     */

    public static int solution1(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(currentChar, right);

        }
        return maxLength;

    }


    /*

         - The second solution by using a for loop to iterate through the string and indexOf() method to find the index of the current character between the left and right pointers.
         - It uses a for loop to iterate through the string and checks if the index of the current character is not equal to the right index.
         - If it is, it updates the left pointer to the index of the current character plus 1.
         - After the loop, it returns the maxLength as the length of the longest substring without repeating characters.

         Time Complexity:
            Outer loop (for loop with the right pointer): This loop iterates n times, where n is the length of the string.
            indexOf method: For each character at position right, the indexOf method is called. In the worst case, it scans the substring from left to right, which can take O(n) time in each call.
            This results in a nested loop structure, leading to a quadratic time complexity.
            Thus, the overall time complexity becomes O(n^2) in the worst case because each call to indexOf can take up to n steps, and we make such calls n times.

         Space Complexity:
            This method only uses a few variables (left, right, maxLength), all of which use constant space, i.e., O(1).
            Thus, the overall space complexity is O(1).
     */

    public static int solution2(String s) {
        int maxLength = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            int indexOfCurrentChar = s.indexOf(s.charAt(right), left);
            if(indexOfCurrentChar != right) {
                left = indexOfCurrentChar + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;

    }

}
