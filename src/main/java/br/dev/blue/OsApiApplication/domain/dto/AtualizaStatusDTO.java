
package br.dev.blue.OsApiApplication.domain.dto;

import br.dev.blue.OsApiApplication.domain.model.StatusOrdemServico;
import jakarta.validation.constraints.NotNull;

public record AtualizaStatusDTO(
        @NotNull(message = "Status é obrigatório")
        StatusOrdemServico status
        ) {}
