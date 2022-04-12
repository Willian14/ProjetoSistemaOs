/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author willian
 */
public class ModeloTabelaUsuarios extends AbstractTableModel {
    private ArrayList<Object> linhas = null;
    private  String [] colunas = null;
    
       
    public ModeloTabelaUsuarios(ArrayList lin,String [] col){
          this.linhas = lin;
          this.colunas = col;
    }
    
    public void setLinhas(ArrayList linhas){
          this.linhas = linhas;
    }
    
    public ArrayList getLinhas(){
          return linhas;
    }
    
    public void setColunas(String[] colunas){
          this.colunas = colunas;
    }
    
    public String[] getColunas(){
          return colunas;
    }
    
    public int getRowCount(){
          return linhas.size();
    }
    
    public int getColumnCount(){
          return colunas.length;
    }
    
    public String getColumnName(int numCol){
          return colunas[numCol];
    
    }
    /**
     * 
     * @param indexLinha
     * @param indexColuna
     * @return Retorna um Object com todos os dados da linha especificada pelos indexs 
     * Este método tem como finalidade obter os dados da tabela.
     */
    public Object getValueAt(int indexLinha,int indexColuna){
          Object[] linha = (Object[]) getLinhas().get(indexLinha);
          return linha[indexColuna];
    }
    
   
   
}
