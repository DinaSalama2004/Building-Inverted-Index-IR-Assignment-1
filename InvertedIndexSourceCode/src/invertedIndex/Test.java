/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

import java.io.*;

/**
 *
 * @author ehab
 */
public class Test {


    public static void test_intersect(int[] arr1, int[] arr2) {
        System.out.println("\nTest intersect : " );

        // Convert arrays to linked lists

        if (arr1.length == 0 ||arr2.length == 0)
        {
            System.out.println("Error: The array is empty.");
            return;
        }


        Posting pL1= new Posting(arr1[0]);
        Posting pL2= new Posting(arr2[0]);

        Posting current1 = pL1;
        for (int i = 1; i < arr1.length; i++) {
            current1.next = new Posting(arr1[i]);
            current1 = current1.next;
        }
        Posting current2 = pL2;
        for (int i = 1; i < arr2.length; i++) {
            current2.next = new Posting(arr2[i]);
            current2 = current2.next;
        }

        // Perform intersection
//        return      printPostingList(intersect(pL1, pL2)) ;


    }
    public static boolean Search(String filePath, String phrase) {
        boolean found = false;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {

            String line;
            int linenum = 1;
            while ((line = fileReader.readLine()) != null){
                if (line.toLowerCase().contains(phrase.toLowerCase())){
                    System.out.println("found in " + filePath);
                    found = true;
                }
                linenum++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + filePath + ": " + e.getMessage());
        }
        return found;
    }


    public static void test_intersect(int[] arr1, int[] arr2) {
        System.out.println("\nTest intersect : " );

        // Convert arrays to linked lists

        if (arr1.length == 0 ||arr2.length == 0)
        {
            System.out.println("Error: The array is empty.");
            return;
        }


        Posting pL1= new Posting(arr1[0]);
        Posting pL2= new Posting(arr2[0]);

        Posting current1 = pL1;
        for (int i = 1; i < arr1.length; i++) {
            current1.next = new Posting(arr1[i]);
            current1 = current1.next;
        }
        Posting current2 = pL2;
        for (int i = 1; i < arr2.length; i++) {
            current2.next = new Posting(arr2[i]);
            current2 = current2.next;
        }

        // Perform intersection
        return printPostingList(intersect(pL1, pL2)) ;
    }
    

    public static void main(String args[]) throws IOException {
        Index5 index = new Index5();
        //|**  change it to your collection directory
        //|**  in windows "C:\\tmp11\\rl\\collection\\"
        String files = "C:\\Users\\hp\\Desktop\\New folder (2) - Copy\\";
        File file = new File(files);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Error: it is not exist or is not a directory.");
            return;
        }
        //|** String[] 	list()
        //|**  Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.
        String[] fileList = file.list();
        if (fileList == null || fileList.length == 0) {
            System.out.println("Error: The directory is empty.");
            return;
        }


        fileList = index.sort(fileList);
        index.N = fileList.length;

        for (int i = 0; i < fileList.length; i++) {
            fileList[i] = files + fileList[i];
        }

        index.buildIndex(fileList);
        index.store("index");
        index.printDictionary();

        Posting p1 = new Posting(2);
        Posting p2 = new Posting(5);
        Posting p3 = new Posting(8);
        Posting p4 = new Posting(11);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        System.out.print("Posting List Output: ");
        index.printPostingList(p1);
        

        String test3 = "data  should plain greatest comif"; // data  should plain greatest comif
        System.out.println("Boo0lean Model result = \n" + index.find_24_01(test3));

        String phrase = "";

        do {
            System.out.println("Print search phrase: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            phrase = in.readLine();
            if (!phrase.isEmpty()) {
                boolean found = false;
                for (String path : fileList){
                    if (Search(path, phrase)) found = true;
                }
                if (!found){
                    System.out.println("not found!");
                }
            }
/// -3- **** complete here ****
        } while (!phrase.isEmpty());
//
}
}
