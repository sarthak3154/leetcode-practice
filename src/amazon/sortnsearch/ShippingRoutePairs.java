package amazon.sortnsearch;

import java.util.*;

/**
 * Solution not verified
 */
public class ShippingRoutePairs {
    private HashMap<Integer, Integer> forwardList, returnList;

    public int[][] getShippingRoutes(int maxTravelDist, HashMap<Integer, Integer> forwardRouteList, HashMap<Integer, Integer> returnRouteList) {
        int maxFound = 0;
        forwardList = forwardRouteList;
        returnList = returnRouteList;
        List<ShippingPair> pairs = new ArrayList<>();
        for (Integer key : forwardList.keySet()) {
            for (Integer returnKey : returnList.keySet()) {
                pairs.add(new ShippingPair(key, returnKey));
            }
        }

        Collections.sort(pairs);
        int[][] foundPairs = new int[][]{};
        int foundCount = 0;
        for (int i = pairs.size() - 1; i >= 0; i--) {
            ShippingPair pair = pairs.get(i);
            int temp = forwardList.get(pair.r1) + returnList.get(pair.r2);
            if (temp < maxTravelDist) {
                maxFound = Math.max(maxFound, temp);
                if (temp == maxFound) {
                    foundPairs[foundCount++] = new int[]{pair.r1, pair.r2};
                }
            }
        }

        return foundPairs;
    }

    public class ShippingPair implements Comparable<ShippingPair> {
        int r1, r2;

        ShippingPair(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
        }

        @Override
        public int compareTo(ShippingPair o) {
            return Integer.compare(forwardList.get(this.r1) + returnList.get(this.r2), forwardList.get(o.r1) + returnList.get(o.r2));
        }
    }
}
