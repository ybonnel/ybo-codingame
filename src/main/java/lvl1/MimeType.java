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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MimeType {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt(); in.nextLine();

        Map<String, String> mimeTypes = new HashMap<String, String>();

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            mimeTypes.put(line.split(" ")[0].toUpperCase(), line.split(" ")[1]);
        }

        for (int i = 0; i < q; i++) {
            String fileName = in.nextLine();
            if (!fileName.contains(".")) {
                System.out.println("UNKNOWN");
            } else {
                String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
                if (mimeTypes.containsKey(ext)) {
                    System.out.println(mimeTypes.get(ext));
                } else {
                    System.out.println("UNKNOWN");
                }
            }
        }
    }
}
