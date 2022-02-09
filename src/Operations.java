import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.util.PriorityQueue;

public class Operations {

	
	
	
	public ArrayList<Integer> dijkstrasAlgo(Graph graph) {
		
		//initialize related data structures
		boolean[] haveVisited = new boolean[graph.getNumOfVertices()] ;
		int parent[] = new int[graph.getNumOfVertices()];
		int[] distance = new int[graph.getNumOfVertices()];
		ArrayList<Integer>  path = new ArrayList<>();
		
		PriorityQueue<City> cities = new PriorityQueue<City>(new CityComparator());
		
		HashMap< Integer, City> citiesCopies = new HashMap<>();
		
		int timeElapsed;
		
		

		
		
		
		for(int i = 0 ;i<graph.getNumOfVertices();i++) {
			City tempCity = new City(i, Integer.MAX_VALUE);
			cities.add(tempCity) ;
			citiesCopies.put(i, tempCity);
			
			haveVisited[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		parent[0] = -10;
		
		
		
		for (int i= 0 ;i<(graph.getNumOfVertices()-1);i++) {
			City nearestCityX;
			int nearestCity = 0;
			int min = Integer.MAX_VALUE;
			
			
			
			//finding min
			if (cities.peek().getDistance()<min ) {
				nearestCityX = cities.poll();
				nearestCity = nearestCityX.getId();
				haveVisited[nearestCity] = true;
				
				for (Integer k : graph.adjacencyMap.get(nearestCity).keySet())  {
						// relaxation
						if(!haveVisited[k]  && (distance[nearestCity]+graph.adjacencyMap.get(nearestCity).get(k))<distance[k]) {
							distance[k] = distance[nearestCity]+graph.adjacencyMap.get(nearestCity).get(k);
							parent[k] = nearestCity;
							City tempCity = citiesCopies.get(k);
							
							
							cities.remove(tempCity);
							City newCity = new City(k, distance[k]);
							cities.add(newCity);
							citiesCopies.remove(k);
							citiesCopies.put(k, newCity);
						} 			
					}   
			}
		}
		
		//generate output
		int tempNode = graph.getNumOfVertices()-1;
		
		timeElapsed = distance[tempNode];
		if (timeElapsed == Integer.MAX_VALUE) {
			return path;
		}
		
		
		while(true) {
			path.add(tempNode);
			tempNode = parent[tempNode];
			if (tempNode == -10) {
				break;
			}
		}
		path.add(timeElapsed);
		return path;
		}
	
	public int primsAlgo(Graph graph) {
		
		if (!graph.adjacencyMap.containsKey(0)) {
			return -5;
		}
		
		int cost =0 ;
		//initialize related data structures
		
		int[] distance = new int[graph.getNumOfVertices()];
		boolean[] haveVisited = new boolean[graph.getNumOfVertices()] ;
		PriorityQueue<City> cities = new PriorityQueue<City>(new CityComparator());
		HashMap< Integer, City> citiesCopies = new HashMap<>();
		
		for(int i = 0 ;i<graph.getNumOfVertices();i++) {
			City tempCity = new City(i, Integer.MAX_VALUE);
			cities.add(tempCity) ;
			citiesCopies.put(i, tempCity);
			
			
			haveVisited[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[0] = 0;
		
		for (int i= 0 ;i<(graph.getNumOfVertices()-1);i++) {
			
			int bestVertice = 0;
			int min = Integer.MAX_VALUE;
			City nearestCityX;
			

			//find min
			if (cities.peek().getDistance()<min ) {
				nearestCityX = cities.poll();
				bestVertice = nearestCityX.getId();
				haveVisited[bestVertice] = true;
				for (Integer k : graph.adjacencyMap.get(bestVertice).keySet())  {
					// relaxation
					if(!haveVisited[k]  && (graph.adjacencyMap.get(bestVertice).get(k))<distance[k]) {
						distance[k] = graph.adjacencyMap.get(bestVertice).get(k);
						
						City tempCity = citiesCopies.get(k);
						
						
						cities.remove(tempCity);
						City newCity = new City(k, distance[k]);
						cities.add(newCity);
						citiesCopies.remove(k);
						citiesCopies.put(k, newCity);
						
					} 
				
				
			}
				
		
			}
		}
			
		//generate output
		for(int i = 0 ; i<graph.getNumOfVertices() ; i++) {
			cost += distance[i];
		if (distance[i]==Integer.MAX_VALUE) {
			return -5;
		}
		
		}
		return cost;
	}
	
	
	
	class CityComparator implements Comparator<City>{
		public int compare(City c1 , City c2) {
			
			return c1.getDistance() - c2.getDistance();
		}
	}
	
	
}
