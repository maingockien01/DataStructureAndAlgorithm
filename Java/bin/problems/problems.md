# Graph problems
*Inspired by The Algorithm Design manual (Steven S. Skiena) - Chapter 5* 

###Traversal
**5-3**

5-7
Given the pre order and in order traversal of a tree. 
Construct the tree.

createNode(Queue<Node> preorder, Node[] inorder, int from, int to):
    mid = preorder.deque
    midIndexInInorder = binarySearch(inorder, mid, from, to);
    
    leftNode = createNode(preorder, inorder, from, midIndex-1);
    rightNode = createNode(preorder, inorder, mid+1, to);

    connect(mid, lelftNode, rightNode);

    return mid;
    


5-9
Given a tree that has internal nodes as arithmetic operatorions and leaf nodes as integer numbers. 
Giving the 0(n) algorithm to to evaluate the expression. 
Solutions:
evaluate(Node top):
    if(node has no child -> leaf node) {
        return nodeValue
    }
    leftValue = evaluate(left)
    rightValue = evaluate(right)
    return merge(leftValue, rightValue, midOperation);

the alorithm has the complexity of O(log n)

5-11
The worst-case linear case for the program is when there is no adjacent triangles in the grpah. The graph is connected but only by verteices, which means 2 triangles have at most common of 1 vertex. That is,everytime the program read a triangle, it would need to read all the lists of 1 vertices (2 other is new vertices) for nothing. 


