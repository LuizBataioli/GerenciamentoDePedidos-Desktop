package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cadastro;
import model.CadastroDAO;

public class CadastroController {
    
    
    private CadastroDAO cadastroDAO;
    
    public CadastroController() {
        this.cadastroDAO = new CadastroDAO();
    }
    
    public boolean addCadastro(String nome, String descricao,String valor) throws SQLException {
        
        if (nome.isEmpty() || descricao.isEmpty() || valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false;
        } else {
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(nome);
            cadastro.setDescricao(descricao);
            cadastro.setValor(valor);
            
            
            cadastroDAO.addCadastro(cadastro);
            JOptionPane.showMessageDialog(null, "Cadastro incluído com sucesso!");
            return true;
        }
    }
    
    public List<Cadastro> searchCadastrosByName(String name) throws SQLException {
        return cadastroDAO.searchCadastrosByName(name);
    }
    
    public void updateCadastro(Cadastro cadastro) throws SQLException {
        cadastroDAO.updateCadastro(cadastro);
    }
    
    public void deleteCadastro(int id) throws SQLException {
        cadastroDAO.deleteCadastro(id);
    }
    
}
