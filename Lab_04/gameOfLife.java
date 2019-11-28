import java.util.Random;

public class gameOfLife {

	private boolean[][] array;
    private int size_x;
    private int size_y;
    private int preset;
    private int center_x;
    private int center_y;


	public boolean[][] getArray() {
        return this.array;
    }

    public int getSize_x() {
        return this.size_x;
    }

    public int getSize_y() {
        return this.size_y;
    }

    public gameOfLife(int size_x, int size_y, int preset) {
        this.size_x = size_x;
        this.size_y = size_y;
        this.preset = preset;
        this.array = new boolean[size_x][size_y];
        this.center_x = this.size_x / 2;
        this.center_y = this.size_y / 2;
        init();
    }


	private void init() {

        switch (preset) {
        case 0: {
            this.randomDistribution();
            break;
        }

        case 1: {
            this.lodz();
            break;
        }

        case 2: {
            this.blinker();
            break;
        }

        case 3: {
            this.spaceship();
            break;
        }
        default: {
            this.randomDistribution();
            break;
        }

        }
    } 

	private void lodz() {

        array[center_x][center_y - 1] = true;
        array[center_x][center_y + 1] = true;
        array[center_x + 1][center_y] = true;
        array[center_x - 1][center_y - 1] = true;
        array[center_x - 1][center_y] = true;
    }

	private void blinker() {
        array[center_x][center_y] = true;
        array[center_x + 1][center_y] = true;
        array[center_x - 1][center_y] = true;
    }

	private void spaceship() {
        array[center_x - 1][center_y] = true;
        array[center_x - 1][center_y + 1] = true;
        array[center_x - 1][center_y - 1] = true;
        array[center_x][center_y - 1] = true;
        array[center_x + 1][center_y] = true;
    }


	private void randomDistribution() {
        int numberOfCellulars;
        int place_x;
        int place_y;

        Random rand = new Random();

        numberOfCellulars = rand.nextInt(size_x * size_y);

        for (int i = 0; i < numberOfCellulars; i++) {

            while (true) {
                place_x = rand.nextInt(size_x);
                place_y = rand.nextInt(size_y);
                if (array[place_x][place_y] != true) {
                    array[place_x][place_y] = true;
                    break;
                }
            }
        }
    }

	public void draw(int step) {

        for (int i = 0; i < center_x; i++)
            System.out.print("-");
        System.out.print(step);
        for (int i = 0; i < center_x; i++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (array[i][j])
                    System.out.print("X");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }	


    private boolean[][] copyArray(boolean[][] array) {

        boolean[][] tempArray = new boolean[size_x][size_y];

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                tempArray[i][j] = array[i][j];
            }
        }
        return tempArray;
    }


    public void roll() {

        boolean[][] copiedArray = copyArray(array);

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                array[i][j] = checkNeighbourhood(copiedArray, i, j);
            }
        }
    }


    private boolean checkNeighbourhood(boolean[][] array, int x, int y) {

        int neighboursCount = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i == x && j == y)
                    continue;

                if (verify_index(i, size_x) && verify_index(j, size_y)) {
                    if (array[i][j] == true) {
                        neighboursCount++;
                    }
                }
            }
        }

        if ((array[x][y] == false && neighboursCount == 3)) {
            return true;
        } else if (array[x][y] == true && (neighboursCount == 2 || neighboursCount == 3)) {
            return true;
        }

        return false;
    }

	private boolean verify_index(int index, int range) {
        if (index < 0 || index > (range - 1))
            return false;
        else
            return true;
    }
}

