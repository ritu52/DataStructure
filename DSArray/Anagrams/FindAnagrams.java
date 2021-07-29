package DSArray.Anagrams;

public class FindAnagrams {
    /**
     * Console output of below program:::
         * Is 'sel' and 'lem' are anagrams?::: false
         * Is 'restful' and 'fluster' are anagrams?::: true
         * Is 'test' and 'tests' are anagrams?::: false
     * @param args: not in use
     */
    public static void main(String[] args) {

        System.out.println("Is "+ "'sel'" + " and "+ "'lem'" +" are anagrams?::: "+ findAnagrams("sel", "lem"));
        System.out.println("Is "+ "'restful'" + " and "+ "'fluster'" +" are anagrams?::: "+findAnagrams("restful", "fluster"));
        System.out.println("Is "+ "'test'" + " and "+ "'tests'" +" are anagrams?::: "+findAnagrams("test", "tests"));

    }

    /**
     * A program to check if two strings are anagram or not
     * @param s1: 1st string
     * @param s2: 2nd string
     * @return true: if both input strings have same character
     *          false: if length is not same or characters are not same
     */
    public static boolean findAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] firstArray = s1.toLowerCase().toCharArray();
        char[] secondArray = s2.toLowerCase().toCharArray();
        int[] alphabetsCounterArray = new int[26];
        //O(N)
        for (int i=0; i<firstArray.length; i++){
            alphabetsCounterArray[firstArray[i]-97]++;
            alphabetsCounterArray[secondArray[i]-97]--;
        }

        for(int c : alphabetsCounterArray){
            if(c !=0) return false;
        }
        return true;
    }
}
