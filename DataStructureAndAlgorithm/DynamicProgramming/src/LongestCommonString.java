/**
 * Problem 8-3
 * Description:
 * Input: 2 String X and Y
 * Output: the longest substring that both X and Y contain.
 * Example: photograph motogprahy -> ograph
 *
 * Observation:
 * - We can find all substring common from X and Y but it is N^2 algorithm !!!
 * - We can apply edit distance algorithm to find the best way to change X to Y. In the best way, the out put is the longest pattern that are consecutively MATCH. 
 *
 */


public interface LongestCommonString { 

    String searchLongestCommonString (String x, String y);

}
