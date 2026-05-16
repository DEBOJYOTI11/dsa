/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        

        intervals.sort((a,b)-> a.start- b.start);

        PriorityQueue<Integer> pq 
            = new PriorityQueue<>((a,b)->  a - b );

        for(Interval interval : intervals){
            
            if(pq.isEmpty()){ pq.offer(interval.end); continue; }

            int i = pq.peek();
            if (interval.start < i ){
                pq.offer(interval.end);
            }else{
                pq.poll();
                pq.offer(interval.end);
            }

        }
        return pq.size();

    }
}
