package org.evan.jacques.trckr.model;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Marker {

	private String address;
	private int id;
	private int size;
	private String contents;
	private String dropoff;
	private int pickup;
	private double lat;
	private double lon;
	
	public Marker (){
		
	}
	
	public Marker (String address, int id, int size,  String contents, String dropoff, int pickup, double lat,double lon){
		this.address = address;
		this.id = id;
		this.size = size;
		this.contents = contents;
		this.dropoff = dropoff;
		this.pickup = pickup;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress( String address ){
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDropoff() {
		return dropoff;
	}

	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}

	public int getPickup() {
		return pickup;
	}

	public void setPickup(int pickup) {
		this.pickup = pickup;
	}
	
}
