import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class janela {

    public static void main(String[] args) throws IOException {
        int op, tam, qtd;
        String resp = "";
        Scanner scanner = new Scanner(System.in);
        FileWriter escritor = new FileWriter("senha.txt", true);
        while (true) {
            System.out.println("|_________________|");
            System.out.println("| 1 - Numeros     |");
            System.out.println("| 2 - Letras      |");
            System.out.println("|_________________|");
            System.out.println("Informe a opcao: ");
            op = scanner.nextInt();

            if (op == 1 || op == 2){
                System.out.println("Informe o tamanho: ");
                tam = scanner.nextInt();

                System.out.println("Informe a quantidade de senha: ");
                qtd = scanner.nextInt();

                    try {

                        Senha senha = new Senha(op, tam);
                        resp = senha.geradorSenha(tam, op, qtd);
                        try{
                            senha.salvaSenha(resp, escritor);
                        } catch (IOException e) {
                           // throw new RuntimeException(e);
                            System.out.println("Erro ao escrever no arquivo");
                        }

                    }
                    catch (RuntimeException e){
                       System.out.println(e.getMessage());
                    }
                System.out.println(resp);
            }else{
                System.out.println("Opcao Invalida!!");
                return;
            }

        }

    }
}
