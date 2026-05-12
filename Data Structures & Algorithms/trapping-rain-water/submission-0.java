class Solution {
    public int trap(int[] h) {


        int l = 0, r =  h.length-1;

        int lmax=-1,rmax=-1;
        int water=0;
        while(l<r){

            if(h[l] < h[r]){
                
                
                lmax = Math.max(lmax, h[l]);
                if(h[l]>=lmax){
                    lmax = h[l];
                }else{
                      water+=lmax -h[l];
                }

        
                l++;
            }else{
                

                if(h[r] >= rmax){
                    rmax = h[r];
                }else{
                    water+=rmax - h[r];
                }
                r--;
            }

        }
        return water;
    }
}
