// 
// Created by Jiang Long
// Spring 2022 for CS201 DKU
//

import java.util.Arrays;

public class Zipf { 
    

    // Note: nested class for sort freq/key pair
    static class Pair implements Comparable<Pair> {
        int freq;
        String key;
        
        public Pair(int freq, String key) {
            this.freq = freq;
            this.key = key;
        }
        
        public int compareTo(Pair b) {
            if (freq != b.freq) {
                return b.freq - freq;
            } else {
                return key.compareTo(b.key);
            }
        }
    }
    
    public static void main(String[] args)
    { 
        BST<String, Integer> bst = new BST<>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String key = in.readString();
            if (bst.contains(key)) {
                bst.put(key, bst.get(key) + 1);
            } else {
                bst.put(key, 1);
            }
        }
        in.close();
        
        Pair[] pairs = new Pair[bst.size()];
        int i = 0;
        for (String key : bst.keys()) {
            pairs[i++] = new Pair(bst.get(key), key);
        }
        Arrays.sort(pairs);
        
        int count = 0;
        for (Pair p : pairs) {
            if (count == 20) {
                break;
            }
            System.out.printf("%10d %s\n", p.freq, p.key);
            count++;
        }
    }
    
}