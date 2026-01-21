/*

Problem link - https://www.hackerrank.com/challenges/queens-attack-2/problem

Queens Attack 2


*/



//Solution 1
class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int totalMoves = 0;
        
        int[][] movements = {
            {-1, 0}, //up
            {1, 0}, //down
            {0, 1}, //right
            {0, -1}, //left
            {-1, -1}, //left-up
            {-1, 1}, // right-up
            {1, -1}, //left-dowen
            {1, 1} //right-down
        };
        
        HashSet<String> obsSet = new HashSet<>();
        for(List<Integer> obstackle : obstacles)
            obsSet.add(obstackle.get(0) + "," + obstackle.get(1));
            
        for(int[] move: movements)
            totalMoves += calculateMoves(n, r_q, c_q, obsSet, move[0], move[1]);
            
        return totalMoves; 
    }
    
    private static int calculateMoves(int n, int r_q, int c_q, HashSet<String> obsSet, int rmove, int cmove)
    {
        int moves = 0;
        int rCurr = r_q + rmove;
        int cCurr = c_q + cmove;
        
        while(rCurr>=1 && rCurr<=n && cCurr >= 1 && cCurr <= n) {
            if(obsSet.contains(rCurr + "," + cCurr))
                break;
                
            moves++;
            rCurr += rmove;
            cCurr += cmove;
        }
        
        return moves;
    }

}

//Solution 2
class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int up = n - r_q;
        int down = r_q - 1;
        int left = c_q - 1;
        int right = n - c_q;
        
        int upLeft = Math.min(up, left);
        int downLeft = Math.min(down, left);
        int upRight = Math.min(up, right);
        int downRight = Math.min(down, right);
        
        for(List<Integer> obs: obstacles) {
            int r_0 = obs.get(0);
            int c_0 = obs.get(1);
            
            if(c_0 == c_q) {
                if(r_0 > r_q) up = Math.min(up, r_0 - r_q - 1);
                else down = Math.min(down, r_q - r_0 - 1); 
            }
            else if(r_0 == r_q) {
                if(c_0 > c_q) right = Math.min(right, c_0 - c_q - 1);
                else left = Math.min(left, c_q - c_0 - 1);
            }
            else if(Math.abs(r_0 - r_q)==Math.abs(c_0 - c_q)) {
                if(r_0 > r_q && c_0 < c_q) upLeft = Math.min(upLeft, r_0 - r_q - 1);
                else if(r_0 < r_q && c_0 < c_q) downLeft = Math.min(downLeft, r_q - r_0 - 1);
                else if(r_0 > r_q && c_0 > c_q) upRight = Math.min(upRight, r_0 - r_q - 1);
                else downRight = Math.min(downRight, r_q - r_0 - 1);
            }
    
        }
        
        return up + down + left + right + upLeft + downLeft + upRight + downRight;   
    }
}