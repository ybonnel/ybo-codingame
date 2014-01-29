/*
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
package lvl2;

import java.util.Arrays;
import java.util.Scanner;

public class NetworkCabling {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;


        int[] allY = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            allY[i] = y;
        }

        Arrays.sort(allY);

        int mean;
        if (n%2 == 0) {
            mean = Math.round(((float)(allY[n/2-1]
                + allY[n/2])) /2f);
        } else {
            mean = allY[(n-1)/2];
        }

        long cable = maxX - minX;
        for (int y : allY) {
            cable += Math.abs(y - mean);
        }

        System.out.println(cable);
    }
}
