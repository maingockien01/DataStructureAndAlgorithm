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

5-13
Graph G = (V, E). V' is a subset of V such that every edge in E contains at least one vertex in V'.

a) Give the algorithm that finds the minimum-size V'. 

Observation: leaves should be excluded from the set V'.

Psuedocode: 

depthFirstTraverse (vertex):
    vertex isDiscovered
    processVertexEarly (vertex)

    while incidentEdge != null:
        adjacentEdge = incidentVertex -> y;
        
        depthFirstTraverse (adjacentVertex);

        processEdge(adjacentVertex);
   
processvertexearly (vertex):
    if vertex is leaf:
        ismarked vertex = true
        isincluded vertex = false

processedge (vertex1, vertex2, graph):
   if one of 2 vertex is marked
        marked other vertex regard to marked vertex

    
b) If every vertex has a weight of its degree. Find the V' has the least weight.

Observations:
a leaf has 1 weight 
an internal node with n children has weight/degree of n+1
the root with n children has weight/degree of n

-> always include leaves then follow the process edge function in question a algorithm. 

processVertexEarly (vertex):
    if vertex is a leaf:
        include vertex
    

c) If every vertex has a given abritrary weight. Find the V' has the least weight. 

Observation:
To minimize the sum of weight, for each edge, only one vertex is included. We should include by tree level. 
In some edge, larger weight vertex is included but the sum of all included Vertex.
We will use the alogithm 2-color graph to do

Psuedocode breadFirstTraverse: I would reuse the bread first traverse from my src folder.

processEdge (vertex1, vertex2):
    if vertex is marked:
        vertex2 is colored opposite to vertex1 
    else if vertex2 is marked:
        vertex1 is colored opposite to vertex2

processVertexLate (vertex):
    if vertex is black:
        blackSum += vertex
    else 
        whiteSume += vertex

finally -> pick the vertex set with smaller sum.

            
5-15: 
G = (V, E). A vertex cover V' subset of V s.t every edge E contain at least of vertex from V'.
An independent set V' sub set of V s.t no edge contains both vertices from V'.

An independent vertex cover is V' subset of V such that it is vertex cover and independent set. 
Give the alogirthm to test if a graph has an independent set vertex. 

Observations:
If the graph has cycle -> there is no independent set cover

-> search if the graph has cycle -> use depth first search with parent node array. 

5-17
Given G = (V, E) undirected graph. 
Give the algorithm that find a triangle if one exists. 

a) O(V^3) algorithm 

Depth first search to indentify if the graph has a cycle. 

When find a cycle which means there is a node x -> y that y parent not x. 

ProcessEdge x y that:
    search through adjacentV of x 
        search if adjacentV of x is adjacent to y

b) O(V.E): assume E > V
Use adjacent matrix 

5-19:
The diameter of a tree T = (V, E) is ven by the max distance between 2 nodes

Observations: 
The diameter is the distance between 2 leaves. 
The maximum distance of 2 leaves thorugh a given node = sumOfLargestAndSecondLargest (maxDistanceToLeaf(children)) + 1
Apply dynamic proramming

Psuedocode:
int[] maxValueToLeaf;

calDistanceToLeaf (node):
    if node is a leaf:
        maxDistanceToLeaf[node] = 1
    else
        maxDistanceToLeaf[node] =  1 + max(calDistanceToLeaf(children);

getDiameter (node):
    diameter = max(distanceToLeaf(childrend)) + secondMax(distanceToLeaf(children)) + 1;
    
    return max( diameter, getDiamter(children));


5-23:
Given n children (vertices), m statement that "i hates j". If i hates j, j must not be behind i because i will throw something to j. 
Give the alogithm to order the line.

Observation:
Definitely there is cross Edge and back edge 
There is only one directed edge between 2 vertices. 

BreadthFirstSearch + deck 

Pick one vertex to start -> breathFirstSearch and push processed node into deck 

Starting from un discovered node -> breadthFirstSearch and push processed node into second deck -> queue second deck to the front of first deck 

continue untill no undiscovered node

Algorithm analysis: 
The edge is repeated exactly 1 and the node is repeated exacly 1 -> O(n+m)

