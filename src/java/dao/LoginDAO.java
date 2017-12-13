/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Login;
import modelo.ProdutoAbaixoDoEstoque;

/**
 *
 * @author Erlandson
 */
public class LoginDAO {
    
    private final Connection conexao;

    public LoginDAO() {
        this.conexao = Conecta.getInstance().getConnection();
    }

    
    public List<Login> retornaLogin(){
        
        String sql = "select * from usuario where senha != NULL OR senha != ''";
        List<Login> logins;
        logins = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Login login = new Login();

                login.setUsuario(rs.getString("nome"));
                login.setSenha(rs.getString("senha"));
                System.out.println(login);

                logins.add(login);
                System.out.println(logins);
            }

        } catch (SQLException e) {

            throw new RuntimeException();
        }

        return logins;   
}
}