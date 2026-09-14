class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int ans = 0;

        char[] ch = s.toCharArray();

        int l = 0, r = 0;

        HashMap<Character, Integer> lookup = new HashMap<>();
        
        while(r< ch.length){

            char c = ch[r];

            if(lookup.containsKey(c)){
                
                while(lookup.containsKey(c)){
                    
                    char cAtL = ch[l];
                
                    lookup.remove(cAtL);
                    l++;
                }

            }
            ans = Math.max(ans,
                        r - l +1
                        );
            lookup.put(c,r);
            r++;
        }
        return ans;

    }
}
