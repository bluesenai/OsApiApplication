
package br.dev.blue.OsApiApplication.domain.repository;

import br.dev.blue.OsApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
}
