class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
      List<String[]> set = new ArrayList<>();
        for(String s : strs){

        String sorted = sort(s);
        set.add(new String[]{sorted, s});
      }

      Collections.sort(set,
      
        (a,b)-> {return a[0].compareTo(b[0]);}
      );

    

    System.out.println(set);

    List<List<String>> ans = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    
      String prev = null;
      for(String[] ele : set){

            if(ele[0].equals(prev)){
               curr.add(ele[1]); 
            }else{
                if(!curr.isEmpty())ans.add(curr);

                curr = new ArrayList<>();
                curr.add(ele[1]);
            }
            prev = ele[0];
      }
      ans.add(curr);
      return ans;

    }
    public String sort(String s){
        char[] chars = s.toCharArray();
Arrays.sort(chars);
return new String(chars);

    }
}
