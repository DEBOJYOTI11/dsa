class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> s = new Stack<>();

        for(String token : tokens){

            switch(token){
        
                case "+": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(first + second);
                    break;
                }
                case "*": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(first * second);
                    break;
                }
                case "-": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(second - first);
                    break;
                }
                case "/": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(second / first);
                    break;
                }
                default:
                    s.push(Integer.parseInt(token));
            }
        }
            return s.peek();
    }
}
