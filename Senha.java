import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Senha {

    private final String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};
    private final String[] caracMin = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    int tam, op;
    String senha;

    public Senha(int op, int tam){

        if(tam < 8){
            throw new RuntimeException("Informe um tamanho acima de 8 caracteres");
        }
        if (op > 2 || op < 1){
            throw new RuntimeException("Opcao Invalida!!");
        } else{
            this.tam = tam;
            this.op = op;
        }


    }

    // Método usado para gerar o random do indice de cada caractere de acordo com o tamanho desejado
    public String geradorSenha(int tam, int op, int qtd){

        Random random = new Random();
        int i,j, indice;
        StringBuilder senha = new StringBuilder();

        if (op == 1 ){
            for(i = 0; i < qtd; i++){
                for (j = 0 ; j < tam; j++){
                    indice = random.nextInt(numeros.length);
                    senha.append(numeros[indice]);
                }
                senha.append("\n");
            }

        } else if (op == 2) {
            for (i = 0; i < qtd; i++){
                for(j = 0; j < tam; j++){
                    indice = random.nextInt(caracMin.length);
                    senha.append(caracMin[indice]);
                }
                senha.append("\n");
            }

        }

        return senha.toString();

    }

    public void salvaSenha(String resp, FileWriter escritor) throws IOException {
        escritor.write(resp);
        escritor.write("\n");
        escritor.close();

    }



}
