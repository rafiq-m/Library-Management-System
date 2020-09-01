/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rafiq
 */
public class Library 
{
    ArrayList<Book> book = new ArrayList<>();
    ArrayList<Client> client = new ArrayList<>();
    int bank =0;
    Scanner scn = new Scanner(System.in);
    
    Library()
    {
        this.book.add(new Book("Java","Daniel",200,1,4));
        this.book.add(new Book("C#","Rafiq",500,2,8));
        this.book.add(new Book("Python","Haris",1500,3,2));
        this.book.add(new Book("PHP","Osama",900,4,5));
        this.book.add(new Book("ICS","Raheel",750,5,9));
        this.client.add(new Client("Adeel","3120983129",1,0,0));
        this.client.add(new Client("Meraj","3120983119",2,0,0));
        this.client.add(new Client("Anas","3120983129",3,0,0));
    }
    
    void addBook()
    {
        System.out.println("Enter Book Name:");
        String name = scn.next();
        System.out.println("Enter Book Writer Name:");
        String wname = scn.next();
        System.out.println("Enter Cost of the book:");
        int cost = scn.nextInt();
        System.out.println("Enter Available Copies:");
        int avCopies = scn.nextInt();
        this.book.add(new Book(name,wname,cost,this.book.size(),avCopies));
    }
    
    void removebook()
    {
        System.out.println("Enter Book Name which has to be removed:");
        String name = scn.next();
        for(int i =0;i<this.book.size();i++)
        {
            if(name.equalsIgnoreCase(this.book.get(i).name))
            {
                this.book.set(i, new Book(this.book.get(i).name,this.book.get(i).wname,this.book.get(i).cost,this.book.get(i).serialNo,this.book.get(i).avCopies-1));
            }
        }
    }
    void addClient()
    {
        System.out.println("Enter Client Name:");
        String name = scn.next();
        System.out.println("Enter Client Contact No:");
        String contactNo = scn.next();
        this.client.add(new Client(name,contactNo,1+this.client.size(),0,0));
    }
    
    void removeClient()
    {
        System.out.println("Enter Client Name which has to be removed:");
        String name = scn.next();
        for(int i =0;i<this.client.size();i++)
        {
            if(name.equalsIgnoreCase(this.client.get(i).name))
            {
                this.client.remove(i);
            }
        }
    }
    
    void printNoOfBooks()
    {
        for(int i =0;i<this.book.size();i++)
        {
            System.out.print(this.book.get(i).name + "\t");
            System.out.print(this.book.get(i).wname + "\t");
            System.out.print(this.book.get(i).cost + "\t");
            System.out.print(this.book.get(i).serialNo + "\t");
            System.out.print(this.book.get(i).avCopies + System.lineSeparator());
        }
    }
    void printNoOfClients()
    {
        System.out.print("NAME" + "\t");
            System.out.print("CONTACT NO" + "\t");
            System.out.print("SERIAL NO" + "\t");
            System.out.print("NO OF COPIES" + "\t");
            System.out.print(" TO PAY" + System.lineSeparator());
        for(int i =0;i<this.client.size();i++)
        {
            System.out.print(this.client.get(i).name + "\t");
            System.out.print(this.client.get(i).contactNo + "\t");
            System.out.print(this.client.get(i).serialNo + "\t");
            System.out.print(this.client.get(i).haveCopies + "\t");
            System.out.print(this.client.get(i).toPay + System.lineSeparator());
           
        }
    }
    
    void getBook()
    {
        int i=0 ,j=0;    
        System.out.println("Enter Client's Name:");
          do{
        String name= scn.next();
        for(i =0 ;i < this.client.size();i++)
        {
            if(name.equalsIgnoreCase(this.client.get(i).name))
            {
            break;
            }
        }
        if(i>=client.size())System.out.println("Enter Client's name correclty or Register the client.");
        }while(i>=client.size());        
        System.out.println("Enter The name of the book:");
        String bname = scn.next();
        for(j=0;j < book.size();j++)
        {
            if(bname.equalsIgnoreCase(this.book.get(j).name))
            {
                System.out.println("Enter How many copies you wan't:");
                int avCopies = scn.nextInt();
                if(avCopies <= book.get(j).avCopies)
                {
                    System.out.println("Book Issued");
                    book.get(j).avCopies = book.get(j).avCopies - avCopies;
                    client.get(i).toPay = (book.get(j).cost)*(avCopies);
                    client.get(i).haveCopies = client.get(i).haveCopies + avCopies;
                }
                else if(avCopies > book.get(j).avCopies)
                {
                    System.out.println("We have not enough available copies!");
                    break;
                }
            }
        }
        if(j>book.size())System.out.println("Book not found in our DataBase!");
    }   
    void returnBook()
    {
        int i=0 ,j=0,days;
        double amount=0.0;
        System.out.println("Enter Client's Name:");
          do{
        String name= scn.next();
        for(i =0 ;i < this.client.size();i++)
        {
            if(name.equalsIgnoreCase(this.client.get(i).name))
            {
            break;
            }
        }
        if(i>=client.size())System.out.println("Enter Client's name correclty.");
        }while(i>=client.size()); 
          if(client.get(i).toPay==0)
          {
              System.out.println("You have nothing to pay!");
              return; 
          }
          System.out.println("How many days after you are returning the book ? ");
          days = scn.nextInt();
          if(days <=37)
          {
          days = days-7;
          int weeks = days/7;
          amount = weeks * this.client.get(i).toPay *0.10;
          this.client.get(i).toPay = this.client.get(i).toPay + amount;
          }
          else if(days > 30  && amount >1000)
          {
              this.client.remove(i);
          }
          System.out.printf("Pay Rs . %.2f\n",this.client.get(i).toPay);
          System.out.println("Enter Payment:");
          int pay = scn.nextInt();
          this.client.get(i).toPay = this.client.get(i).toPay - pay;
          if(this.client.get(i).toPay==0)
          {
              System.out.println("Thanks for full payment.");
          }
          else if(this.client.get(i).toPay>0)
          {
              System.out.printf("You have more to pay which is : Rs %.2f\n",this.client.get(i).toPay);
          }
          
              
    }
     void exitProgram()
          {
              System.exit(0);
          }
               

}
