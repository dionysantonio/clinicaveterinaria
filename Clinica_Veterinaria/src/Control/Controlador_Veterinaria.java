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
import java.util.HashSet;

/**
 *
 * @author d119322
 */
public class Controlador_Veterinaria {

private ArrayList<Model.Cliente> dadosCliente;
private ArrayList<Model.Veterinario> dadosVeterinario;


public Controlador_Veterinaria(){
    
    dadosCliente = new ArrayList<>();
    dadosVeterinario = new ArrayList<>();

}

public void writeAnimal(String cliente,String nome,String idade,String sexo, String especie){
    
    String[] dados;
            
    dados = new String[]{nome,idade,sexo,especie};
    
   Model.Animal novoAnimal = new Model.Animal(dados);
   retornaCliente(cliente).setAnimal(novoAnimal);
}   

public String[] consultaAnimal(String cliente,String nome){
    
    Iterator<Model.Animal> i;
    Model.Animal auxAnimal;
    String[] dados = new String[20];
    String aux;
    int n =0;
    ArrayList<Model.Animal> auxiliarAnimal;
    
    auxiliarAnimal = retornaCliente(cliente).getAnimal();
    
    i = auxiliarAnimal.iterator();
    auxAnimal = auxiliarAnimal.get(0);
    
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
            aux = auxAnimal.Con_Animal();
            if( aux.equals(nome))
                dados = auxAnimal.Vis_Animal();
    return dados;
}

public Model.Animal retornaAnimal(String cliente,String nome){
    
    Iterator<Model.Animal> i;
    Model.Animal auxAnimal;
    String[] dados = new String[20];
    String aux;
    int n =0;
    ArrayList<Model.Animal> auxiliarAnimal;
    
    auxiliarAnimal = retornaCliente(cliente).getAnimal();
    
    i = auxiliarAnimal.iterator();
    auxAnimal = auxiliarAnimal.get(0);
    
    while (i.hasNext()){
        
        try{
          
            aux = auxAnimal.Con_Animal();
            if( aux.equals(nome)){
                break;
            }else{
                auxAnimal = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxAnimal =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    aux = auxAnimal.Con_Animal();
            if( aux.equals(nome))
                return auxAnimal;
            else
                return null;
    
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
    auxCliente = dadosCliente.get(0);
    
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
    aux = auxCliente.Con_Cli();
            if( aux.equals(nome))
                dados = auxCliente.Vis_Cli();
    
    return dados;
}

public Model.Cliente retornaCliente(String nome){
    
    Iterator<Model.Cliente> i;
    Model.Cliente auxCliente;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosCliente.iterator();
    auxCliente = dadosCliente.get(0);
    
    while (i.hasNext()){
        
        try{
          
            aux = auxCliente.Con_Cli();
            if( aux.equals(nome)){
                break;
            }else{
                auxCliente = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxCliente =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    
    if(auxCliente.Con_Cli().equals(nome)){
      return auxCliente;
    }else{
      return null;    
    } 
    
}

public void writeConsulta(Model.Tratamento trata,Date data,String historico, Model.Veterinario vet){
    
    String[] dados;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    
    dados = new String[]{formato.format(data),historico};
    
   Model.Consulta novoConsulta = new Model.Consulta(dados,vet);
   trata.getConsulta().add(novoConsulta);
}


public void writeConsulta(Model.Tratamento trata,Date data,String historico, Model.Veterinario vet, String des_exame){
    
    String[] dados;
    Model.Exame exame = new Model.Exame();
    
    exame.setExame(des_exame);
    
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    
    dados = new String[]{formato.format(data),historico};
    
   Model.Consulta novoConsulta = new Model.Consulta(dados,vet,exame);
   trata.getConsulta().add(novoConsulta);
}

public String[] consultaConsulta(ArrayList<Model.Consulta> dadosConsulta, String nome){
    
    Iterator<Model.Consulta> i;
    Model.Consulta auxConsulta;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosConsulta.iterator();
    auxConsulta = dadosConsulta.get(0);
    
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
    aux = auxConsulta.Ver_Con();
            if( aux.equals(nome))
                dados = auxConsulta.Lis_Con();
    return dados;
}

public void writeVeterinario(String nome, String endereco, String telefone){
    
    String[] dados;
    
    dados = new String[]{nome,endereco,telefone};
    
   Model.Veterinario novoVeterinario = new Model.Veterinario(dados);
   dadosVeterinario.add(novoVeterinario);
}   

public String[] consultaVeterinario(String nome){
    
    Iterator<Model.Veterinario> i;
    ArrayList<Model.Veterinario> auxiliarVet;
    Model.Veterinario auxVeterinario;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    auxiliarVet = dadosVeterinario;
    
    i = auxiliarVet.iterator();
    auxVeterinario = auxiliarVet.get(0);
    
            //condicao para verificar se é o primeiro
    // auxVeterinario = i.next();        
           
    
    while (i.hasNext()){
        
        try{
          
            aux = auxVeterinario.Ver_Vet();
            
            if( aux.equals(nome)){
                dados = auxVeterinario.Lis_Vet();
                n++;
                auxVeterinario =  i.next();
            }else{
                auxVeterinario = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxVeterinario =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    aux = auxVeterinario.Ver_Vet();

            if( aux.equals(nome)){
                dados = auxVeterinario.Lis_Vet();
            } 
     
    return dados;
}

public void writeTratamento(Model.Animal animal,Date inicio, Date fim){
    
      
    
   Model.Tratamento novoTratamento = new Model.Tratamento(inicio,fim);
   animal.getTratamento().add(novoTratamento);
}

public Model.Tratamento retornaTratamento(ArrayList<Model.Tratamento> trat, Date inicio){
    
    Iterator<Model.Tratamento> i;
    Model.Tratamento auxTratamento;
    String[] dados = new String[20];
    Date aux = new Date();
    int n =0;
    
    i = trat.iterator();
    auxTratamento = i.next();
    
    while (i.hasNext()){
        
        try{
          
            aux = auxTratamento.Con_trat();
            if( aux.equals(inicio)){
                break;
            }else{
                auxTratamento = i.next();
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
                auxTratamento =  i.next();
                //System.out.println(bCidade.RetornarRegiao());
        }
        
    }
    
    if(i.hasNext()){
      return null;
    }else{
      return (Model.Tratamento) i;    
    } 
    
}

}
