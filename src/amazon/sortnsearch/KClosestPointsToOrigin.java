package amazon.sortnsearch;

public class KClosestPointsToOrigin {
    public double findDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }


    public void merge(int[][] points, int l, int mid, int h) {
        int firstLen = mid - l + 1;
        int secondLen = h - mid;

        int[][] lPoints = new int[firstLen][];
        int[][] rPoints = new int[secondLen][];

        int j = 0;
        for (int i = l; i < firstLen + l; i++) {
            lPoints[j++] = points[i];
        }

        int k = 0;
        for (int i = mid + 1; i < secondLen + mid + 1; i++) {
            rPoints[k++] = points[i];
        }

        int i = l;
        j = k = 0;
        while (j < firstLen && k < secondLen) {
            if (findDistance(lPoints[j]) < findDistance(rPoints[k])) {
                points[i++] = lPoints[j++];
            } else {
                points[i++] = rPoints[k++];
            }
        }

        while (j < firstLen) {
            points[i++] = lPoints[j++];
        }

        while (k < secondLen) {
            points[i++] = rPoints[k++];
        }
    }

    public void mergeSort(int[][] points, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            mergeSort(points, l, mid);
            mergeSort(points, mid + 1, h);
            merge(points, l, mid, h);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        mergeSort(points, 0, points.length - 1);
        int[][] kPoints = new int[K][];
        for (int i = 0; i < K; i++) {
            kPoints[i] = points[i];
        }

        return kPoints;
    }

    public static void main(String[] args) {
        new KClosestPointsToOrigin().kClosest(new int[][]{{6, 10}, {-3, 3}, {-2, 5}, {0, 2}}, 3);
    }
}
