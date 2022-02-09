
import java.util.HashMap;

public class Graph {
	
	private int numOfVertices;

	HashMap<Integer, HashMap<Integer, Integer>> adjacencyMap;
	
	public Graph(int numOfVerices) {
		this.numOfVertices = numOfVerices;
		
		
		 adjacencyMap = new HashMap<Integer, HashMap<Integer, Integer>>();
		 

		
		
	}
	
	//declaring cities with no way out
	public void addNoExit(int c) {
		if (adjacencyMap.get(c) == null) {
			adjacencyMap.put(c, new HashMap<>());
		}
		
	}
	
	public void addRoad(int c1, int c2, int weight) {
		if (adjacencyMap.get(c1) == null) {
			adjacencyMap.put(c1, new HashMap<>());
			
		}
		
			adjacencyMap.get(c1).put(c2, weight);
		
		
		
	}
	public void addUndirectedRoad(int c1, int c2, int weight) {
		
	
		
		
		
		if (adjacencyMap.get(c1) == null) {
			adjacencyMap.put(c1, new HashMap<>());
			
		}
		
		if (adjacencyMap.get(c2) == null) {
			adjacencyMap.put(c2, new HashMap<>());
			
		}
		
		
		
		if (adjacencyMap.get(c1).get(c2) != null  ) {
			if (adjacencyMap.get(c1).get(c2) > weight) {
				adjacencyMap.get(c1).put(c2,weight);
			}
		}else {
			adjacencyMap.get(c1).put(c2,weight);
		}
		
		if (adjacencyMap.get(c2).get(c1) != null  ) {
			if (adjacencyMap.get(c2).get(c1) > weight) {
				adjacencyMap.get(c2).put(c1,weight);
			}
		}else {
			adjacencyMap.get(c2).put(c1,weight);
		}
		
			
			
		
		
		
		
		
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}
	
}
