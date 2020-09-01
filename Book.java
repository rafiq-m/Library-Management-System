/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

/**
 *
 * @author Rafiq
 */
public class Book 
{
    String name;
    String wname;
    int cost;
    int serialNo;
    int avCopies;
    
    Book(String name,String wname,int cost,int serialNo,int avCopies)
    {
        this.name= name;
        this.wname = wname;
        this.cost = cost;
        this.serialNo = serialNo;
        this.avCopies= avCopies;
    }
}
