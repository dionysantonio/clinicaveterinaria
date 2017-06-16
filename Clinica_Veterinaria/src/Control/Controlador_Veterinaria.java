/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author d119322
 */
public class Controlador_Veterinaria {
private ArrayList<Model.Animal> dadosAnimal;
private ArrayList<Model.Cliente> dadosCliente;
private ArrayList<Model.Consulta> dadosConsulta;
private ArrayList<Model.Exame> dadosExame;
private ArrayList<Model.Veterinario> dadosVeterinario;
private ArrayList<Model.Tratamento> dadosTratamento;

public Controlador_Veterinaria(){
    dadosAnimal = new ArrayList<>();
    dadosCliente = new ArrayList<>();
    dadosConsulta = new ArrayList<>();
    dadosExame = new ArrayList<>();
    dadosVeterinario = new ArrayList<>();
    dadosTratamento = new ArrayList<>();
}

public void writeAnimal(String nome,String idade,String sexo){
    
    String[] dados;
            
    dados = new String[]{nome,idade,sexo};
    
   Model.Animal novoAnimal = new Model.Animal(dados);
   dadosAnimal.add(novoAnimal);
}   

public String[] consultaAnimal(String nome){
    
    Iterator<Model.Animal> i;
    Model.Animal auxAnimal;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosAnimal.iterator();
    auxAnimal = i.next();
    
    while (i.hasNext()){
        
        try{
          
            aux = auxAnimal.Con_Animal();
            if( aux.equals(nome)){
                dados = auxAnimal.Vis_Animal();
                n++;
                auxAnimal =  i.next();
            }else{
                auxAnimal = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxAnimal =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    return dados;
}

public void writeCliente(String nome,String endereco,String telefone,int cep,String email){
    
    String[] dados;
            
    dados = new String[]{nome,endereco,telefone,Integer.toString(cep),email};
    
   Model.Cliente novoCliente = new Model.Cliente(dados);
   dadosCliente.add(novoCliente);
}   

public String[] consultaCliente(String nome){
    
    Iterator<Model.Cliente> i;
    Model.Cliente auxCliente;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosCliente.iterator();
    auxCliente = i.next();
    
    while (i.hasNext()){
        
        try{
          
            aux = auxCliente.Con_Cli();
            if( aux.equals(nome)){
                dados = auxCliente.Vis_Cli();
                n++;
                auxCliente =  i.next();
            }else{
                auxCliente = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxCliente =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    return dados;
}

public void writeConsulta(Date data,String historico){
    
    String[] dados;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    
    dados = new String[]{formato.format(data),historico};
    
   Model.Consulta novoConsulta = new Model.Consulta(dados);
   dadosConsulta.add(novoConsulta);
}   

public String[] consultaConsulta(String nome){
    
    Iterator<Model.Consulta> i;
    Model.Consulta auxConsulta;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosConsulta.iterator();
    auxConsulta = i.next();
    
    while (i.hasNext()){
        
        try{
          
            aux = auxConsulta.Ver_Con();
            if( aux.equals(nome)){
                dados = auxConsulta.Lis_Con();
                n++;
                auxConsulta =  i.next();
            }else{
                auxConsulta = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxConsulta =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    return dados;
}

}
