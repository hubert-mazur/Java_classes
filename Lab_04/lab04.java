
public class lab04 {
	public static void main(String[] args) {
        int size_y = Integer.parseInt(args[0]);
        int size_x = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        gameOfLife mainObject = new gameOfLife(size_x, size_y, preset);


        for (int i = 1; i <= steps; i++) {
            mainObject.draw(i);
			mainObject.roll();
        }
    }
}
