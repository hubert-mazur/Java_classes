public class lab01 {
	public static void main (String[] args) {

		draw_line(28,65,28,84);
		draw_line(28,84,34,83);
		draw_line(34,83,38,79);
		draw_line(38,79,37,76);
		draw_line(37,76,34,73);
		draw_line(28,72,37,76);
		draw_line(58,25,53,23);
		draw_line(53,23,47,23);
		draw_line(47,23,44,25);
		draw_line(74,65,63,65);
		draw_line(63,65,73,74);
		draw_line(73,74,73,79);
		draw_line(73,79,70,82);
		draw_line(70,82,66,82);
		draw_line(66,82,63,80);
		draw_circle(50,74,9);
		draw_circle(50,29,14);
		draw_circle(55,34,2);
		draw_circle(46,34,2);

	}

	public static void draw_line(int x1, int y1, int x2, int y2) {

		double dx1 = (double) x1;
		double dx2 = (double) x2;
		double dy1 = (double) y1;
		double dy2 = (double) y2;
		double jumpx = 0.5;
		double jumpy = 0.5;

		if (dx1 > dx2)
			jumpx = -0.5;

		if (dy1 > dy2)
			jumpy = -0.5;

		 while (true) {
			System.out.print(dx1 + " ");
			System.out.println(dy1);

				if (dx1 != dx2)
					dx1 += jumpx;
				if (dy1 != dy2)
					dy1 +=jumpy;

				if (jumpx < 0 && jumpy < 0) {
						if (dx1 <= dx2 && dy1 <= dy2)
						break;
				}

				else if (jumpx < 0 && jumpy > 0) {
					if (dx1 <= dx2 && dy1 >= dy2)
						break;
				}

				else if (jumpx > 0 && jumpy > 0) {
					if (dx1 >= dx2 && dy1 >= dy2)
						break;
				}
				
				else if (jumpx > 0 && jumpy < 0) {
					if (dx1 >= dx2 && dy1 <= dy2)
						break;
				}
		 }
	}

	public static void draw_circle (int x, int y, int radius) {
		double dx = (double) x;
		double dy = (double) y;
		double dr = (double) radius;

		double it = 0.0;
		double jump = 0.1;
		double upperLimit = 2 * Math.PI;

		while (it <= upperLimit)
		{
			System.out.print((dr * Math.cos(it) + dx) + " ");
			System.out.println((dr * Math.sin(it) + dy));
			it += jump;
		}

	}
}

