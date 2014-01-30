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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Teads {

    // Personnes ayant une relation avec une autre person.
    private static Map<Integer, Set<Integer>> relations;
    // Liste de toutes les persons
    private static Set<Integer> persons;

    /**
     * Construction des relations et remplissage de la liste de personnes.
     */
    public static void constructRelations(Scanner in) {
        int n = in.nextInt();

        relations = new HashMap<Integer, Set<Integer>>();
        persons = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            persons.add(x);
            persons.add(y);
            if (!relations.containsKey(x)) {
                relations.put(x, new HashSet<Integer>());
            }
            relations.get(x).add(y);
            if (!relations.containsKey(y)) {
                relations.put(y, new HashSet<Integer>());
            }
            relations.get(y).add(x);
        }

    }

    /**
     * Trouve le minimum de propagation.
     */
    private static int findBestPropag() {

        // Find a person with just 1 relation
        int personWith1Relation = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : relations.entrySet()) {
            if (entry.getValue().size() == 1) {
                personWith1Relation = entry.getKey();
                break;
            }
        }

        // Calcul propag of this person.
        Set<Integer> personsVisited = new HashSet<Integer>();
        personsVisited.add(personWith1Relation);
        List<Integer> lastPersonsVisited = Arrays.asList(personWith1Relation);
        int propag = 0;
        int sizeOfPersons = persons.size();

        // Algo de recherche en largeur.
        while (personsVisited.size() != sizeOfPersons) {

            List<Integer> nextPersons = new ArrayList<Integer>();

            for (Integer lastPersonVisited : lastPersonsVisited) {

                for (Integer nextPerson : relations.get(lastPersonVisited)) {
                    if (!personsVisited.contains(nextPerson)) {
                        nextPersons.add(nextPerson);
                        personsVisited.add(nextPerson);
                    }
                }
            }

            lastPersonsVisited = nextPersons;

            propag++;
        }

        // le minimum de propagation est le maximum divisé par deux.
        return (propag %2 == 0) ? propag / 2 : (propag+1) /2;
    }


    /**
     * main method.
     */
    public static void main(String args[]) throws InterruptedException {
        Scanner in = new Scanner(Teads.class.getResourceAsStream("/teads.txt"));
        long startTime = System.nanoTime();
        constructRelations(in);

        int bestPropag = findBestPropag();
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time : " + TimeUnit.NANOSECONDS.toMillis(elapsedTime));
        System.out.println(bestPropag);
    }

}
