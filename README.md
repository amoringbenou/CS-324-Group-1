# LeetCode Interview Questions - Group 1

This file contains the explanation of solutions to LeetCode problems. The solutions are implemented in Java.

**Longest Substring Without Repeating Characters**

Our approach is to iteratively find the longest substring without repeating characters by maintaining a sliding window approach. We use two pointers (left and right) to represent the boundaries of the current substring. As we iterate through the string, we update the pointers and adjust the window to accommodate new unique characters and eliminate repeating characters.
 
**Length of Longest Substring**

Solutions:

1. **Using a for loop to iterate through the string and a hash map to store the indices of the characters.**

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

2. **Using a for loop to iterate through the string and indexOf() method to find the index of the current character between the left and right pointers.**

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
        So, the overall space complexity is O(1).


We have implemented both solutions and compared their time and space complexities.

**Comparison of the both solutions**

| Solution | Time Complexity | Space Complexity |
|----------|-----------------|------------------|
| Solution 1 | O(n) | O(n) |
| Solution 2 | O(n^2) | O(1) |

- The Solution 1 is more efficient in terms of time complexity because it performs all operations in linear time, while the second method can take quadratic time in the worst case.
- The Solution 2 uses less memory since it only uses a few constant-space variables, whereas the first method requires extra space proportional to the size of the string due to the HashMap.

As we can see, Solution 1 is more efficient than Solution 2 in terms of time complexity, but Solution 2 is more efficient in terms of space complexity.


**Conclusion**

- Solution 1 is generally better because it has a linear time complexity, which is much faster than the quadratic time complexity of the Solution 2. Although the Solution 1 uses more space (O(n)), modern computers typically have enough memory to handle this trade-off efficiently, especially since it ensures faster execution.
- Solution 2 may have lower space usage, but its quadratic time complexity makes it impractical for large strings.

Based on the time and space complexities, we recommend using Solution 1 for the problem because the Solution 1 (with the hash map) is preferred for most real-world applications where time efficiency is more critical than a slight increase in space usage.