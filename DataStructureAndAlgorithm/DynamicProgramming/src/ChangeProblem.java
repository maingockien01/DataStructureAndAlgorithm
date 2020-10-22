
/**
 * @problem
 *
 * @input       K  - values of changes (money term)
 *              N  - a money value 
 *
 * @output      C(N) - the number of ways to make change of N by K given units.
 */

/**
 * @algorithm:
 *
 * @approach    from C(N) we have K ways to make change of N down to smaller values.
 *              take Ki as a unit, the number of ways is 1 * C(N-ki).
 *              Then we apply recursive to find C(N-Ki).
 *              
 * @optimize    This is recursion, I will try dynamic programming
 *              Since C(N-Ki) may be repeated few times, it should be stored so no need to recalculate.
 *              Second, if K is not small and N is not small, recursive without dynamic programming would 
 *                  need a lot of time.
 *              So we decide to apply dynamic programming. Should I apply top-down (N -> 1) or bottom-up (1 -> N).
 *              Top-down is not a bad idea since we dont know about K units, there can be some value we cant make change by given units.
 *                  So it will be wastful of calculation if the program doesnt use all calculations. 
 *                  However, if the K unit includes unit 1 cents. To calculate C(N) we will cover all state space from N-1 -> 1
 *                  In this case, bottom-up and top-down seems same same to each other.
 *              Bottom-up: this way eliminates recursion... nice Im never a friend of recursion :)) 
 *                  As what I said about the case of 1 cents above, bottom-up seems a good idea even better because there is not need for
 *                      recursion here.
 *                  By chosing bottom-up approach, you can build up all the state space first before tracing for the problems,
 *                      which is easier to implement and debug. It is a bit bug-prone when you trace down along the possibility and building state space together.
 *                      Of course, if you are very confident in your coding skills, both of them are same.
 *                      However, personally, it is safe to go with bottom up. 
 */

/**
 * @psuedocode
 *
 * initTable():
 *  create a table 1 x N+1
 *  set table[0][0] = 1;
 *
 * buildTable ():
 *  for i = 1 -> N:
 *   for j = 0 -> K:
 *      ways = 0;
 *      if( Kj <= i):
 *          ways += tablle[0][N-Kj];
 *      
 *          
 *  traceBack ():
 *   the output is table[0][N]
 *
 */

/**
 * @notes   with this algorithm we can edit for different output
 *          such as the way has th e least of change,
 *                  find the ways for more than 1 numbers
 */
