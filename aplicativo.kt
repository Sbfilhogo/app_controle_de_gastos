import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val gastoManager = GastoManager()

    var opcao: Int

    do {
        exibirMenu()
        print("Escolha uma opção: ")
        opcao = scanner.nextInt()
        when (opcao) {
            1 -> gastoManager.listarGastos()
            2 -> gastoManager.cadastrarGasto(scanner)
            0 -> println("Saindo...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != 0)
}

fun exibirMenu() {
    println("==== Menu ====")
    println("1. Listar gastos")
    println("2. Cadastrar gasto")
    println("0. Sair")
}

data class Gasto(val descricao: String, val preco: Double, val categoria: String)

class GastoManager {
    private val gastos = mutableListOf<Gasto>()

    fun listarGastos() {
        if (gastos.isEmpty()) {
            println("Nenhum gasto cadastrado.")
        } else {
            println("==== Lista de Gastos ====")
            gastos.forEachIndexed { index, gasto ->
                println("${index + 1}. Descrição: ${gasto.descricao}, Preço: ${gasto.preco}, Categoria: ${gasto.categoria}")
            }
        }
    }

    fun cadastrarGasto(scanner: Scanner) {
        println("==== Cadastro de Gasto ====")
        print("Descrição: ")
        val descricao = scanner.next()
        print("Preço: ")
        val preco = scanner.nextDouble()
        print("Categoria: ")
        val categoria = scanner.next()
        val novoGasto = Gasto(descricao, preco, categoria)
        gastos.add(novoGasto)
        println("Gasto cadastrado com sucesso!")
    }
}
