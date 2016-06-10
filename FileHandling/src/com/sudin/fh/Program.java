/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.fh;

import com.sudin.fh.dao.EmployeeDAO;
import com.sudin.fh.dao.impl.EmployeeDaoImpl;
import com.sudin.fh.entity.Employee;
import com.sudin.fh.utility.FileHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author joyful
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        try {
            List<String> lines = FileHandler.read("f:/employeelist.csv");
            List<String> valid_lines = new ArrayList<>();
            List<String> invalid_lines = new ArrayList<>();
//            List<String>broken=FileHandler.writeBroken("f:/broken.csv");

            EmployeeDAO employeedao = new EmployeeDaoImpl();

            for (String line : lines) {
                StringTokenizer token = new StringTokenizer(line, ",");

                if (token.countTokens() >= 6) {
                    try {

                        Employee e = new Employee();

                        e.setId(Integer.parseInt(token.nextToken()));
                        e.setFirstName(token.nextToken());
                        e.setLastName(token.nextToken());
                        e.setEmail(token.nextToken());
                        e.setContact(token.nextToken());
                        e.setStatus((token.nextToken().equals("1")) ? true : false);

                        employeedao.insert(e);

                        valid_lines.add(line);

                    } catch (Exception ex) {
                        invalid_lines.add(line + ":" + ex.getMessage());
                    }

                }
            }
            while (true) {
                System.out.println("what do you want to do:");
                System.out.println("1. Insert");
                System.out.println("2. Showall");
                System.out.println("3. getById");
                System.out.println("4. getByEmail");
                System.out.println("enter your choice 1-4");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.println("enter ID:");
                        int id = scan.nextInt();

                        System.out.println("enter First Name:");
                        String fName = scan.next().trim();

                        System.out.println("enter last name:");
                        String lName = scan.next();

                        System.out.println("enter email:");
                        String email = scan.next().trim();

                        System.out.println("enter contact:");
                        String contact = scan.next().trim();

                        System.out.println("enter status:");
                        String status = scan.next().trim();
                        employeedao.insert(new Employee(id, fName, lName, email, status, true));
                        System.out.println(employeedao.getAll());
                        break;
                    case 2:
                        System.out.println(employeedao.getAll());
                        break;

                    case 3:
                        System.out.println("enter id:");

                        id = scan.nextInt();

                        System.out.println(employeedao.getById(id));

                        break;
                    case 4:
                        System.out.println("enter email:");
                        email = scan.next();
                        if (employeedao.check_exists(email)) {
                            System.out.println(employeedao.getByEmail(email));

                        } else {
                            System.out.println(" Sorry No Data");
                        }

                        break;
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
