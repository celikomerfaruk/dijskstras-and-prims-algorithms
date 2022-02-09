
public class City {
	private int id;
	private int distance;
	
	public City(int id, int distance) {
		if (id == 0) {
			this.distance = 0;
			this.id = id;
			
		}else {
		this.distance = distance;
		this.id = id;
		}
	}
	
	public boolean equals(City city) {
	     
	     if(this.id == city.getId()) {
	    	 return true;
	     }
	     return false;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
