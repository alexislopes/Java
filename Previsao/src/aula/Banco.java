package aula;

import xml.Cidade;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private Connection conexao;


    public Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        File bd = new File("bdprevisao.db");
        /* verifica se o arquivo do BD existe na raiz do projeto */
        if (!bd.exists()) {
            /* cria o arquivo do BD na raiz do projeto e cria uma conexão para o BD */
            conexao = DriverManager.getConnection("jdbc:sqlite:bdprevisao.db");
            /* como o BD não existe então é necessário criar as tabelas */
            createTableCidade();
            createTablePrevisao();
        } else {
            /* cria uma conexão com o BD */
            conexao = DriverManager.getConnection("jdbc:sqlite:bdprevisao.db");
        }
        conexao.setAutoCommit(false);
        System.out.println("conectado!");
        return conexao;

    }

    public boolean createTablePrevisao() throws SQLException {
        System.out.println("Criando tabela tbprevisao...");
        Statement stmt = conexao.createStatement();
        String sql = "create table if not exists tbprevisao( " +
                "id varchar(4) not null," +
                "dia date not null," +
                "tempo char(3) not null," +
                "minima float not null," +
                "maxima float not null," +
                "iuv float not null," +
                "primary key (id, dia)," +
                "foreign key (id) references tbcidade(id) " +
                ")";
        stmt.executeUpdate(sql);
        stmt.close();
        System.out.println("tbprevisao criada");
        return true;
    }

    public boolean createTableCidade() throws SQLException {
        System.out.println("Criando tabela tbcidade...");
        Statement stmt = conexao.createStatement();
        String sql = "create table if not exists tbcidade( " +
                "id varchar(4) not null primary key," +
                "nome varchar(80) not null," +
                "uf char(2) not null," +
                "atualizacao DATE" +
                ")";
        stmt.executeUpdate(sql);
        stmt.close();
        System.out.println("tbcidade criada");
        return true;
    }


    public boolean insertCidade(CidadeReal cidade) throws SQLException {
        //o campo atualizacao irá receber o valor padrão, ou seja, null
        String sql = "insert or ignore into tbcidade(id,nome,uf) values(?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cidade.getId());
            stmt.setString(2, cidade.getNome());
            stmt.setString(3, cidade.getUf());
            stmt.execute();
            stmt.close();
            conexao.commit();
            System.out.println("Salvo no BD");
        }catch(SQLException e ){
            System.err.println(e.getMessage());

        }
        return true;
    }


    public List<CidadeReal> selectCidade(String sql) throws SQLException {
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<CidadeReal> lista = new ArrayList<>();
        CidadeReal cidade;
        while (rs.next()) {
            cidade = new CidadeReal();
            cidade.setId(rs.getString("id"));
            cidade.setNome(rs.getString("nome"));
            cidade.setUf(rs.getString("uf"));
            //cidade.setAtualizacao(rs.getString("atualizacao"));
            lista.add(cidade);
        }
        //for(CidadeReal cidadeReal : lista){
        //    System.out.println(cidadeReal);
        //}
        rs.close();
        stmt.close();
        conexao.commit();
        return lista;
    }
}
