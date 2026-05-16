class Solution {
    public String foreignDictionary(String[] words) {

        HashMap<Character, Set<Character> > dependency = new HashMap<>();


        int l = words.length;

        if(l < 2){
            return words[0];
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                dependency.putIfAbsent(c, new HashSet<>());
            }
        }

        String first = words[0];
        for(int i=1;i<l;i++){
            String second = words[i];
            if(first.length() > second.length() && first.startsWith(second)){
                return "";
            }
            buildDependency(dependency, first, second);
            first = second;
        }


        List<Character> order = new ArrayList<>();
        int[] state = new int[256];

        for(Character c : dependency.keySet()){

            if(state[c] == 0 && cycle( c, dependency, state, order )){
                return "";
            }
        }
        Collections.reverse(order);
        return order.stream()
                     .map(String::valueOf)
                     .collect(java.util.stream.Collectors.joining());

    }


    public boolean cycle(Character c, HashMap<Character, Set<Character> > dependency , int[] state, List<Character> order){

        if(state[c] == 1 ) return true;

        if( state[c] == 2) return false;


        state[c] = 1;

        for(Character cdash : dependency.get(c)){
            boolean hasCycle = cycle(cdash, dependency, state, order);

            if(hasCycle) return true;
        }

        state[c] = 2;
        order.add(c);
        return false;
    }


    public void buildDependency(HashMap<Character, Set<Character> > dependency, String a, String b){

        int i=0;

        while(i<a.length() && i < b.length()){
    
            if (a.charAt(i) != b.charAt(i)){
                dependency.computeIfAbsent(a.charAt(i) , k -> new HashSet<>()).add(b.charAt(i)) ;
                return;
            }
            i++;
        }

    }
}

