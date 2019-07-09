# Healthier Life

Projeto voltado para registrar refeições por meio de fotos e obter insights de uma possível alimentação melhor através de Machine Learning usando como base o seguinte projeto, https://github.com/arielf/weight-loss.

Arquitetura do projeto:

- **MainActivity**: Arquivo contendo a atividade principal do sistema que controla tanto a navegação entre telas através de **Fragments**, quanto a execução da camera via **Intent**.
- **fragments**: Todos os fragments do projeto.
    - **Meals/InsightsFragment**: Fragmentos que possuem a lista de dados e instanciam e povoam a *RecyclerView*.
    - **MealDetailsFragment**: Fragmento que possue uma visão mais detalhada da refeição realizada.
    - **AddMealFragment**: Fragmento no qual é possível adicionar uma refeição.
- **views**: Todos os *ViewHolders* necessários para as *RecyclerViews* para especificar como povoar o item da lista.
- **adapters**: Todos os *Adapters* respectivos as *RecyclerViews* (Essas classes foram refatoradas para um *Adapter* ao invês de *ListAdapter* para possibilitar setar os items da lista por fora do objeto).
- **database.models**: Todos os modelos dos dados a serem utilizados na aplicação, modelados com auxilio da biblioteca Room.
- **database.daos**: Todas as interfaces para realizar operações sobre os dados (Graças ao Room só é preciso dizer a query que o código é gerado dinamicamente).
- **database.AppDatabase**: Entidade representando o banco da apliação (Uso dessa classe é um requerimento da biblioteca).
- **database.Converters**: Classe que específica como converter de certos objetos de tipos não primários para primários ao salvar no banco de dados.
- **utils.API**: Classe que executa e representa requisições a serem realizadas na API.
- **utils.DB**: Singleton de acesso ao AppDatabase.
- **utils.DoAsnyc**: Utilitario para executar qualquer código assincronamente.

* Sobre os testes acabou que não foi implementado decorrente do tempo e do servidor os insights são gerados estáticamente visto que também não teve tempo para implementação do servidor com o vowpal-wabbit.