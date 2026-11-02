import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public boolean cadastrarProduto(ProdutosDTO produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getValor());
            statement.setString(3, produto.getStatus());
            return statement.executeUpdate() == 1;
        }
    }

    public List<ProdutosDTO> listarProdutos() throws SQLException {
        String sql = "SELECT id, nome, valor, status FROM produtos ORDER BY id";
        List<ProdutosDTO> produtos = new ArrayList<>();

        try (Connection conn = new conectaDAO().connectDB();
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(results.getLong("id"));
                produto.setNome(results.getString("nome"));
                produto.setValor(results.getInt("valor"));
                produto.setStatus(results.getString("status"));
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
