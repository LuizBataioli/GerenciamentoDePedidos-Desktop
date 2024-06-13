package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CadastroDAO {

    public void addCadastro(Cadastro cadastro) throws SQLException {
        String sql = "INSERT INTO produtos (nome, descricao,preco) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getDescricao());
            stmt.setString(3, cadastro.getValor());
            stmt.executeUpdate();
        }
    }

    public List<Cadastro> searchCadastrosByName(String name) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            List<Cadastro> cadastros = new ArrayList<>();
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setId(rs.getInt("id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setDescricao(rs.getString("descricao"));
                cadastro.setValor("valor");
                cadastros.add(cadastro);
            }
            return cadastros;

        }

    }

    public void updateCadastro(Cadastro cadastro) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, descricao = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getDescricao());
            stmt.setInt(3, cadastro.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCadastro(int id) throws SQLException {
        String sql = "DELETE FROM produtos Where id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
