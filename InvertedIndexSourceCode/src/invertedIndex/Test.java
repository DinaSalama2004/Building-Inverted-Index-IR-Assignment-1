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




    public static void main(String args[]) throws IOException {
        Index5 index = new Index5();
        //|**  change it to your collection directory
        //|**  in windows "C:\\tmp11\\rl\\collection\\"
        String files = "D:\\FCAI\\third year\\semester 2\\IR\\HW1\\yarab\\Building-Inverted-Index-IR-Assignment-1\\test files\\";
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

        System.out.println("──────────────────────── Testing all in Main... ──────────────────────── \n");
        System.out.println("⏩⏩ Files exist are : \n");
        for (int i = 0; i < fileList.length; i++) {
            fileList[i] = files + fileList[i];
            System.out.println("         ➤"+fileList[i]);
        }

        System.out.println("\n");


        System.out.println("──────────── Testing buildIndex ... ────────────── \n");

        index.buildIndex(fileList);


        index.store("index");
        index.printDictionary();



        System.out.println("──────────── Testing print Posting List  ... ────────────── \n");

        Posting p1 = new Posting(2);
        Posting p2 = new Posting(5);
        Posting p3 = new Posting(8);
        Posting p4 = new Posting(11);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        System.out.print("Posting List Output: ");
        index.printPostingList(p1);

        System.out.println("──────────── Testing   intersect  ... ────────────── \n");

        Posting p11 = new Posting(2);
        Posting p22 = new Posting(5);
        Posting p33 = new Posting(8);


        p11.next = p22;
        p22.next = p33;


        System.out.println(" p11 and p1 intersect in this list  [ " +index.intersect(p11,p1) +" ]");


        System.out.println("──────────────────────────────────────────────── ");


        String test3 = "data  should plain greatest comif"; // data  should plain greatest comif
        System.out.println("Boo0lean Model result = \n" + index.find_24_01(test3));








        System.out.println("──────────── search  ... ────────────── \n");

        String phrase = "";

        do {
            System.out.println("Write the  phrase you search : ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            phrase = in.readLine();
            if (!phrase.isEmpty()) {
                System.out.println("Search Results: \n" + index.find_24_01(phrase));
            }

        } while (!phrase.isEmpty());
//
}
}
