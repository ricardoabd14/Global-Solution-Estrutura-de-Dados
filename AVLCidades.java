package Avl;
import java.util.Scanner;

import CIDADE.Cidade;

public class AVLCidades {
    private No raiz;

    private class No {
        private String cidade;
        private No esquerda, direita;
        private int altura;

        public No(String string) {
            this.cidade = string;
            this.altura = 1;
        }
    }

    class AVLTree {
        private No raiz;

        public void inserir(String cidade) {
            raiz = inserir(raiz, cidade);
        }

      
        private No inserir(No no, String cidade) {
            if (no == null) {
                return new No(cidade);
            }

           
            int comparacao = cidade.compareTo(no.cidade);

           
            if (comparacao < 0) {
                no.esquerda = inserir(no.esquerda, cidade);
            } else if (comparacao > 0) {
                no.direita = inserir(no.direita, cidade);
            } else {
               
                return no;
            }

           
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

          
            return balancear(no);
        }

        
        private int altura(No no) {
            return (no != null) ? no.altura : 0;
        }
    }



    private int altura(No no) {
        return (no != null) ? no.altura : 0;
    }
	

    private No balancear(No no) {
      
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

      
        int fatorBalanceamento = fatorBalanceamento(no);

      
        if (fatorBalanceamento > 1 && fatorBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
       
        if (fatorBalanceamento < -1 && fatorBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
       
        if (fatorBalanceamento > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
       
        if (fatorBalanceamento < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

       
        return no;
    }

    
    private int fatorBalanceamento(No no) {
        return (no != null) ? altura(no.esquerda) - altura(no.direita) : 0;
    }
	

	private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

       
        x.direita = y;
        y.esquerda = T2;

       
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        
        y.esquerda = x;
        x.direita = T2;

       
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public Cidade inserirCidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da cidade: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a cobertura vacinal (%): ");
        double coberturaVacinal = scanner.nextDouble();

        System.out.println("Digite o número de casos registrados: ");
        int casosRegistrados = scanner.nextInt();

        Cidade novaCidade = new Cidade(nome, coberturaVacinal, casosRegistrados);
        inserir(novaCidade);

        System.out.println("Cidade inserida com sucesso!");

       
        scanner.close();

        
        return novaCidade;
    }

	public void inserir(Cidade novaCidade) {
		// TODO Auto-generated method stub
		
	}

	 
	}

    
