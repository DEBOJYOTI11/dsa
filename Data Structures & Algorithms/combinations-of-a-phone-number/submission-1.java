class Solution {

    public void track(char[] main, int i, Map<Character, String> num, StringBuilder ans, List<String> finalans){

        if(i>=main.length){
            finalans.add(ans.toString());
            return;
        }
        char ch = main[i];
        for(Character c : num.get(ch).toCharArray()){
            ans.append(c);
            track(main, i+1, num, ans, finalans);
            ans.deleteCharAt(ans.length() - 1);
    
        }
    }
    public List<String> letterCombinations(String digits) {

        List<String>  finalans = new ArrayList<>();
        if(digits == null || digits.length()==0){
            return finalans;
        }
        
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
    
        StringBuilder s = new StringBuilder();
        track(digits.toCharArray(), 0, mp, s,  finalans);
        return finalans;

    }
}
