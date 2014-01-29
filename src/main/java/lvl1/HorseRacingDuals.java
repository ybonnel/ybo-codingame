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

import java.util.Scanner;
import java.util.TreeSet;

public class HorseRacingDuals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        TreeSet<Integer> powers = new TreeSet<Integer>();

        for (int i = 0; i < n; i++) {
            int power = in.nextInt();
            if (powers.contains(power)) {
                System.out.println(0);
                return;
            }
            powers.add(power);
        }

        Integer lastPower = null;
        Integer bestDiff = Integer.MAX_VALUE;

        for (int power : powers) {
            if (lastPower != null && power - lastPower < bestDiff) {
                bestDiff = power - lastPower;
            }
            lastPower = power;
        }
        System.out.println(bestDiff);
    }
}
