package amazon.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S == null) return new ArrayList<>();

        int sSize = S.length();
        char[] chars = S.toCharArray();
        HashMap<String, MapIndices> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String str = String.valueOf(chars[i]);
            if (!map.containsKey(str)) {
                MapIndices strIndices = new MapIndices(i, i, 1);
                map.put(str, strIndices);
            } else {
                MapIndices indices = map.get(str);
                indices.count++;
                indices.lIndex = i;
            }
        }

        List<MapIndices> list = new ArrayList<>(map.values());
        if (S.length() > 2) {
            Collections.sort(list);
        }
        int endIndex = -1, initStrVal = 0;
        List<Integer> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            MapIndices item = list.get(i);
            if (item.sIndex > endIndex && endIndex != -1) {
                partitions.add(endIndex - initStrVal + 1);
                S = S.substring(endIndex - initStrVal + 1);
                initStrVal = endIndex + 1;
                endIndex = -1;
            }

            if (endIndex < item.lIndex) {
                endIndex = item.lIndex;
            }
        }

        if (endIndex == sSize - 1 && S.length() >= 1) {
            partitions.add(S.length());
        }

        return partitions;
    }

    class MapIndices implements Comparable<MapIndices> {
        int count;
        int sIndex;
        int lIndex;

        MapIndices(int start, int last, int count) {
            sIndex = start;
            lIndex = last;
            this.count = count;
        }

        public int compareTo(MapIndices i) {
            return Integer.compare(sIndex, i.sIndex);
        }
    }

    public static void main(String[] args) {
        List<Integer> partitions = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(partitions.toString());
    }
}
