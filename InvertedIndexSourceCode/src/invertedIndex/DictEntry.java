/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

import java.util.HashSet;

/**
 *
 * @author ehab
 */
public class DictEntry {

    public int doc_freq = 0; // number of documents that contain the term
    public int term_freq = 0; //number of times the term is mentioned in the collection
//=====================================================================
    public HashSet<Integer> postingList;
    Posting pList = null;
    Posting last = null;
//------------------------------------------------

    boolean postingListContains(int i) {
        boolean found = false;
        Posting p = pList;
        while (p != null) {
            if (p.docId == i) {
                return true;
            }
            p = p.next;
        }
        return found;
    }
//------------------------------------------------

    int getPosting(int i) {
        int found = 0;
        Posting p = pList;
        while (p != null) {
            if (p.docId >= i) {
                if (p.docId == i) {
                    return p.dtf;
                } else {
                    return 0;
                }
            }
            p = p.next;
        }
        return found;
    }
//------------------------------------------------

//    void addPosting(int i) {
//
////        if (pList == null) { // First posting in the list
////            pList = newPosting;
////            last = newPosting;
////        } else {
////            last.next = newPosting; // Append to the last node
////            last = newPosting; // Update last to the new posting
////        }
//
//
//
//        newpostlist = new Posting(i);
//        if (pList == null) {
//            pList = new Posting(i);
//            last = pList;
//        } else {
//
//            if (last != null) { // Extra safety check
//                last.next = pList;// Add new posting at the end
//            }
//
////            last = last.next;
//            last = pList;
//        }
//    }
void addPosting(int i) {
    Posting newPosting = new Posting(i);

    if (pList == null) { // If the list is empty
        pList = newPosting;
        last = newPosting; // Ensure last points to the first node
    } else {
        if (last != null) { // Extra safety check
            last.next = newPosting; // Add new posting at the end
        }
        last = newPosting; // Update last to point to the new node
    }
}

// implement insert (int docId) method

    DictEntry() {
          postingList = new HashSet<Integer>();
    }

    DictEntry(int df, int tf) {
        doc_freq = df; 
        term_freq = tf;
    }

}
