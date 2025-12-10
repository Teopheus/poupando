package Poupando.Poupando;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FinanceiroController {

    private final TransacaoRepository repository;
    private final DashboardService service;

    public FinanceiroController(TransacaoRepository repository, DashboardService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {
        return service.gerarDashboard();
    }

    @GetMapping("/transacoes")
    public List<Transacao> listar() {
        return repository.findAll();
    }

    @PostMapping("/transacoes")
    public Transacao adicionar(@RequestBody Transacao nova) {
        return repository.save(nova);
    }

    // --- NOVO: Endpoint para apagar tudo ---
    @DeleteMapping("/transacoes")
    public void limparTudo() {
        repository.deleteAll();
    }
}