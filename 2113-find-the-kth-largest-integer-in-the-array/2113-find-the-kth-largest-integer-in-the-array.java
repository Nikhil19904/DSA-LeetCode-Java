class Solution {
    public String kthLargestNumber(String[] nums, int k) {
//Making the priority queue using custom comparator(*Discussed below*)
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->a.length()==b.length()?
            a.compareTo(b): a.length()-b.length());
        for(String n: nums){
            pq.add(n);
//Deleting the kth largest everytime, so that pq contains only the largest k elements
            if(pq.size()>k) pq.poll();
        }
//Returning the minimum element in pq
        return pq.poll();
    }
}