package src.environment.map;

import java.util.List;

import src.util.math.geom.shapes.Point2D;

public interface Map {

	public List<String> getLocations();

	public List<String> getPossibleNextLocations(String location);

	public List<String> getPossiblePrevLocations(String location);

	public Double getDistance(String fromLocation, String toLocation);

	public Point2D getPosition(String loc);

	public String randomlyGenerateDestination();
}
