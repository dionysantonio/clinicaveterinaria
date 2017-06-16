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
public class Veterinario {
    private String nom_vet;
    private String end_vet;
    private String tel_vet;
    
    
    public Veterinario(String[] dados){
        
        nom_vet = dados[0];
        end_vet = dados[1];
        tel_vet = dados[2];
        
    }
    
    public String[] Lis_Vet(){
        String[] dados = new String[3];
        
        dados[0] = nom_vet;
        dados[1] = end_vet;
        dados[2] = tel_vet;
        
        return dados;
    }
    
    public String Ver_Vet(){
        return nom_vet;
    }
    
    
}
