class Solution {
    public int minEatingSpeed(int[] piles, int h) {

         
         int sum = Arrays.stream(piles).max().getAsInt();
         int minR = sum;

         int l = 1, r = sum;

         while(l<r){
            int mid = (l+r)/2;

            if(possible(piles, mid, h)){
                r = mid ;
                minR = mid;
            }else{
                l = mid + 1;
            }
         }
      return minR;
    }

    public static boolean possible(int[] piles, int rate, int h){
        
        int hours = 0;
        for(int i : piles){
            
            int x = i/rate;
            int y = i%rate;
            System.out.println(x);

            hours = hours +  ( x!=0?x:1);
            if(x != 0){
            hours += (y==0?0:1); 
            }
            System.out.println("h="+hours);
        }
        System.out.println(rate+" "+hours);
        return hours <= h;
    }
}
