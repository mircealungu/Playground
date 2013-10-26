import java.util.*;
import java.io.*;
import java.lang.*;

public class Tsp {
	public static int INF = 10000;
	private static ArrayList<Point> readPoints() throws IOException
	{
		System.out.println("Input points, ending with 0 0");
		ArrayList <Point> points = new ArrayList <Point>();
		Point p = new Point();

		Scanner in = new Scanner (System.in);

		p.x = in.nextInt();
		p.y = in.nextInt();

		while (!((p.x == 0) && (p.y == 0)))
		{
			points.add(p);
			p = new Point();
			p.x = in.nextInt();
			p.y = in.nextInt();

		} 

		return points;
				
	}
	private static void printPoints(ArrayList<Point> points)
	{
		for (Point p :points)
		{
			System.out.print(p.x);
			System.out.print(p.y);
			System.out.println();
		}
	}

	private static Point findClosestPoint(Point pivot, ArrayList<Point> points)
	{
		int min_dist = INF;
		Point next = new Point();

		for (Point each: points) {
			/* keep p if distance is minimum */
				if (min_dist > dist (pivot, each)) {
					min_dist = dist(pivot, each);
					next = each;
			}
		}
		return next;

	}
	private static int dist(Point p, Point q)
	{
		return (int)Math.sqrt(Math.pow((p.x - q.x),2) + Math.pow((p.y - q.y), 2));
	}

	private static ArrayList<Point> closest_first(ArrayList<Point> points)
	{
		ArrayList<Point> visited = new ArrayList<Point> ();
		Point pivot = points.get(0);
		visited.add(pivot);
		points.remove(pivot);

		while (!points.isEmpty())
		{
			Point closest = findClosestPoint(pivot, points);
			visited.add(closest);
			points.remove(closest);
			pivot = closest;
		}
		return visited;
	}

	private static ArrayList<Point> smallest_segments(ArrayList <Point> points)
	{

		ArrayList <Chain> chains = new ArrayList <Chain> ();
		for (Point p: points)
		{
			chains.add(new Chain(p));
		}

		while (chains.size() > 1)
		{
			int dist = INF;
			String firstdir="", seconddir="";
			Chain firstchain = new Chain();
			Chain secondchain = new Chain();
			

			for (Chain first: chains) {
				for (Chain second: chains){
					if (first != second) {
						/* if (dist > dist (first.left(), second.left())){
							dist = dist (first.left(), second.left());
							firstdir = "left";
							seconddir = "left";
							firstchain = first;secondchain = second;} */

						if (dist > dist (first.right(), second.left())){
							dist = dist (first.right(), second.left());
							firstdir = "right";	
							seconddir = "left";
							firstchain = first;secondchain = second;}

						/* if (dist > dist (first.right(), second.right())){
									dist = dist (first.right(), second.right());
									firstdir = "right";	
									seconddir = "right";
									firstchain = first;secondchain = second;}*/
						if (dist > dist (first.left(), second.right())){
							dist = dist (first.left(), second.right());
							firstdir = "left";	
							seconddir = "right";
							firstchain = first;secondchain = second;}
					}
				}	
			}
			chains = mergeChains(chains, firstdir, seconddir, firstchain, secondchain);
		}
		
		return chains.get(0).points;
	}
	
	private static ArrayList <Chain> mergeChains(ArrayList <Chain> chains, String firstdir, String secondir, Chain firstChain, Chain secondChain){
		chains.remove(firstChain);
		chains.remove(secondChain);

		if (firstdir == "right") {
			chains.add(new Chain(firstChain, secondChain));
		} else {
			chains.add(new Chain(secondChain, firstChain));
		}
		return chains;	
	}

	public static void main(String [] args) throws IOException
	{
		//ArrayList<Point> points = readPoints();
		ArrayList<Point> points = ex1();

		System.out.println("solution next closest");
		printPoints(closest_first(points));

		System.out.println("solution smallest segments");
		printPoints(smallest_segments(ex1()));					


	}

	private static ArrayList<Point> ex1()
	{
		ArrayList <Point> ex = new ArrayList<Point>();
		ex.add(new Point(0,0));
		ex.add(new Point(1,0));
		ex.add(new Point(-1,0));
		ex.add(new Point(4,0));
		ex.add(new Point(-4,0));
		ex.add(new Point(10,0));
		ex.add(new Point(-10,0));
		return ex;
	}
}

class Point {
	public int x;
	public int y;
	public Point(int xx, int yy)
		{
			this.x = xx;
			this.y = yy;
		}
	public Point()
	{
	}
}

class Chain {
	public ArrayList <Point> points;
	public Point left () {return points.get(0);}
	public Point right () {return points.get(points.size() - 1);}
	public Chain()
	{}
	public Chain(Point p)
	{
		points = new ArrayList <Point>();
		points.add(p);
	}
	public Chain (Chain a, Chain b)
	{
		points = a.points;
		points.addAll(b.points);
	}
}

