    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author d119322
 */
public class Animal extends Especie {
    
    private String nome_animal;
    private int idade_animal;
    private String sexo_animal;
    private Cliente cliente;
    private ArrayList<Model.Tratamento> dadosTratamento;
     
    
    public Animal(String[] dados){
    
    nome_animal = dados[0];
    idade_animal = Integer.parseInt(dados[1]);
    sexo_animal = dados[2];
    this.setEspecie(dados[3]);
   dadosTratamento = new ArrayList<>();
    }


    public String[] Ret_Animal(){
        String[] dados = new String[4];
        
        dados[0]= nome_animal;
        dados[1] = String.valueOf(idade_animal);
        dados[2] = sexo_animal;
        dados[3] = this.getEspecie();
        return dados;
       
    }
    
    public String Con_Animal(){
        return nome_animal;
    }
    
    public ArrayList<Tratamento> Vis_Trat(){
        return dadosTratamento;
    }
    
    public void setTratamento(Tratamento trat){
        dadosTratamento.add(trat);
    }
    
}
