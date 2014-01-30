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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dwarfs {



    public static void main(String args[]) {
        //Scanner in = new Scanner(Dwarfs.class.getResourceAsStream("/lvl2/dwarfs/in.txt"));
        Scanner in = new Scanner(System.in);

        Map<Integer, Set<Integer>> relations = new HashMap<Integer, Set<Integer>>();

        Set<Integer> personsWithNoParent = new HashSet<Integer>();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (!relations.containsKey(x)) {
                relations.put(x, new HashSet<Integer>());
            }
            if (!relations.containsKey(y)) {
                relations.put(y, new HashSet<Integer>());
            }
            relations.get(x).add(y);
            personsWithNoParent.add(x);
        }
        for (Set<Integer> relation : relations.values()) {
            personsWithNoParent.removeAll(relation);
        }

        int longestPropag = 0;
        for (int person : personsWithNoParent) {

            List<Integer> lastPersonsVisited = Arrays.asList(person);
            int propag = 0;

            // Algo de recherche en largeur.
            while (!lastPersonsVisited.isEmpty()) {

                List<Integer> nextPersons = new ArrayList<Integer>();

                for (Integer lastPersonVisited : lastPersonsVisited) {

                    for (Integer nextPerson : relations.get(lastPersonVisited)) {
                        nextPersons.add(nextPerson);
                    }
                }

                lastPersonsVisited = nextPersons;

                propag++;
            }

            if (propag > longestPropag) {
                longestPropag = propag;
            }
        }
        System.out.println(longestPropag);
    }
}
