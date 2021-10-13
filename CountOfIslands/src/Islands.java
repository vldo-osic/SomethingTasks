public class Islands {

    int[][] mapOfArea;
    int[][] mapOfArea_copy;
    int countOfIslands;

    public Islands(int[][] mapOfArea) {
        this.mapOfArea = mapOfArea;
        this.mapOfArea_copy = copyMapOfArea(mapOfArea);
    }

    private int[][] copyMapOfArea(int[][] mapOfArea) {
        int[][] mapOfArea_copy = new int[mapOfArea.length + 2][mapOfArea[0].length + 2];

        for (int i = 0; i < mapOfArea.length; i++)
            for (int j = 0; j < mapOfArea[0].length; j++)
                mapOfArea_copy[i + 1][j + 1] = mapOfArea[i][j];

        return mapOfArea_copy;
    }

    private void searchingIsland(int i, int j) {
        mapOfArea_copy[i][j] = 0;
        if (mapOfArea_copy[i + 1][j] == 1) searchingIsland(i + 1, j);
        if (mapOfArea_copy[i][j + 1] == 1) searchingIsland(i, j + 1);
        if (mapOfArea_copy[i - 1][j] == 1) searchingIsland(i - 1, j);
        if (mapOfArea_copy[i][j - 1] == 1) searchingIsland(i, j - 1);
    }

    public int islandCounter() {
        for (int i = 1; i < mapOfArea_copy.length - 1; i++) {
            for (int j = 1; j < mapOfArea_copy[0].length - 1; j++) {
                if (mapOfArea_copy[i][j] == 1) {
                    searchingIsland(i, j);
                    this.countOfIslands++;
                }
            }
        }
        return countOfIslands;
    }
}
