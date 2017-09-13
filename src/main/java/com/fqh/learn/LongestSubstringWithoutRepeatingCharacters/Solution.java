package com.fqh.learn.LongestSubstringWithoutRepeatingCharacters;

/**
 * 思路
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 **/
public class Solution {

    /**
     * 求字符串里最长无重复字串长度
     * 用len保存当前最长的子串。如果某两个重复字符之间的子串长于len,则给len赋值这个新的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //测试用例的字符从空格到大写字母Z，所以128足够了
        int[] last = new int[128];
        int start = 0;
        int len = 0;
        char[] w = s.toCharArray();
        for (int i = 0; i < 128; i++)
            last[i] = -1;//last数组用于保存新出现的字符的下标，一开始全部初始化为-1
        for (int i = 0; i < s.length(); ++i) {
            if (last[w[i] - ' '] >= start) { //当前这个字符出现过
                if (i - start > len)
                    len = i - start;
                start = last[w[i] - ' '] + 1; //从这个字符首次出现的位置+1，重新扫描，相当于把前面抛开前面的字符串不谈
            }
            last[w[i] - ' '] = i;//更新当前字符的下标
        }
        if (len > s.length() - start)//针对没有重复字符的字符串
            return len;
        else
            return s.length() - start;
    }

    /**
    * 测试
    **/
    public static void main(String[] argus) {
        String s = "pwwkew";
        int l = new Solution().lengthOfLongestSubstring(s);
        System.out.println(l);
    }
}
