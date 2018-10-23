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
    //Variavel das opções de Menu
    private static String opcoes[] = new String[]{"1 - Listar Itens",
                                                  "2 - Incluir Item",
                                                  "3 - Alterar Item",
                                                  "4 - Excluir Item",
                                                  "5 - Sair"};
    //Variavel ArrayList
    private static ArrayList Contas = new ArrayList();
    
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
            for (int i = 0; i < opcoes.length; i++) {
                saida += opcoes[i] + "\n";
            }
            saida += "Escolha uma Opção";
            String entrada = JOptionPane.showInputDialog(saida);
            //Verifica se for null (usuário Cancelou ação) atribui 5
            //senão opcao recebe o Valor convertido ou -1 em caso de erro
            opcao = entrada == null ? 5 : TryParseInt(entrada);
            //valida se é uma opção verdadeira    
            if (opcao >= 1 && opcao <= opcoes.length) {
                //caso verdadeira sai do laço
                break;
            }
            //exibe mensagem somente se o if falhar
            JOptionPane.showMessageDialog(null, "Opção Inválida!\n");
        } while (opcao < 1 || opcao > opcoes.length);
        //retorna o valor da opcao
        return opcao;
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
     
     //Método para Executar a Opcao selecionada
     public static void CarregarOpcao(int opcao){
         switch (opcao) {
             case 1:
                 ListarItens();
                 break;
             case 2:
                 //TODO Incluir();
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
             saida += String.format("%s\n", Contas.get(i));
         }
         JOptionPane.showMessageDialog(null, saida);
     }
     
//endregion
}
