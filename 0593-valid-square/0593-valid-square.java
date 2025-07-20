class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
     //adding distances between sides in Hash Set.. 
     //In square only side length and diagonal length are different so HashSet size must be 2
     //Adding elements into HashSet as array list
        HashSet<Integer> hs=new HashSet<>(Arrays.asList(dis(p1,p2),dis(p1,p3),dis(p1,p4),dis(p2,p3),dis(p2,p4),dis(p3,p4)));
        return !hs.contains(0)&&hs.size()==2; //distance should not be 0
    } 
    int dis(int[] a,int[] b){
        return (int)(Math.pow(a[0]-b[0],2)) + (int)(Math.pow(a[1]-b[1],2));
    }
}