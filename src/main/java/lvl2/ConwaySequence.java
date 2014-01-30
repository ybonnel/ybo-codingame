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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConwaySequence {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        List<Integer> line = new ArrayList<Integer>(Arrays.asList(in.nextInt()));
        int n = in.nextInt();
        for (int i = 1; i < n; i++) {
            List<Integer> nextLine = new ArrayList<Integer>();

            int currentNumber = line.remove(0);
            int occur = 1;

            while (!line.isEmpty()) {
                int nextNumber = line.remove(0);
                if (nextNumber != currentNumber) {
                    nextLine.add(occur);
                    nextLine.add(currentNumber);
                    currentNumber = nextNumber;
                    occur = 1;
                } else {
                    occur++;
                }
            }
            nextLine.add(occur);
            nextLine.add(currentNumber);
            line = nextLine;
        }

        boolean first = true;
        for (int number : line) {
            if (!first) {
                System.out.print(" ");
            }
            first = false;
            System.out.print(number);
        }
    }
}
