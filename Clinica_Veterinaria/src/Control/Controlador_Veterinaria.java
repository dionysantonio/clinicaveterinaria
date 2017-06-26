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
import java.lang.NullPointerException;

/**
 *
 * @author d119322
 */
public class Controlador_Veterinaria {

private ArrayList<Model.Cliente> dadosCliente;
private ArrayList<Model.Veterinario> dadosVeterinario;
private SimpleDateFormat formato;

public Controlador_Veterinaria(){
    
    dadosCliente = new ArrayList<>();
    dadosVeterinario = new ArrayList<>();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
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
    
    try{
    auxiliarAnimal = retornaCliente(cliente).Vis_Animal();
    
    i = auxiliarAnimal.iterator();
    auxAnimal = auxiliarAnimal.get(0);
    
    while (i.hasNext()){
        
        try{
          
            aux = auxAnimal.Con_Animal();
            if( aux.equals(nome)){
                dados = auxAnimal.Ret_Animal();
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
                dados = auxAnimal.Ret_Animal();
    }catch(java.lang.Exception e){
        
    }
    return dados;
}

public Model.Animal retornaAnimal(String cliente,String nome){
    
    Iterator<Model.Animal> i;
    Model.Animal auxAnimal;
    String[] dados = new String[20];
    String aux;
    int n =0;
    ArrayList<Model.Animal> auxiliarAnimal;
    
    auxiliarAnimal = retornaCliente(cliente).Vis_Animal();
    
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
    
   Model.Cliente novoCliente = new Model.Cliente();
   novoCliente.Reg_Cli(dados);
   dadosCliente.add(novoCliente);
}   

public String[] consultaCliente(String nome){
    
    Iterator<Model.Cliente> i;
    Model.Cliente auxCliente;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    i = dadosCliente.iterator();
    try{
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
    }catch(java.lang.Exception e){
        auxCliente = null;
    }
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

public void writeConsulta(String cliente,String animal,String data,String historico, String veterinario){
    
    String[] dados;
    
    dados = new String[]{(data),historico};
    
   Model.Consulta novoConsulta = new Model.Consulta(dados,retornaVeterinario(veterinario));
   retornaTratamento(cliente,animal).Lis_Con().add(novoConsulta);
}


public void writeConsulta(String cliente,String animal,String data,String historico, String veterinario, String des_exame){
    
    String[] dados;
    Model.Exame exame = new Model.Exame();
    
    exame.setExame(des_exame);
    

    
    dados = new String[]{(data),historico};
    
   Model.Consulta novoConsulta = new Model.Consulta();
   novoConsulta.Reg_Con(dados,retornaVeterinario(veterinario),exame);
   retornaTratamento(cliente,animal).Lis_Con().add(novoConsulta);
}

public String[] consultaConsulta(ArrayList<Model.Consulta> dadosConsulta, String nome){
    
    Iterator<Model.Consulta> i;
    Model.Consulta auxConsulta;
    String[] dados = new String[20];
    String[] aux;
    int n =0;
    
    i = dadosConsulta.iterator();
    auxConsulta = dadosConsulta.get(0);
    
    while (i.hasNext()){
        
        try{
          
            aux = auxConsulta.Ver_Con();
            if( aux.equals(nome)){
                dados = auxConsulta.Ver_Con();
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
                dados = auxConsulta.Ver_Con();
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
    
    try{
    
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
    
    }catch(java.lang.Exception e){
        
    }        
    return dados;
}

public Model.Veterinario retornaVeterinario(String nome){
    
    Iterator<Model.Veterinario> i;
    ArrayList<Model.Veterinario> auxiliarVet;
    Model.Veterinario auxVeterinario;
    String[] dados = new String[20];
    String aux;
    int n =0;
    
    auxiliarVet = dadosVeterinario;
    
    try{
    
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

            if( auxVeterinario.Ver_Vet().equals(nome)){
                
            } else{
                auxVeterinario= null;
            }
     }catch(java.lang.Exception e){
         auxVeterinario= null;
     }
    return auxVeterinario;
}

public void writeTratamento(String cliente,String animal,Date inicio, Date fim){
    
      
    
   Model.Tratamento novoTratamento = new Model.Tratamento();
   novoTratamento.Reg_Trat(inicio,fim);

   retornaAnimal(cliente,animal).setTratamento(novoTratamento);
   
}

public Model.Tratamento retornaTratamento(String cliente, String animal){//retorna ultimo
    
    Iterator<Model.Tratamento> i;
    Model.Tratamento auxTratamento;
    String[] dados = new String[20];
    Date aux = new Date();
    int n =0;
    ArrayList<Model.Tratamento> auxiliarTrat;
    
    auxiliarTrat = retornaAnimal(cliente,animal).Vis_Trat();
    
    try{
    
    i = auxiliarTrat.iterator();
    auxTratamento = auxiliarTrat.get(0);
    
    while (i.hasNext()){

                auxTratamento = i.next();
            
    }
    
    }catch(java.lang.Exception e){
        auxTratamento = null;
    }
      return auxTratamento;     
    


}
public boolean consultaTratamento(String cliente, String animal,Date data){//retorna ultimo
    
    Iterator<Model.Tratamento> i;
    Model.Tratamento auxTratamento;
    String[] dados = new String[20];
    Date[] aux;
    int n =0;
    ArrayList<Model.Tratamento> auxiliarTrat;
   
    
    auxiliarTrat = retornaAnimal(cliente,animal).Vis_Trat();
    
    try{
   
    
    i = auxiliarTrat.iterator();

    auxTratamento = auxiliarTrat.get(0);

     
    while (i.hasNext()){

                    
        try{

                aux = auxTratamento.Con_trat();

                if( ((aux[0]).before(data))&&((aux[1]).after(data))){//before testa se a data esta depois da data inicio do tratamento e after testa se a data está antes da data fim do tratamento, ou seja, testa se a data esta entre a data inicio e fim.
                   
                    return true;
                }else{
                    auxTratamento = i.next();
                }

            }catch(ArrayIndexOutOfBoundsException e){
                    return false;
                    //System.out.println(bCidade.RetornarRegiao());
            }
            
            
        }
    
        aux = auxTratamento.Con_trat();
                
                if( ((aux[0]).before(data))&&((aux[1]).after(data))){
                    System.out.println("Ok");
                    return true;
                    
                }else{
                    return false;
                }
    }catch(java.lang.Exception e){
        return false;
    }
}

public String[][] tabelaVeterinario(){
    
    Iterator<Model.Veterinario> i;
    String[][] dados = new String[20][3];
    Model.Veterinario auxVeterinario;
    int n;
    
    i = dadosVeterinario.iterator();
    auxVeterinario = dadosVeterinario.get(0);
    
    for(n=0;i.hasNext();n++){
        auxVeterinario = i.next();//traz o primeiro elemento
        dados[n]=auxVeterinario.Lis_Vet();
         
    }
        dados[n]=auxVeterinario.Lis_Vet();
    return dados;
}

public String[][] retornarAnimal(String cliente){
    
    String[][] dados = new String[20][4];
    String[] aux;
    ArrayList<Model.Animal> clienteAux;
    Iterator<Model.Animal> i;
    int n = 0;
    
    clienteAux = retornaCliente(cliente).Vis_Animal();
    
    i=clienteAux.iterator();
    aux = i.next().Ret_Animal();
    dados[n]=aux;
    n++;
    while(i.hasNext()){
        
        aux = i.next().Ret_Animal();
        dados[n]=aux;
        n++;      
        System.out.println(dados[n][0]);
        
    }
    System.out.println(dados[n][0]);
    return dados;    
    
}

}