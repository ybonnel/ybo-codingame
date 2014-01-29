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

import java.util.*;
import java.io.*;
import java.math.*;

// Pass Lvl1 and Lvl2
public class MarsLander {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int minX = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Integer precY = null;
        Integer precX = null;

        int n = in.nextInt(); in.nextLine();

        for (int index = 0; index < n; index++) {
            int x = in.nextInt();
            int y = in.nextInt(); in.nextLine();

            if (precY != null && y == precY) {
                minX = precX;
                maxX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
            precY = y;
            precX = x;
        }





        while (true) {
            // Read information from standard input
            int x = in.nextInt();
            int y = in.nextInt();
            int hs = in.nextInt();
            int vs = in.nextInt();
            int f = in.nextInt();
            int r = in.nextInt();
            int p = in.nextInt(); in.nextLine();
            int power = (y - maxY > 500 && vs > -30) ? 3 : 4;
            int angleWithVs = 45;
            if (vs < -30) {
                angleWithVs = 15;
            } else if (vs < -20) {
                angleWithVs = 30;
            }
            if (y - maxY < 150) {
                angleWithVs = 15;
            }
            // Compute logic here
            if (x < minX) {
                if (hs < 20) {
                    System.out.println("-" + angleWithVs + " " + power);
                } else if (hs > 30) {
                    System.out.println("" + angleWithVs + " " + power);
                } else {
                    System.out.println("0 " + power);
                }
            } else if (x > maxX) {
                if (hs > -20) {
                    System.out.println("" + angleWithVs + " " + power);
                } else if (hs < -30) {
                    System.out.println("-" + angleWithVs + " " + power);
                } else {
                    System.out.println("0 " + power);
                }
            } else {
                if (Math.abs(hs) > 10) {
                    int angle = Math.abs(hs) > 20 ? 45 : 30;
                    if (hs < 0) {
                        System.out.println("-" + angle + " " + power);
                    } else {
                        System.out.println("" + angle + " " + power);
                    }
                } else if (r != 0 || vs < -30) {
                    System.out.println("0 " + power);
                } else {
                    if (vs < -20) {
                        System.out.println("0 3");
                    } else if (vs < -10) {
                        System.out.println("0 2");
                    } else {
                        System.out.println("0 1");
                    }
                }
            }
        }
    }
}
