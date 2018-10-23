package Principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon dos Santos
 * @author Gabriel Godoy
 * 
 */
public class TP_LPG {
    
    //Propriedades Privadas
    //Constante das opções de Menu
    private static final String OPCOES[] = new String[]{"1 - Listar Itens",
                                                        "2 - Incluir Item",
                                                        "3 - Alterar Item",
                                                        "4 - Excluir Item",
                                                        "5 - Sair"};
    //Constante das Propriedades da Conta
    private static final String PROPIEDADE_CONTA[] = new String[]{"Nome", "Valor", "Data de Pagamento"};
    //Variavel ArrayList para Contas
    private static ArrayList<String[]> Contas = new ArrayList<String[]>();
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao = 0;
        do {
            opcao = Menu();
            CarregarOpcao(opcao);
        } while (opcao != 5);
    }
    
//region Métodos para Interação com o Usuário
    
    //Apresenta Menu e Valida Opção
    public static int Menu(){
        int opcao = -1;
        //laço para Validação da Opção
        do {
            String saida = "Cadastro de Contas a Pagar - Menu\n";
            //Laço para Ler Array opcoes
            for (int i = 0; i < OPCOES.length; i++) {
                saida += OPCOES[i] + "\n";
            }
            saida += "Escolha uma Opção";
            String entrada = JOptionPane.showInputDialog(saida);
            //Verifica se for null (usuário Cancelou ação) atribui 5
            //senão opcao recebe o Valor convertido ou -1 em caso de erro
            opcao = entrada == null ? 5 : TryParseInt(entrada);
            //valida se é uma opção verdadeira    
            if (opcao >= 1 && opcao <= OPCOES.length) {
                //caso verdadeira sai do laço
                break;
            }
            //exibe mensagem somente se o if falhar
            JOptionPane.showMessageDialog(null, "Opção Inválida!\n");
        } while (opcao < 1 || opcao > OPCOES.length);
        //retorna o valor da opcao
        return opcao;
    }
    //Ler os dados de uma conta e retorna um Array
    public static String[] LerConta(){
        String conta[] = new String[3];
        for (int i = 0; i < conta.length; i++) {
            String entrada = JOptionPane.showInputDialog(String.format("Digite o %s da Conta", PROPIEDADE_CONTA[i]));
            conta[i] = entrada;
        }
        return conta;
    }
    
//endregion
    
//region Métodos Uteis
    
    //Método para Tentar Converter uma String para Inteiro
     public static int TryParseInt(String entrada){
        int retorno = 0;
        //Tenta a Conversão
        try{
            //Armazena Resultado em Retorno
            retorno = Integer.parseInt(entrada);
        }
        //Captura Erro de Conversão
        catch(NumberFormatException ex){
            retorno = -1;
        }
        return retorno;
    }
     
     public static float TryParseFloat(String entrada){
         entrada = entrada.replace(',', '.');
         return Float.parseFloat(entrada);
     }
     
     //Método para Executar a Opcao selecionada
     public static void CarregarOpcao(int opcao){
         switch (opcao) {
             case 1:
                 ListarItens();
                 break;
             case 2:
                 Incluir();
                 break;
             case 3:
                 //TODO Alterar();
                 break;
             case 4:
                 //TODO Excluir();
                 break;
             case 5:
                 JOptionPane.showMessageDialog(null, "Até Mais! o/");
                 break;
             default:
                 throw new AssertionError();
         }
     }
     
//endregion
     
//region Métodos de Controle
     
     public static void ListarItens(){
         String saida = "";
         for (int i = 0; i < Contas.size(); i++) {
            saida += String.format("%s", Contas.get(i)[0]);
            saida += String.format(" | R$%.2f", TryParseFloat(Contas.get(i)[1]));
            saida += String.format(" | %s\n", Contas.get(i)[2]);
         }
         JOptionPane.showMessageDialog(null, saida);
     }
     
     public static void Incluir(){
         String conta[] = LerConta();
         Contas.add(conta);
     }
//endregion
}
