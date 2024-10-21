/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package textedit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author semih
 */
public class TextEdit {

    /**
     * @param args the command line arguments
     */
    
    
    String fName = "", fPath = "";
    File file;
    
    private void inputString(String fileName, String fileParh){
        file = new File(fileParh.concat("\\".concat(fileName)));
    }
    
    public void createFile(String fileName, String fileParh){
        try{
            File file = new File(fileParh.concat("\\".concat(fileName)));
            
            if(file.createNewFile()){
                JOptionPane.showConfirmDialog(null, "Dosya oluşturulma başarılı", "Dosya Oluşturma", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null, "Dosya oluşturulma başarısız, dosya mevcut", "Dosya Oluşturma", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showConfirmDialog(null, "Bir hata ile karşılaştık; " + e.getMessage(), "Bilinmeyen Bir Hata", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String readFile(String fileName, String fileParh){
        try{
            JOptionPane.showConfirmDialog(null, "Dosya başarıyla açıldı", "Dosya Açık", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            String result = "";
            Scanner sc = new Scanner(new File(fileParh.concat("\\".concat(fileName))));
            while(sc.hasNextLine()){
//                if(sc.hasNext("\n")){
//                    result += "\n";
//                }
                result += sc.nextLine().concat(" ");
                result += "\n";
            }
            sc.close();
            return result;
        } catch(FileNotFoundException e){
            JOptionPane.showConfirmDialog(null, "Bir hata ile karşılaştık; " + e.getMessage(), "Bilinmeyen Bir Hata", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            return "Error";
        }
    }
    
    public void writetingFile(String fileName, String fileParh, String mes){
        try(BufferedWriter write = new BufferedWriter(new FileWriter(new File(fileParh.concat("\\".concat(fileName))),StandardCharsets.UTF_8,true))){
            write.write(mes);
            write.close();
        } catch(IOException e){
            JOptionPane.showConfirmDialog(null, "Bir hata ile karşılaştık; " + e.getMessage(), "Bilinmeyen Bir Hata", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteFile(String fileName, String fileParh){
        file = new File(fileParh.concat("\\".concat(fileName)));
        if(file.delete()){
            JOptionPane.showConfirmDialog(null, "Dosya başarıyla silindi", "Dosya Silme", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showConfirmDialog(null, "Dosya silinemedi", "Dosya Silme", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
}
