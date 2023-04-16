import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    // atributos
    static Scanner entrada = new Scanner(System.in);
    private static List<Imovel> listImoveis;
    static Calendar c = Calendar.getInstance();

    // metodos
    public static String buscar_e_imprimirPorAno(int anoDaBusca) {
        if (anoDaBusca >= 1950 && anoDaBusca <= c.get(Calendar.YEAR)) {
            for (Imovel cadaImovel : listImoveis) {
                if (anoDaBusca == cadaImovel.getAnoConstrucao()) {
                    return cadaImovel.toString();
                }
            }
        }
        return "";
    }

    /**
     * Metodo para mostrar ganho total com todos os imoveis
     */
    public static double mostrarGanhoComTodosImoveis() {
        double somaTotal = 0;
        for (Imovel cadaImovel : listImoveis) {
            somaTotal += cadaImovel.calcularComissaoPorAluguel();
        }
        return somaTotal;
    }

    public static int mostrarOpcoes() {
        System.out.println("");
        System.out.println("IMOBILIARIA XULAMBS");
        System.out.println("==========================");
        System.out.println("1 - CRIAR IMOVEL");
        System.out.println("2 - TUDO SOBRE O IMOVEL");
        System.out.println("3 - MOSTRAR TODOS IMOVEIS");
        System.out.println("4 - MOSTRAR GANHOS TOTAIS");
        System.out.println("5 - BUSCAR IMOVEIS POR ANO");

        System.out.println("0 - SAIR");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());

        return opcao;
    }

    public static int mostrarOpcoesDeImovel() {
        System.out.println("");
        System.out.println("TUDO SOBRE O IMOVEL");
        System.out.println("==========================");
        System.out.println("1 - ADICIONAR ACRÉSCIMOS");
        System.out.println("2 - MOSTRAR TODOS ACRÉSCIMOS");
        System.out.println("3 - MOSTRAR VALOR IMOVEL");
        System.out.println("4 - CALCULAR COMISSAO POR PROPRIEDADE");
        System.out.println("5 - VALOR BRUTO POR PROPRIEDADE");
        System.out.println("6 - VALOR LIQUIDO POR PROPRIEDADE");
        System.out.println("7 - ATUALIZAR IMOVEL");
        System.out.println("8 - REMOVER IMOVEL");

        System.out.println("0 - SAIR");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());

        return opcao;
    }

    public static int subTipoImovel() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("1 - APARTAMENTO");
        System.out.println("2 - CASA");
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static int subEscolherImovel() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("Veja os IDs e escolha o imovel: ");
        imprimirTodosImoveis();
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static int subAdicionarAcrescimo() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("1 - adicionar mais um");
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static int escolherCampoParaAlterar_Ape() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("Veja os campos e escolha um para alterar: ");
        System.out.println("1 - Valor de venda");
        System.out.println("2 - Endereço");
        System.out.println("3 - Ano de construção");
        System.out.println("4 - Taxa mensal de condomínio");

        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static int escolherCampoParaAlterar_Casa() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("Veja os campos e escolha um para alterar: ");
        System.out.println("1 - Valor de venda");
        System.out.println("2 - Endereço");
        System.out.println("3 - Ano de construção");
        System.out.println("4 - Valor anual do seguro");

        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static int subEscolherAnoDeBusca() {
        System.out.println("");
        System.out.println("==========================");
        System.out.println("Escolha um ANO entre 1950 e " + c.get(Calendar.YEAR));
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        return opcao;
    }

    public static Imovel criarNovoImovel(int opcao) {
        Imovel novoImovel = null;
        if (opcao == 1) {
            System.out.println("Digite o valor da venda do imovel:");
            double valorVenda = entrada.nextDouble();
            clearBuffer(entrada);
            System.out.println("Digite o endereço do imovel:");
            String endereco = entrada.nextLine();
            System.out.println("Digite o ano de construção:");
            int anoConst = entrada.nextInt();
            clearBuffer(entrada);
            System.out.println("Digite a taxa mensal do condominio:");
            double taxa = entrada.nextDouble();
            clearBuffer(entrada);
            novoImovel = new Ape(valorVenda, endereco, anoConst, taxa);
        } else {
            System.out.println("Digite o valor da venda do imovel:");
            double valorVenda = entrada.nextDouble();
            clearBuffer(entrada);
            System.out.println("Digite o endereço do imovel:");
            String endereco = entrada.nextLine();
            System.out.println("Digite o ano de construção:");
            int anoConst = entrada.nextInt();
            clearBuffer(entrada);
            System.out.println("Digite o valor do seguro anual:");
            double seg = entrada.nextDouble();
            clearBuffer(entrada);
            novoImovel = new Casa(valorVenda, endereco, anoConst, seg);
        }
        return novoImovel;
    }

    private static void imprimirTodosImoveis() {
        for (Imovel imovel : listImoveis) {
            System.out.println(imovel.toString());
        }
    }

    private static void adicionarAcrescimos(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                int opcao = -1;
                do {
                    System.out.println("ADICIONAR UM ACRÉSCIMO AO ALUGUEL:");
                    System.out.println("Digite a descrição:");
                    String desc = entrada.nextLine();
                    System.out.println("Digite a quantidade:");
                    int quant = entrada.nextInt();
                    clearBuffer(entrada);

                    System.out.println("Digite o valor do acréscimo:");
                    double valor = entrada.nextDouble();
                    clearBuffer(entrada);

                    Acrescimos novoAcrescimo = new Acrescimos(desc, quant, valor);
                    imovel.adicionarAcrescimoNaLista(novoAcrescimo);
                    opcao = subAdicionarAcrescimo();
                } while (opcao != 0);
            }
        }

    }

    public static void mostrarAcrescimos(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                imovel.mostrarTodosAcrescimos();
            }
        }
    }

    public static void mostrarValorImovel(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                imovel.mostrarValorImovel();
            }
        }
    }

    public static void calcularComissaoPorPropriedade(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                imovel.calcularComissaoPorAluguel();
            }
        }
    }

    public static void mostrarValorBrutoPorPropriedade(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                imovel.mostrarValorBrutoComCadaPropriedade();
            }
        }
    }

    public static void mostrarValorLiquidoPorPropriedade(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                imovel.mostrarValorLiquidoComCadaPropriedade();
            }
        }
    }

    public static void removerImovelDaLista(int idImovel) {
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                listImoveis.remove(idImovel);
            }
        }
    }

    public static void atualizarImovel(int idImovel) {
        int opcao = -1;
        for (Imovel imovel : listImoveis) {
            if (idImovel == imovel.getId()) {
                // codigo de atualização
                if (imovel.getClass().getName() == "Ape") {
                    opcao = escolherCampoParaAlterar_Ape();
                    System.out.println("==========================");
                    switch (opcao) {
                        case 1:
                            System.out.println("1 - Novo valor para: Valor de venda");
                            double valor = entrada.nextDouble();
                            imovel.setValorVenda(valor);
                            clearBuffer(entrada);
                            break;
                        case 2:
                            System.out.println("2 - Novo valor para: Endereço");
                            String end = entrada.nextLine();
                            imovel.setEndereco(end);
                            break;
                        case 3:
                            System.out.println("3 - Novo valor para: Ano de construção");
                            int ano = entrada.nextInt();
                            imovel.setAnoConstrucao(ano);
                            clearBuffer(entrada);
                            break;
                        case 4:
                            System.out.println("4 - Novo valor para: Taxa mensal de condomínio");
                            // double taxa = entrada.nextDouble();
                            // imovel.setTaxaMensalCondominio(taxa);
                            clearBuffer(entrada);
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } else {
                    opcao = escolherCampoParaAlterar_Casa();
                    switch (opcao) {
                        case 1:
                            System.out.println("1 - Novo valor para: Valor de venda");
                            double valor = entrada.nextDouble();
                            imovel.setValorVenda(valor);
                            clearBuffer(entrada);
                            break;
                        case 2:
                            System.out.println("2 - Novo valor para: Endereço");
                            String end = entrada.nextLine();
                            imovel.setEndereco(end);
                            break;
                        case 3:
                            System.out.println("3 - Novo valor para: Ano de construção");
                            int ano = entrada.nextInt();
                            imovel.setAnoConstrucao(ano);
                            clearBuffer(entrada);
                            break;
                        case 4:
                            System.out.println("4 - Novo valor para: Valor anual do seguro");
                            // double seg = entrada.nextDouble();
                            // imovel.setValorAnualSeguro(seg);
                            clearBuffer(entrada);
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }
            }
        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        int opcao = -1;
        listImoveis = new ArrayList<Imovel>();
        Imovel novoImovel = null;
        do {
            opcao = mostrarOpcoes();
            switch (opcao) {
                case 1:
                    int tipoImovel = subTipoImovel();
                    novoImovel = criarNovoImovel(tipoImovel);
                    listImoveis.add(novoImovel);
                    break;
                case 2:
                    opcao = mostrarOpcoesDeImovel();
                    switch (opcao) {
                        case 1:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                adicionarAcrescimos(idImovel);
                            }
                            break;
                        case 2:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                mostrarAcrescimos(idImovel);
                            }
                            break;
                        case 3:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                mostrarValorImovel(idImovel);
                            }
                            break;
                        case 4:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                calcularComissaoPorPropriedade(idImovel);
                            }
                            break;
                        case 5:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                mostrarValorBrutoPorPropriedade(idImovel);
                            }
                            break;
                        case 6:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                mostrarValorLiquidoPorPropriedade(idImovel);
                            }
                            break;
                        case 7:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                atualizarImovel(idImovel);
                            }
                            break;
                        case 8:
                            if (novoImovel != null) {
                                int idImovel = subEscolherImovel();
                                removerImovelDaLista(idImovel);
                            }
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                case 3:
                    if (listImoveis.size() >= 1) {
                        imprimirTodosImoveis();
                    }
                    break;
                case 4:
                    System.out.println(mostrarGanhoComTodosImoveis());
                    break;
                case 5:
                    int busca = subEscolherAnoDeBusca();
                    System.out.println(buscar_e_imprimirPorAno(busca));
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}
