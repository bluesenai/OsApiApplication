
package br.dev.blue.OsApiApplication.domain.service;

import br.dev.blue.OSApiApplication.domain.exception.DomainException;
import br.dev.blue.OsApiApplication.domain.model.OrdemServico;
import br.dev.blue.OsApiApplication.domain.model.StatusOrdemServico;
import br.dev.blue.OsApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    }
    public Optional<OrdemServico> atualizaStatus(Long ordemServicoID, StatusOrdemServico status) {
        
        Optional<OrdemServico> optOrdemServico = ordemServicoRepository.findById(ordemServicoID);
        
        if (optOrdemServico.isPresent()) {
            
            OrdemServico ordemServico = optOrdemServico.get();
            
            if (ordemServico.getStatus()==StatusOrdemServico.ABERTA
                    && status != StatusOrdemServico.ABERTA) {
            
            ordemServico.setStatus(status);
            ordemServico.setDataFinalizacao(LocalDateTime.now());
            ordemServicoRepository.save(ordemServico);
            return Optional.of(ordemServico);
            
        }else{
                
                return Optional.empty();
        }
        
        }else{
            
            throw new DomainException("Não existe OS com o id" + ordemServicoID);
        }    
    }

    public List<OrdemServico> listarPorCliente(Long clienteId) {
         return ordemServicoRepository.findByClienteId(clienteId);
     }
}