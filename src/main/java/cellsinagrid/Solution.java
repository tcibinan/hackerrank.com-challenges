package cellsinagrid;

import java.util.*;

public class Solution {

    static int solution;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        solution = findMaxRegionSize(grid);
        System.out.println(solution);
    }

    private static int findMaxRegionSize(int[][] grid) {
        Set<Point> visited = new HashSet<>();
        Region maxRegion = new Region();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Point point = Point.of(i, j);
                if (!visited.contains(point) && grid[i][j] == 1) {
                    Region curRegion = new Region();
                    findRegion(grid, point, curRegion, visited, grid.length, grid[i].length);
                    if (curRegion.size > maxRegion.size) {
                        maxRegion = curRegion;
                    }
                }
            }
        }

        return maxRegion.size;
    }

    private static void findRegion(int[][] grid, Point point, Region region, Set<Point> visited, int sizeX, int sizeY) {
        if (visited.contains(point)
                || point.x < 0 || point.x >= sizeX
                || point.y < 0 || point.y >= sizeY
                || !isPointFilled(grid, point)) {
            return;
        }

        region.includePoint();
        visited.add(point);

        findRegion(grid, Point.of(point.x-1, point.y-1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x, point.y-1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x+1, point.y-1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x+1, point.y), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x+1, point.y+1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x, point.y+1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x-1, point.y+1), region, visited, sizeX, sizeY);
        findRegion(grid, Point.of(point.x-1, point.y), region, visited, sizeX, sizeY);
    }

    private static boolean isPointFilled(int[][] grid, Point point) {
        return grid[point.x][point.y] == 1;
    }

    static class Region {
        int size;

        public void includePoint() {
            size++;
        }
    }

    static class Point {
        final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point of(int x, int y) {
            return new Point(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}