import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 2);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(c);
		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);

		//test for same area, different perimeter
		ShapeSorter sorter1 = new ShapeSorter();
		Shape f=new Rectangle("rec",2,8);
		Shape g =new Square("sqr",4);

		sorter1.addShape(g);
		sorter1.addShape(f);
		Assert.assertEquals("Shapes added incorrectly...", sorter1.shapes.get(0), g);
		Assert.assertEquals("Shapes added incorrectly...", sorter1.shapes.get(1), f);

	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 2);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(c);
		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 3);
		Shape c = new Square("test3", 2);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(d);
		sorter.addShape(c);
		sorter.addShape(b);
		sorter.addShape(a);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);

	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
		Shape a = new Rectangle("R1", 3, 3);
		Shape b = new EquilateralTriangle("T1", 4);
		Shape c = new Square("S1", 2);
		Shape d = new Circle("C1", 1.5);
		sorter.addShape(d);
		sorter.addShape(c);
		sorter.addShape(b);
		sorter.addShape(a);
		double circleArea=Math.PI*1.5*1.5;
		String expected="Circle\t ID = C1\t area = 7.069\t perimeter = 9.425"+
				"Square\t ID = S1\t area = 4.000\t perimeter = 8.000"+
				"Equilateral Triangle\t ID = T1\t area = 6.928\t perimeter = 12.000"+
				"Rectangle\t ID = R1\t area = 9.000\t perimeter = 12.000";
		Assert.assertEquals(expected, sorter.toString() );


	}
}
