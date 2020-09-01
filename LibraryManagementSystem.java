/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import java.util.Scanner;

/**
 *
 * @author Rafiq
 */
public class LibraryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int a,b;
        Scanner scn = new Scanner(System.in);
        Library library = new Library();
        do
            {
                System.out.println("Enter\n1- To Add book.\n2- To remove Book.\n3- Add Member.\n4- Remove Member.\n5- To get Book."
                        + "\n6 To return Book.\n7- Exit the program.");
                 a = scn.nextInt();
            switch(a)
            {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.removebook();
                    break;
                case 3:
                    library.addClient();
                    break;
                case 4:
                    library.removeClient();
                    break;
                case 5:
                    library.getBook();
                    break;
                case 6:
                    library.returnBook();
                    break;
                case 7:
                    library.exitProgram();
                    break;
            }
        }while(a!=8);
    }
}
