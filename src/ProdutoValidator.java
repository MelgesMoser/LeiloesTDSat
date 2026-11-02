/** Validates and converts the values entered in the product form. */
public final class ProdutoValidator {

    private ProdutoValidator() {
    }

    public static ProdutosDTO criarProduto(String nomeInformado, String valorInformado) {
        String nome = nomeInformado == null ? "" : nomeInformado.trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do produto.");
        }

        String valorTexto = valorInformado == null ? "" : valorInformado.trim();
        if (valorTexto.isEmpty()) {
            throw new IllegalArgumentException("Informe o valor do produto.");
        }

        final int valor;
        try {
            valor = Integer.parseInt(valorTexto);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("O valor deve ser um número inteiro.", ex);
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero.");
        }

        ProdutosDTO produto = new ProdutosDTO();
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setStatus("A Venda");
        return produto;
    }
}
