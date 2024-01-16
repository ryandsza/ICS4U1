package getCylinder;

public class Cylinder {
	private double radius;
	private double height;
	
	public Cylinder() {
		this(0,0);
	}
	
	public Cylinder(double radius, double height) {
		setHeight(height);
		setRadius(radius);
	}
	
	public void setRadius(double radius){
		if (radius < 0)
			throw new IllegalArgumentException("Invalid Radius specified!");
		this.radius = radius;
	}
	
	public void setHeight(double height){
		if (height < 0)
			throw new IllegalArgumentException("Invalid Height specified!");
		this.height = height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
