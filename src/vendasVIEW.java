import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/** Window that displays products whose database status is "Vendido". */
public class vendasVIEW extends JFrame {

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Nome", "Valor", "Status"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JLabel statusLabel = new JLabel(" ");

    public vendasVIEW() {
        setTitle("Vendas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Produtos Vendidos", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(20f));
        add(title, BorderLayout.NORTH);

        JTable salesTable = new JTable(model);
        salesTable.setFillsViewportHeight(true);
        add(new JScrollPane(salesTable), BorderLayout.CENTER);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(event -> dispose());
        JPanel footer = new JPanel(new BorderLayout(8, 0));
        footer.add(statusLabel, BorderLayout.CENTER);
        footer.add(backButton, BorderLayout.EAST);
        add(footer, BorderLayout.SOUTH);

        setMinimumSize(new Dimension(640, 380));
        pack();
        setLocationRelativeTo(null);
        carregarVendas();
    }

    private void carregarVendas() {
        try {
            List<ProdutosDTO> vendidos = new ProdutosDAO().listarProdutosVendidos();
            model.setRowCount(0);
            for (ProdutosDTO produto : vendidos) {
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()
                });
            }
            statusLabel.setText(vendidos.isEmpty()
                    ? "Nenhum produto vendido."
                    : "Produtos vendidos: " + vendidos.size());
        } catch (SQLException erro) {
            statusLabel.setText("Falha ao carregar as vendas.");
            JOptionPane.showMessageDialog(this,
                    "Não foi possível carregar os produtos vendidos. Verifique a conexão com o banco de dados.\n"
                    + erro.getMessage(),
                    "Falha na consulta de vendas", JOptionPane.ERROR_MESSAGE);
        }
    }
}
