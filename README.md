💰 Poupando - Gestão Financeira Inteligente

Aplicação Full Stack de controlo financeiro focada no fluxo de caixa quinzenal/mensal. O sistema não apenas regista gastos, mas oferece insights de sobrevivência financeira, calculando a meta de gasto diário segura baseada no saldo e dias restantes até ao próximo salário.

🚀 Funcionalidades

Dashboard Inteligente: Velocímetro de gastos e cálculo automático de "Meta Diária".

Gestão de Transações: Lançamento de Receitas, Despesas Fixas e Variáveis.

Visualização de Dados: Gráfico de Rosca (Doughnut Chart) para análise de orçamento.

Interface Moderna: Design responsivo, Modo Escuro (Dark Mode) e notificações Toast.

Backup & Reset: Exportação de dados para CSV e limpeza total da base de dados.

🛠️ Tecnologias Utilizadas

Backend (Java)

Spring Boot 3: Framework principal.

Spring Data JPA: Persistência de dados.

H2 Database: Banco de dados em memória (para facilidade de testes).

Maven: Gestão de dependências.

Frontend (Web)

HTML5 / CSS3: Layout responsivo e estilização moderna (Glassmorphism/Fintech style).

JavaScript (ES6+): Lógica de consumo da API (Fetch), manipulação do DOM.

Chart.js: Renderização de gráficos financeiros.

FontAwesome: Ícones de interface.

📦 Como Rodar o Projeto

Pré-requisitos

Java 17 ou superior instalado.

Maven (opcional, o projeto inclui o wrapper mvnw).

Passos

Clone o repositório:

git clone [https://github.com/SEU_USUARIO/poupando.git](https://github.com/SEU_USUARIO/poupando.git)
cd poupando


Execute o Backend:

./mvnw spring-boot:run


Aceda à aplicação:
Abra o navegador em http://localhost:8080

🧠 Lógica de Negócio (O Diferencial)

O sistema diferencia Despesas Fixas (obrigatórias) de Variáveis (controláveis). O algoritmo de "Insight" calcula:

(Receitas - Despesas Fixas - Gastos Variáveis Já Feitos) / Dias até o Pagamento

Isso resulta num valor diário que o utilizador pode gastar sem comprometer as contas futuras.

Desenvolvido para fins de estudo e portfólio.
