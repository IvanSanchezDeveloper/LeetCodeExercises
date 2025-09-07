class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phoneMap = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        letterCombinationsHelper(result, phoneMap, digits, 0, "");
        return result;
    }

    private void letterCombinationsHelper(List<String> result, String[] phoneMap, String digits, int digitIndex, String currentString) {
        if (digitIndex == digits.length()) {
            result.add(currentString);
            return;
        }

        String letters = phoneMap[digits.charAt(digitIndex) - '0'];
        for (char c : letters.toCharArray()) {
            letterCombinationsHelper(result, phoneMap, digits, digitIndex + 1, currentString + c);
        }
    }
}