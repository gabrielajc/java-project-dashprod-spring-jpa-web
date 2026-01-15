package com.br.dashProd.model;

import java.util.Map;
import java.util.UUID;

public record JobDTO(UUID id, String type, Map<String, Object> params) {
}
