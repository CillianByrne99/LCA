import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class DAGTest {
	DAG emptyGraph = new DAG(0);
    DAG acyclic = new DAG(8);
    DAG cyclic = new DAG(8);
    DAG straightLine = new DAG(8);
    DAG isolatedVerticesGraph = new DAG(8);
    DAG MultipleParents = new DAG(9);
    DAG Disjointed = new DAG(9);

    public void straightLine() {
        straightLine.addEdge(0, 1);
        straightLine.addEdge(1, 2);
        straightLine.addEdge(2, 3);
        straightLine.addEdge(3, 4);
        straightLine.addEdge(4, 5);
        straightLine.addEdge(5, 6);
        straightLine.addEdge(6, 7);
    }

    public void acyclic() {
        acyclic.addEdge(0, 1);
        acyclic.addEdge(0, 2);
        acyclic.addEdge(1, 3);
        acyclic.addEdge(3, 5);
        acyclic.addEdge(2, 4);
        acyclic.addEdge(4, 6);
        acyclic.addEdge(5, 7);
        acyclic.addEdge(6, 7);
    }

    public void cyclic() {
        cyclic.addEdge(0, 1);
        cyclic.addEdge(0, 2);
        cyclic.addEdge(1, 2);
        cyclic.addEdge(2, 4);
        cyclic.addEdge(4, 3);
        cyclic.addEdge(3, 1);
        cyclic.addEdge(3, 5);
        cyclic.addEdge(5, 7);
        cyclic.addEdge(6, 7);
    }
  

    public void disjointGraphs() {
		Disjointed.addEdge(0, 1);
		Disjointed.addEdge(0, 2);
		Disjointed.addEdge(1, 3);

		Disjointed.addEdge(4, 5);

		Disjointed.addEdge(6, 7);
		Disjointed.addEdge(7, 8);
    }
    
    public void isolatedVerticesGraph() {
    	isolatedVerticesGraph.addEdge(0, 1);
    	isolatedVerticesGraph.addEdge(1, 4);
    	isolatedVerticesGraph.addEdge(4, 7);
    	isolatedVerticesGraph.addEdge(4, 8);
    	isolatedVerticesGraph.addEdge(1, 5);
    	isolatedVerticesGraph.addEdge(0, 6);
    	isolatedVerticesGraph.addEdge(6, 2);
    }
    /*
				0
  			/	   \
		   1	     6
		/     \	       \				3
	  4   	   5		 2
	/ 	\	 			   				 
  7       8  				
*/
    public void multipleParentsGraph() {
		MultipleParents.addEdge(0, 1);
		MultipleParents.addEdge(1, 4);
		MultipleParents.addEdge(4, 7);
		MultipleParents.addEdge(4, 8);
		MultipleParents.addEdge(1, 5);
		MultipleParents.addEdge(0, 6);
		MultipleParents.addEdge(6, 2);
		MultipleParents.addEdge(6, 3);
		MultipleParents.addEdge(5, 3);
		MultipleParents.addEdge(8, 3);
		MultipleParents.addEdge(5, 8);
	}		
    
    
   @Test(expected = IllegalArgumentException.class)
   public void testConstructor() {
       DAG constructorTest = new DAG(-1);
   }
   
   @Test
   public void testLCA() {
       straightLine();
       acyclic();
       cyclic();
       multipleParentsGraph();
       isolatedVerticesGraph();
       disjointGraphs();
       assertEquals("Testing for vertex being its own ancestor", 3, straightLine.findLCA(3,3));
       assertEquals("Testing for disjointed graph", 0, Disjointed.findLCA(1, 2));
       assertEquals("Testing for isolatedVerticesGraph", 1, isolatedVerticesGraph.findLCA(3, 2));
       assertEquals("Testing for different levels present in graph", 1, straightLine.findLCA(1,5));
       assertEquals("Testing for different levels present in graph", 1, straightLine.findLCA(2,5));
       assertEquals("Testing for acyclic graph", 1, acyclic.findLCA(5, 2));
       assertEquals("Testing for swap in vertices", 1, straightLine.findLCA(1, 5));
       assertEquals("Testing for swap in vertices", 1, straightLine.findLCA(5, 1));
   }
}