package lvl1;/*
 * Copyright 2013- Yan Bonnel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.math.BigDecimal;
import java.util.Scanner;

public class Defibrillators {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String longitude = in.nextLine().replace(',', '.');
        String latitude = in.nextLine().replace(',', '.');
        int n = in.nextInt(); in.nextLine();
        String betterDefibrillator = null;
        double betterDistance = Float.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String longDef = line.split(";")[4].replace(',', '.');
            String latDef = line.split(";")[5].replace(',', '.');
            double distance = distance(longitude, latitude, longDef, latDef);
            if (distance < betterDistance) {
                betterDistance = distance;
                betterDefibrillator = line.split(";")[1];
            }
        }
        System.out.println(betterDefibrillator);
    }

    public static double distance(String longA, String latA, String longB, String latB) {
        double longARad = Double.parseDouble(longA) * Math.PI / 180d;
        double latARad = Double.parseDouble(latA) * Math.PI / 180d;
        double longBRad = Double.parseDouble(longB) * Math.PI / 180d;
        double latBRad = Double.parseDouble(latB) * Math.PI / 180d;

        double x = (longBRad - longARad) * Math.cos((latARad + latBRad) / 2d);
        double y = latBRad - latARad;

        return Math.sqrt(x*x + y*y) * 6371;
    }
}
