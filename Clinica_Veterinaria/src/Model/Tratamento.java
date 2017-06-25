/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author d119322
 */
public class Tratamento {
    
    private Date dat_ini;
    private Date dat_fim;
    private ArrayList<Consulta> dadosConsulta;
    
    public Tratamento(Date inicio, Date fim){
        dadosConsulta = new ArrayList<>();
        dat_ini = inicio;
        dat_fim = fim;
    }
    
    private String Vis_Trat(){
        return "";
    }
    
    public Date[] Con_trat(){
        
        Date[] dados = new Date[2];
        
        
        dados[0] = dat_ini;
        dados[1] = dat_fim;
        
        return dados;
    }
    
    private int Reg_Trat(){
        return 0;
    }
    
    public ArrayList<Consulta> getConsulta(){
        return dadosConsulta;
    }
}
