package org.evan.jacques.trckr.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.evan.jacques.trckr.model.Marker;
import org.evan.jacques.trckr.service.MarkerService;

@Path("markers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarkerResource {
	
	MarkerService markerService = new MarkerService();
	
	@GET
	public List<Marker> getMarkers(@HeaderParam("token") String token)
	{
		String table = markerService.connectToken(token);
		return markerService.getAllMarkers(table);
	}
	@GET
	@Path("/{messageId}")
	public List<Marker> getMarkersToPickup(@PathParam("messageId") int id,@HeaderParam("token") String token)
	{
		String table = markerService.connectToken(token);
		return markerService.getMarkersToPickup(table);
	}
	
	@POST
	public Marker addMarker(Marker marker,@HeaderParam("token") String token)
	{
		String table = markerService.connectToken(token);
		return markerService.addMarker(marker,table);
	}
	
	@PUT
	@Path("/{markerId}")
	public Marker updateMarker(@PathParam("markerId") int id,Marker marker,@HeaderParam("token") String token)
	{
		String table = markerService.connectToken(token);
		return markerService.updateMarker(id,marker,table);
	}

	@DELETE
	@Path("/{markerId}")
	public void removeMarker(@PathParam("markerId") int id,@HeaderParam("token") String token)
	{
		String table = markerService.connectToken(token);
		markerService.deleteMarker(id,table);
	}
	
}
