/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.DAO;

import br.com.wbs.connection.ConnectionFactory;
import br.com.wbs.entity.Usuario;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author willian
 */
public class UsuarioDAO {

    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    private Connection con;
    private PreparedStatement preparador = null;
    private ResultSet rs = null;
    private List<Usuario> lista = null;

    public void cadastrar(Usuario usu) {

        String sql = "insert into tbusuarios(usuario,fone,login,senha,tipo,celular) values"
                + "(?,?,?,?,?,?);";
        try {
            preparador = con.prepareStatement(sql);
            preparador.setString(1, usu.getNome());
            preparador.setString(2, usu.getFone());
            preparador.setString(3, usu.getLogin());
            preparador.setString(4, usu.getSenha());
            preparador.setString(5, usu.getTipo());
            preparador.setString(6, usu.getCelular());
            preparador.execute();
            preparador.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso!", 1);

        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário ao banco de dados!", "Atenção!", 2);
        }

    }

    public void alterar(Usuario usu) {
        String sql = "update tbusuarios set usuario = ?, fone = ?, login = ?, senha = ?"
                + ", tipo = ?, celular = ? where iduser = ?;";
        try {
            preparador = con.prepareStatement(sql);
            preparador.setString(1, usu.getNome());
            preparador.setString(2, usu.getFone());
            preparador.setString(3, usu.getLogin());
            preparador.setString(4, usu.getSenha());
            preparador.setString(5, usu.getTipo());
            preparador.setString(6, usu.getCelular());
            preparador.setInt(7, Integer.parseInt(usu.getId().toString()));
            preparador.execute();
            preparador.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!", "Sucesso!", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o usuário!", "Atenção!", 1);
        }
    }
    
    public void deletar(Integer id) {
        String sql = "delete from tbusuarios where iduser = ?;";

        try {
            preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean salvar(Usuario usu) {
        Usuario usuExist = logar(usu.getLogin(), usu.getSenha());
        if (usu.getId() != null) {
            if (usuExist != null) {
                if (usuExist.getLogin().equals(usu.getLogin()) || usuExist.getSenha().equals(usu.getSenha())) {
                    if (usuExist.getId().equals(usu.getId())) {
                        alterar(usu);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Esse login e/ou senha já existem no banco de dados! Por favor digite outro login e senha.",
                                "Atenção!", 1);
                    }
                }
            } else {
                alterar(usu);
                return true;
            }
        } else {
            if (usuExist != null) {
                if (usuExist.getLogin().equals(usu.getLogin()) || usuExist.getSenha().equals(usu.getSenha())) {
                    JOptionPane.showMessageDialog(null, "Esse login e/ou senha já existem no banco de dados! Por favor digite outro login e senha.",
                            "Atenção!", 1);
                }
            } else {
                cadastrar(usu);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que recebe o login e senha digitados, pesquisa se existe os mesmos
     * no banco de dados e retorna um objeto usuário com todo o conteúdo desse
     * registro.
     *
     * @param login
     * @param senha
     * @return Um objeto do tipo Usuario ou null caso não tenha usuário já cadastrado com mesmo login ou senha
     */
    public Usuario logar(String login, String senha) {
        Usuario usu;
        String sql = "select * from tbusuarios where login = ? or senha = ?;";
        try {
            //preparando consulta ao banco de dados
            preparador = con.prepareStatement(sql);
            preparador.setString(1, login);
            preparador.setString(2, senha);
            rs = preparador.executeQuery();
            //pegando o resultado da pesquisa
            if (rs.next()) {
                usu = new Usuario();
                usu.setId(new BigInteger(rs.getString("iduser")));
                usu.setNome(rs.getString("usuario"));
                usu.setFone(rs.getString("fone"));
                usu.setLogin(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getString("tipo"));

                return usu;

            }
            preparador.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList buscaParaPreencherTabela() {
        String sql = "select  * from tbusuarios;";

        ArrayList lista = new ArrayList();

        try {
            preparador = con.prepareStatement(sql);

            rs = preparador.executeQuery();

            while (rs.next()) {
                lista.add(new Object[]{rs.getString("iduser"), rs.getString("usuario"),
                    rs.getString("fone"), rs.getString("login"), rs.getString("senha"),
                    rs.getString("tipo"), rs.getString("celular")});
            }
            preparador.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

  
}
