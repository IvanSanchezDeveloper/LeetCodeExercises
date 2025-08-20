class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxSubstring = 0;

        Set<Character> usedChars = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while(usedChars.contains(c)) {
                usedChars.remove(s.charAt(left));
                left++;
            }

            usedChars.add(c);

            maxSubstring = Math.max(maxSubstring, right - left + 1);
        }

        return maxSubstring;
    }
}