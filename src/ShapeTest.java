import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
	/**
	 * Tests for the square class.
	 */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
	 * Tests for the rectangle class.
	 */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec=new Rectangle("Rectangle1",1.0,2.0);
		Assert.assertEquals("Rectangle area incorrect.", 2.0000, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 6.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Recangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Rectangle ID incorrect.", "Rectangle1", rec.getId());

	}

	/**
	 * Tests for the EquilateralTriangle class.
	 */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		Shape et=new EquilateralTriangle("EquilateralTriangle1",4.0);
		Assert.assertEquals("EquilateralTriangle area incorrect.", 6.9282, et.getArea(), 0.0001);
		Assert.assertEquals("EquilateralTriangle perimeter incorrect.", 12.0, et.getPerimeter(), 0.0001);
		Assert.assertEquals("EquilateralTriangle type incorrect.", "Equilateral Triangle", et.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "EquilateralTriangle1", et.getId());

	}

	/**
	 * Tests for the trapezoid class. Also test that IDs are done correctly.
	 */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		Shape tp = new Trapezoid("Trapezoid1", 20.0,15.0, 30.0, 55.0);
		Assert.assertEquals("Trapezoid area incorrect.", 510.0, tp.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 120.0000, tp.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", tp.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", tp.getId());


	}

	/**
	 * Tests for the ellipse class. Also test that IDs are done correctly.
	 */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
		Ellipse circs1 = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Minor Axis incorrect", 3.0,circs1.getMinorAxis());
	}

	/**
	 * Tests for the circle class. Also test that IDs are done correctly.
	 */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		Shape ci=new Circle("Circle1",2.0);
		Assert.assertEquals("Circle area incorrect.", 2.0*2.0*Math.PI, ci.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2.0*2.0*Math.PI, ci.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", ci.getShapeType());
		Assert.assertEquals("Circle ID incorrect.", "Circle1", ci.getId());


	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape sqr=new Square("S1",2.0);
		Assert.assertEquals("Square\t ID = S1\t area = 4.000\t perimeter = 8.000",sqr.toString());

	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
	 * Tests for the Shape Area Comparator class.
	 */
	@Test
	public void CompareAreaTest()
	{
		// Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
		Shape rect2 = new Rectangle("R2", 1.0, 9.0);
		Shape sqr2 = new Square("S2", 5.0);
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

		// Test unequal perimeter and area:
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
	 * Tests for the Shape Perimter Comparator class.
	 */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
		Shape rect=new Rectangle("R2",8.0,2.0);
		Shape sqr=new Square("S2", 5.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

		//Test equal area, different perimeter
		Shape rect2 = new Rectangle("R2", 8.0, 2.0);
		Shape sqr2 = new Square("S2", 4.0);
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

		//Test unequal perimeter and unequal area
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect, sqr2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}




	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
	public void NaturalCompareTest()
	{
		// TODO: complete this...
		Shape rect=new Rectangle("R1",1.0,2.0);
		Shape sqr=new Square("S1",2.0);
		//Test for unequal area
		Assert.assertEquals(-1, rect.compareTo(sqr));
		Assert.assertEquals(1, sqr.compareTo(rect));

		//test for equal area, different perimeter

		Shape rect1=new Rectangle("R2",2.0,8.0);
		Shape sqr1=new Square("S2",4.0);
		Assert.assertEquals(1, rect1.compareTo(sqr1));
		Assert.assertEquals(-1, sqr1.compareTo(rect1));

		Shape rect3=new Rectangle("R3",4.0,4.0);
		Shape sqr3=new Square("S3",4.0);

		Assert.assertEquals(0, rect3.compareTo(sqr3));
		Assert.assertEquals(0, sqr3.compareTo(rect3));



	}
}
