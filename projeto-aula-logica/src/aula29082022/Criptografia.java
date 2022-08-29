package aula29082022;

public class Criptografia {

    // Exercicio 11.23 da Apostila de Exercicios
    //Escreva a classe Criptografia, que conterá alguns métodos estáticos para codificação e
    //decodificação de strings.
    //
    // Escreva nessa classe o método codificaRot13, que receberá
    //uma string como argumento e retornará uma string codificada com o algoritmo rot13, que
    //substitui cada caracter da string pelo valor do caracter mais treze,
    // subtraindo vinte e seis caso o resultado seja maior que a última letra,
    // de forma que “abCde” seja substituída por
    //“noPqr”, “kLmnoPq” seja substituída por “xYzabCd”, e “UVWxyz” seja substituída por
    //“HIJklm”.
    // Somente os caracteres alfabéticos não-acentuados devem ser modificados.
    // Por exemplo, se a string “Revolução de 1930” for passada como argumento para esse método,
    // ele retornará “Eribyhçãb qr 1930”.
    //
    // Uma característica interessante do algoritmo
    // rot13 é que, se uma string codificada por ele for passada de novo pelo próprio algoritmo, a
    //string original será retornada.
    //
    // Escreva também um método decodificaRot13 que seja
    //somente uma chamada para o método codificaRot13.

    public static void main(String[] args) {

        String textoCriptografado = codificaRot13("joao");
        System.out.println("Texto criptografado: " + textoCriptografado);
//        System.out.println("Texto criptografado: " + codificaRot13("pedro"));
//        System.out.println("Texto criptografado: " + codificaRot13("maria"));
//        System.out.println("Texto criptografado: " + codificaRot13("yasmim"));
//        System.out.println("Texto criptografado: " + codificaRot13("alex"));
//        System.out.println("Texto criptografado: " + codificaRot13("gelvazio"));
//

        System.out.println("Texto descriptografado: " + decodificaRot13(codificaRot13(textoCriptografado)));
    }

    public static String codificaRot13(String texto){

        System.out.print(" Palavra inicial:" + texto + " ");

        String texto_criptografado_final = "";

        // vetor com o alfabeto
        String [] alfabeto = {
                "a","b","c","d","e","f",
                "g","h","i","j","k","l",
                "m","n","o","p","q","r",
                "s","t","u","v","w","x",
                "y","z"
        };

        // vetopr com otexto criptografado
        int tamanhoVetor = texto.length();

        String texto_criptografado [] = new String[tamanhoVetor];

        for(int j = 0; j < texto.length(); j++){
            char letra = texto.charAt(j);

            // System.out.println("Letra do texto a criptografar:" + letra);

            // encontrar a posicao da letra no vetor do alfabeto
            for(int i = 0; i < alfabeto.length;i++){
                String letra_alfabeto = alfabeto[i];
                // System.out.println("letra:" + letra_alfabeto + " posicao:" + i);

                String letra_string = String.valueOf(letra);

                if(letra_alfabeto.equals(letra_string)){
                    //System.out.println("posicao da letra " + letra_string.toUpperCase() + " no alfabeto:" + i);

                    // Algoritom de ROT
                    int nova_posicao = i + 13;

                    if(nova_posicao >= 26){
                        nova_posicao = nova_posicao - 26;
                    }

                    String nova_letra = alfabeto[nova_posicao];

                    //System.out.println("Nova letra criptografada:" + nova_letra);
                    texto_criptografado_final = texto_criptografado_final + nova_letra;
                }
            }
        }

        return texto_criptografado_final;
    }

    public static String decodificaRot13(String texto){
        String texto_descriptografado = "";


        System.out.print(" Palavra inicial:" + texto + " ");

        String texto_descriptografado_final = "";

        // vetor com o alfabeto
        String [] alfabeto = {
                "a","b","c","d","e","f",
                "g","h","i","j","k","l",
                "m","n","o","p","q","r",
                "s","t","u","v","w","x",
                "y","z"
        };

        // vetopr com otexto criptografado
        int tamanhoVetor = texto.length();

        String texto_criptografado [] = new String[tamanhoVetor];

        for(int j = 0; j < texto.length(); j++){
            char letra = texto.charAt(j);

            // System.out.println("Letra do texto a criptografar:" + letra);

            // encontrar a posicao da letra no vetor do alfabeto
            for(int i = 0; i < alfabeto.length;i++){
                String letra_alfabeto = alfabeto[i];
                // System.out.println("letra:" + letra_alfabeto + " posicao:" + i);

                String letra_string = String.valueOf(letra);

                if(letra_alfabeto.equals(letra_string)){
                    //System.out.println("posicao da letra " + letra_string.toUpperCase() + " no alfabeto:" + i);

                    // Algoritmo de ROT
                    int nova_posicao = i - 13;

                    if(nova_posicao < 0){
                        nova_posicao = nova_posicao + 13;
                    }

                    String nova_letra = alfabeto[nova_posicao];

                    //System.out.println("Nova letra criptografada:" + nova_letra);
                    texto_descriptografado_final = texto_descriptografado_final + nova_letra;
                }
            }
        }

        return texto_descriptografado_final;
    }
}


