public class TestTask {
    public static void main(String[] args) {
        int[][] area = {{1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1}};
        Islands a = new Islands(area);
        System.out.println(a.islandCounter());
    }
}
