package Poupando.Poupando;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final TransacaoRepository repository;

    public DashboardService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> gerarDashboard() {
        List<Transacao> todas = repository.findAll();
        LocalDate hoje = LocalDate.now();

        double totalReceitas = todas.stream().filter(t -> t.getTipo().name().startsWith("RECEITA")).mapToDouble(Transacao::getValor).sum();
        double totalFixos = todas.stream().filter(t -> t.getTipo() == Transacao.TipoTransacao.DESPESA_FIXA).mapToDouble(Transacao::getValor).sum();
        double totalVariaveis = todas.stream().filter(t -> t.getTipo() == Transacao.TipoTransacao.DESPESA_VARIAVEL).mapToDouble(Transacao::getValor).sum();

        double saldoAtual = totalReceitas - (totalFixos + totalVariaveis);
        
        LocalDate proximoPagamento;
        if (hoje.getDayOfMonth() < 15) {
            proximoPagamento = hoje.withDayOfMonth(15);
        } else {
            proximoPagamento = hoje.plusMonths(1).withDayOfMonth(5);
        }

        long diasRestantes = ChronoUnit.DAYS.between(hoje, proximoPagamento);
        if (diasRestantes == 0) diasRestantes = 1;

        double metaDiaria = saldoAtual / diasRestantes;

        Map<String, Object> dados = new HashMap<>();
        dados.put("saldo", saldoAtual);
        dados.put("gastosFixos", totalFixos);
        dados.put("gastosVariaveis", totalVariaveis);
        dados.put("diasAteSalario", diasRestantes);
        dados.put("metaDiaria", metaDiaria);
        
        String insight;
        if (saldoAtual < 0) {
            insight = "🚨 ALERTA: Você está no negativo. Pare gastos variáveis!";
        } else if (metaDiaria < 20) {
            insight = "⚠️ APERTO: Apenas R$ " + String.format("%.2f", metaDiaria) + " por dia. Evite gastos.";
        } else {
            insight = "✅ OK: Pode gastar até R$ " + String.format("%.2f", metaDiaria) + " por dia.";
        }
        dados.put("insight", insight);

        return dados;
    }
}