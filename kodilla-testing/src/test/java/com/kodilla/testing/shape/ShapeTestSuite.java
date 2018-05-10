package com.kodilla.testing.shape;

import org.junit.*;

//Test suit for classes of shape
public class ShapeTestSuite {

    private static int n = 0;

    @BeforeClass
    public static void beforeTests(){
        System.out.println("Test suit: STARTED");
    }

    @AfterClass
    public static void afterTests(){
        System.out.println("Test suit: FINISHED");
    }

    @Before
    public void before(){
        n++;
        System.out.println("Test #" + n + ": started");
    }

    @After
    public void after(){
        System.out.println("Test #" + n + ": finished");
    }

    @Test
    public void testGetTriangleName(){
        //Given
        Shape shape = new Triangle(1,1,1);
        //When
        String name = shape.getShapeName();
        //Then
        Assert.assertEquals("triangle", name);
    }

    @Test
    public void testGetCircleName(){
        //Given
        Shape shape = new Circle(1);
        //When
        String name = shape.getShapeName();
        //Then
        Assert.assertEquals("circle", name);
    }

    @Test
    public void testGetSquareName(){
        //Given
        Shape shape = new Square(1);
        //When
        String name = shape.getShapeName();
        //Then
        Assert.assertEquals("square", name);
    }

    @Test
    public void testGetTriangleField(){
        //Given
        Shape shape = new Triangle(5,3,4);
        //When
        double field = shape.getField();
        //Then
        Assert.assertEquals(6, field, 0);
    }

    @Test
    public void testGetSquareField(){
        //Given
        Shape shape = new Square(2);
        //When
        double field = shape.getField();
        //Then
        Assert.assertEquals(4, field, 0);
    }

    @Test
    public void testGetCircleField(){
        //Given
        Shape shape = new Circle(2);
        //When
        double field = shape.getField();
        //Then
        Assert.assertEquals((Math.PI * 4), field, 0);
    }

    @Test
    public void testAddFigureNotExisting(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = null;
        //When
        shapes.addFigure(shape);
        //Then
        Assert.assertEquals(0, shapes.getFigureQty());
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Circle(1);
        //When
        shapes.addFigure(shape);
        //Then
        Assert.assertEquals(shape, shapes.getFigure(0));
    }

    @Test
    public void testRemoveFigureNotExisting(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = null;
        //When
        boolean result = shapes.removeFigure(shape);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Circle(1);
        shapes.addFigure(shape);
        //When
        boolean result = shapes.removeFigure(shape);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapes.getFigureQty());
    }

    @Test
    public void testGetFigureIndexOutOfBound(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        //When
        Shape result = shapes.getFigure(1);
        //Then
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Circle(1);
        shapes.addFigure(shape);
        //When
        Shape result = shapes.getFigure(0);
        //Then
        Assert.assertEquals(shape, result);
    }

    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape1 = new Circle(1);
        Shape shape2 = new Triangle(1,1,1);
        Shape shape3 = new Square(1);
        shapes.addFigure(shape1);
        shapes.addFigure(shape2);
        shapes.addFigure(shape3);
        //When
        String result = shapes.showFigures();
        //Then
        Assert.assertEquals("circle (r=1.0)\ntriangle /a=1.0,b=1.0,c=1.0/\nsquare [a=1.0]\n", result);
    }

}