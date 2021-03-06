package io.oac.contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.countMatches;

public class Day8 {
    public static void main(String[] args) {
        String line = getLines().get(0);
        List<String> layers = getLayers(line, 6, 25);

        System.out.println(layers.size());
        layers.sort(Comparator.comparingInt(o -> countMatches(o, '0')));
        String s = layers.get(0);
        System.out.println(countMatches(s, '1') * countMatches(s, '2'));

        StringBuilder picture = new StringBuilder();
        for (int i = 0; i < 150; i++) {
            StringBuilder pixel = new StringBuilder();
            for (int j = 0; j < 100; j++) {
                char c = line.charAt((i + (j * 150)));
                if (c != '2') {
                    pixel.append(c);
                }
            }
            picture.append(pixel.toString().charAt(0));
        }
        System.out.println(picture.toString());
        for (int i = 0; i < 6; i++) {
            System.out.println(picture.substring(i * 25, (i + 1) * 25));
        }

    }

    static List<String> getLayers(String line, int height, int width) {
        List<String> layers = new ArrayList<>();
        int size = width * height;
        int count = line.length() / size;
        for (int i = 0; i < count; i++) {
            layers.add(line.substring(i * size, ((i + 1) * size)));
        }
        return layers;
    }

    static String getTopLayer(List<String> layers, int height, int width) {
        return null;
    }

    private static List<String> getLines() {
        return Util.getInput("input8");
    }
}

