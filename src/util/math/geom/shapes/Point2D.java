package src.util.math.geom.shapes;

import src.util.Util;
import src.util.math.geom.shapes.Vector2D;

/*
 * Simplified version of <code>java.awt.geom.Point2D</code>. We do not want
 * dependencies to presentation layer packages here.
 * 
 */
public class Point2D implements Cloneable {
	
	private double x;
	private double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/*
	 * Returns the Euclidean distance between a specified point and this point.
	 * @param pt the second point.
	 * @return the Euclidean distance between a specified point and this point.
	 */
	public double distance(Point2D pt) {
		// Distance Between X Coordinates
		final double x_distance = (pt.getX() - x) * (pt.getX() - x);
		// Distance Between Y Coordinates
		final double y_distance = (pt.getY()-y)*(pt.getY()-y) ;
		// Distance Between 2d Points
		return Math.sqrt(x_distance + y_distance) ;
	}

	/*
	 * Adds a vector onto a point.<br/>
	 * This moves the point by {@code vector.getX()} in X direction and {@code vector.getY()} in Y direction.
	 * @param op2 the {@link Vector2D} to be added.
	 * @return the moved point.
	 */
	public Point2D add(Vector2D op2) {
		return new Point2D(this.x + op2.getX(), this.y + op2.getY());
	}

	/*
	 * Subtracts a vector from a point.<br/>
	 * This moves the point by {@code vector.getX()} in negative X direction and {@code vector.getY()} in negative Y direction.
	 * @param op2 the {@link Vector2D} to be subtracted.
	 * @return the moved point.
	 */
	public Point2D sub(Vector2D op2) {
		return new Point2D(this.x - op2.getX(), this.y - op2.getY());
	}
	
	/*
	 * Calculates the vector between this point and the target point.
	 * @param target the point that describes the end of the vector.
	 * @return the vector between this point and the target point.
	 */
	public Vector2D vec(Point2D target) {
		return new Vector2D(target.getX() - this.x, target.getY() - this.y);
	}

	/*
	 * Checks a point for equality with this point.
	 * @param op2 the second point.
	 * @return {@code true} if the points have the same coordinates.
	 */
	public boolean equals(Point2D op2) {
		if(op2 == null) return false;
		return Util.compareDoubles(this.x,op2.x) && Util.compareDoubles(this.y,op2.y);
	}
	
	@Override
	 public boolean equals(Object o) {
		 if(o instanceof Point2D)
			 return this.equals((Point2D) o);
		 return false;
	 }
	
	@Override
	public Point2D clone() {
		return new Point2D(this.x,this.y);
	}
}


