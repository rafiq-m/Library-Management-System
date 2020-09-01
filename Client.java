/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import java.util.Scanner;


public class Client 
{
    Scanner scn = new Scanner(System.in);
    String name;
    String contactNo;
    int serialNo;
    int haveCopies;
    double toPay;
    
    Client(String name,String contactNo,int serialNo,int haveCopies,double toPay)
    {
        this.name = name;
        this.contactNo =contactNo;
        this.serialNo = serialNo;
        this.haveCopies = haveCopies;
        this.toPay = toPay;
    }
    
    
}
