    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author d119322
 */
public class Animal {
    
    private String nome_animal;
    private int idade_animal;
    private String sexo_animal;
    private Cliente cliente;
    
    Animal(String[] dados){
    
    nome_animal = dados[0];
    idade_animal = Integer.parseInt(dados[1]);
    sexo_animal = dados[2];

    }


    public String Vis_Animal(){
        return "";
       
    }
    
    public String Con_Animal(){
        return "";
    }
    
    
}
