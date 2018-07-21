package com.lee.section02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Problem03 {
    public HashMap<String, Integer> BuildWordCloud_buildOnString(String input) {
        HashMap<String, Integer> wordCloud = new HashMap<>();
        String word = "";
        for (char ch : input.toCharArray())
        {
            // look for word boundaries (spaces, punctuations, numbers, etc)
            if (!Character.isLetter(ch)) {
                if (word == "") {
                continue;
                }
                int cnt = 0;
                if (wordCloud.containsKey(word)) {
                    cnt = wordCloud.get(word);
                }
                cnt++;
                wordCloud.put(word, cnt);
                word = "";
                continue;
            }

            // convert uppercase letter to lowercase
            char c = Character.toLowerCase(ch);
            word += c;
        }

        // insert the final word, if any
        if (word != "") {
            int cnt = 0;
            if (wordCloud.containsKey(word)) {
                cnt = wordCloud.get(word);
            }
            cnt++;
            wordCloud.put(word, cnt);
        }
        return wordCloud;
    }

    public HashMap<String, Integer> BuildWordCloud_buildUsingIndex(String input) {
        HashMap<String, Integer> wordCloud = new HashMap<>();
        int currentWordStartIndex = 0;
        int currentWordLength = 0;
        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                if (currentWordLength == currentWordStartIndex) { // if we see a ' ' | ',' again it means they're both at the same positions, we just continue...
                    currentWordLength++;
                    currentWordStartIndex = currentWordLength;
                    continue;
                }
                hashWordIntoMap(input, wordCloud, currentWordStartIndex, currentWordLength);
                currentWordLength += 1; // reset new index position and length for new word
                currentWordStartIndex = currentWordLength;
                continue;
            }
            currentWordLength++;
        }

        if (currentWordStartIndex != currentWordLength ) {
            hashWordIntoMap(input, wordCloud, currentWordStartIndex, currentWordLength);
        }
        return wordCloud;
    }

    public void hashWordIntoMap(String input, HashMap wordCloud, int currentWordStartIndex, int currentWordLength) {
        int cnt = 0;
        if (wordCloud.containsKey(input.substring(currentWordStartIndex, currentWordLength))) {
            cnt = (int) wordCloud.get(input.substring(currentWordStartIndex, currentWordLength));
        }
        cnt++;
        wordCloud.put(input.substring(currentWordStartIndex, currentWordLength).toLowerCase(), cnt);

    }


    public void displayHash(Map map) {
        Set<String> key = map.keySet();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

    }
}

// "After  beating the eggs, Dana read the next step:"
// "Add milk and eggs, then add flour and sugar"
// "Bill paid the bill."

// Edge cases:
// 1. Capitalized letters - just convert all to lowercase, including proper nouns
// 2. Punctuation
// 9. Contractions. e.g. hasn't -- assume this never appears in our input
// 3. Pluralized words - just treat as two separate words
// 4. Empty words, e.g. double spaces, or space after punctuation, etc
// 5. Numbers - treat as punctuation - only consider a-z as characters
// 6. String ends in character -- make sure to store the last word into the hashmap *after* the loop
// 7. Proper noun vs regular noun of same spelling. e.g. Bill vs bill -- treat as the same word
// 8. Possessive apostrophe. e.g. Bill's -- assume this never appears in our input
// 10. Hyphenated compound words. e.g. Mille-Feuille. Treat as two words

