/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.fh.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranji
 */
public class FileHandler {
   public static List<String> read(String fileName) throws IOException{
        List<String> lines = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line=reader.readLine())!=null){
            lines.add(line);            
        }        
        return lines;
    }
    
    public static void write(String fileName,String content)throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(content);
        writer.close();
    }
}
