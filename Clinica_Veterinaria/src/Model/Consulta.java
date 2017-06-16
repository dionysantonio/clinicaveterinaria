/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author d119322
 */
public class Consulta {
    
    private Date dat_con;
    private String historico;
    private SimpleDateFormat formato;
    
    public Consulta(String[] dados){
        
        formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
           
          dat_con =formato.parse(dados[0]);
          historico = dados[1];
          
        }catch(ParseException e){
                System.out.println("Erro na data inserida!");
        }
    }
    
    public String[] Lis_Con(){
        String[] dados = new String[5];
        
        dados[0] = formato.format(dat_con);
        dados[1] = historico;
        
        return dados;
    }
    
    public String Ver_Con(){
        return historico;
    }
    
    public int Reg_Con(){
        return 0;
    }
    
}
