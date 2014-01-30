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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneNumbers {

    private static class Node {
        private Map<Character, Node> childs = new HashMap<Character, Node>();

        private Node() {
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();

        int numbersOfNodes = 0;
        Map<Character, Node> rootNodes = new HashMap<Character, Node>();

        for (int i = 0; i < n; i++) {
            String numero = in.nextLine();

            Map<Character, Node> currentRoots = rootNodes;

            for (char digit : numero.toCharArray()) {
                if (!currentRoots.containsKey(digit)) {
                    currentRoots.put(digit, new Node());
                    numbersOfNodes++;
                }
                currentRoots = currentRoots.get(digit).childs;

            }
        }
        System.out.println(numbersOfNodes);
    }
}
